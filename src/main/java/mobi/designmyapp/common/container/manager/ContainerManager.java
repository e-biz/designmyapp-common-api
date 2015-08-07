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
package mobi.designmyapp.common.container.manager;

import mobi.designmyapp.common.container.model.Container;
import mobi.designmyapp.common.container.provider.Node;
import mobi.designmyapp.common.container.strategy.NodeSelectionStrategy;

import java.util.Collection;
import java.util.List;

/**
 * This interface represents an container manager
 * (@see mobi.designmyapp.common.container.provider.Node),
 * this manager is used to store a Set of nodes and manage your containers using
 * a predefined strategy (@see mobi.designmyapp.common.instance.strategy.ContainerSelectionStrategy)
 * The ContainerManager singleton can be retrieved by the @see mobi.designmyapp.common.instance.service.ContainerService class.
 * Created by Alexandre Nunesse on 24/02/2015.
 */
public interface ContainerManager {
  /**
   * Add a node to the ContainerManager.
   *
   * @param node the node to add
   * @param priority          the node priority
   */
  void addNode(Node node, int priority);


  /**
   * Add a node to the ContainerManager.
   *
   * @param node the node to add
   */
  void addNode(Node node);

  /**
   * Start a new container.
   * WARNING: if you need to launch multiple containers, use {@link #startContainers(mobi.designmyapp.common.container.model.Container...)} instead.
   *
   * @param config the container config
   */
  void startContainer(Container config);

  /**
   * Start a new set of containers.
   * Those containers will be launched on the same node.
   *
   * @param configs the container configs
   */
  void startContainers(Container... configs);

  /**
   * Start a new container with a specific time-to-live (in minutes).
   *
   * @param ttl    the container's time-to-live in minutes. After the TTL is expired, the container will be killed.
   * @param config the container config
   */
  void startContainer(int ttl, Container config);

  /**
   * Start a new set of containers with a specific time-to-live (in minutes).
   * Those containers will be launched on the same node.
   *
   * @param ttl     the container's time-to-live in minutes. After the TTL is expired, the container will be killed.
   * @param configs the container configs
   */
  void startContainers(int ttl, Container... configs);

  /**
   * Stop a container.
   *
   * @param containerId the container id
   */
  void stopContainer(String containerId);

  /**
   * Restart a container.
   *
   * @param containerId the container id
   * @return the container dto
   */
  Container restartContainer(String containerId);

  /**
   * Get all nodes.
   *
   * @return a collection of node
   */
  Collection<Node> getNodes();

  /**
   * Set the nodes.
   * @param nodes the node set
   */
  void setNodes(Collection<Node> nodes);

  /**
   * Find a container by its id.
   *
   * @param containerId the container id
   * @return the container dto
   */
  Container getContainer(String containerId);

  /**
   * Retrieve the containers for an appId.
   *
   * @param appId the app id
   * @return the list of containers or null if none
   */
  List<Container> getContainers(String appId);

  /**
   * Set strategy.
   *
   * @param strategy the strategy.
   * @see NodeSelectionStrategy
   */
  void setStrategy(NodeSelectionStrategy strategy);

  /**
   * If set to true, will replace oldest container when container manager is full.
   * Otherwise, will throw an exception.
   *
   * @param enabled replace oldest container on overload
   */
  void setReplaceOldestWhenFull(boolean enabled);

}
