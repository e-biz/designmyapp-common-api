/*
 Copyright 2015 eBusiness Information
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package mobi.designmyapp.common.container.strategy;

import mobi.designmyapp.common.container.model.Status;
import mobi.designmyapp.common.container.provider.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Anas Hammani on 17/07/15.
 * This class represents an node selection strategy used to define how an
 * container manager will be selected
 */
public enum NodeSelectionStrategy {

  FIRST_CONTAINER {
    @Override
    public Node selectNode(Collection<Node> nodes, int size, boolean
            replaceOldestWhenFull) {
      // Used to store the ideal candidate when all nodes are full.
      Node firstFullCandidate = null;

      for (Node node : nodes) {
        if (Status.RUNNING.equals(node.getStatus())) {
          if (node.canCreateContainer()) {
            // There is room, let's go.
            return node;
          } else {
            // Node is full. Store first candidate
            if (firstFullCandidate == null) {
              firstFullCandidate = node;
            }
          }
        }
      }
      // All nodes are full, but this one is the best according to the current strategy.
      if (firstFullCandidate != null && replaceOldestWhenFull) {
        return firstFullCandidate;
      }
      return null;
    }
  },

  ROUND_ROBIN {
    private int lastIndex = -1;

    @Override
    public Node selectNode(Collection<Node> nodes, int size, boolean replaceOldestWhenFull) {
      List<Node> nodesList = new ArrayList<>(nodes);
      int nodeSize = nodesList.size();
      int tmpLastIndex = lastIndex;
      Node firstFullCandidate = null;

      for (int i = 1; i <= nodeSize; i++) {
        int index = (tmpLastIndex + i) % nodeSize;
        Node node = nodesList.get(index);
        if (Status.RUNNING.equals(node.getStatus())) {
          // Node running, we can check stuff.
          if (node.canCreateContainers(size)) {
            // There is room, let's go.
            lastIndex = index;
            return node;
          } else {
            // Node is full. Store first candidate
            if (firstFullCandidate == null && node.getPoolSize() >= size) {
              firstFullCandidate = node;
            }
          }
        }
      }
      // All nodes are full, but this one is the best according to the current strategy.
      if (firstFullCandidate != null && replaceOldestWhenFull) {
        return firstFullCandidate;
      }
      return null;
    }
  };

  /**
   * Describe the strategy for pick a Node.
   * @param nodes the nodes collection
   * @param size the pool size
   * @param replaceOldestWhenFull true if we want to replace oldest node when pool is full
   * @return the chosen Node
   */
  public abstract Node selectNode(Collection<Node> nodes, int size, boolean
          replaceOldestWhenFull);

  /**
   * Describe the strategy for pick a Node.
   * @param nodes the nodes collection
   * @param replaceOldestWhenFull true if we want to replace oldest node when pool is full
   * @return the chosen Node
   */
  public Node selectNode(Collection<Node> nodes, boolean replaceOldestWhenFull) {
    return selectNode(nodes, 1, replaceOldestWhenFull);
  }
}
