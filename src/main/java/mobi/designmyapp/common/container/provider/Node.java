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
package mobi.designmyapp.common.container.provider;

import mobi.designmyapp.common.container.listener.NodeChangeListener;
import mobi.designmyapp.common.container.model.Container;
import mobi.designmyapp.common.container.model.ContainerStatus;
import mobi.designmyapp.common.container.model.Status;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This class represents a node, a node manage
 * containers (@see mobi.designmyapp.common.container.model.Container)
 * Created by Jean Blanchard on 28/10/14.
 */
public abstract class Node implements Comparable<Node> {

  protected String templateTag;
  protected Integer poolSize;
  protected Integer ttl;
  protected Integer priority;
  protected Boolean active;
  private ConcurrentLinkedQueue<Container> containers;
  private NodeChangeListener listener;
  private ConcurrentLinkedQueue<String> containersToClean;

  /**
   * Default constructor.
   */
  public Node() {
    this.containers = new ConcurrentLinkedQueue<>();
    this.containersToClean = new ConcurrentLinkedQueue<>();
    this.active = true;
  }

  /**
   * Constructor.
   *
   * @param templateTag the template tag
   */
  public Node(String templateTag) {
    this();
    this.templateTag = templateTag;
  }

  /**
   * Retrieve deployed containers.
   *
   * @return deployed containers
   */
  public List<Container> getContainers() {
    return Collections.unmodifiableList(new LinkedList<>(containers));
  }

  /**
   * Set containers.
   *
   * @param containers the containers
   */
  public void setContainers(List<Container> containers) {
    ConcurrentLinkedQueue<Container> concurrent = new ConcurrentLinkedQueue<>();
    concurrent.addAll(containers);
    this.containers = concurrent;
  }

  /**
   * Get listener.
   *
   * @return the listener
   */
  public NodeChangeListener getListener() {
    return listener;
  }

  /**
   * Set the NodeChangeListener.
   *
   * @param listener the listener to notify.
   */
  public void setListener(NodeChangeListener listener) {
    this.listener = listener;
  }

  /**
   * Refresh the status of the containers.
   */
  public abstract void refreshContainersState();

  /**
   * @return the number of containers present, whatever their state is
   */
  public int getActiveCount() {
    return containers.size();
  }

  /**
   * Retrieve a single container by its id, null if the id is not found.
   *
   * @param containerId container id to retrieve
   * @return the container or null if not found
   */
  public Container getContainer(String containerId) {
    for (Container container : containers) {
      if (container.getContainerId().equals(containerId)) {
        return container;
      }
    }
    return null;
  }

  public Integer getPoolSize() {
    return poolSize;
  }

  public void setPoolSize(Integer poolSize) {
    this.poolSize = poolSize;
  }


  /**
   * Friendly name for this node.
   *
   * @return the name of the node
   */
  public String getName() {
    return Node.class.getSimpleName();
  }

  /**
   * @return the priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * The priority is an arbitrary number.
   * Default value is 0.
   * The lower the priority, the more important:
   * Priority 0 - Highest importance (will be preferred when choosing one of the Node instances)
   * Priority 1 - High importance
   * Priority 2 - Lower importance
   * ... etc...
   *
   * @param priority the priority value
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * Boolean which check if a node is a active or not.
   */
  public void setActive(Boolean active) {
    this.active = active;
  }


  public Boolean getActive() {
    return active;
  }

  /**
   * Return the node-level time-to-live for default containers.
   *
   * @return time-to-live
   */
  public Integer getTtl() {
    return ttl;
  }

  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }

  /**
   * Retrieve endpoint endpoint.
   *
   * @return endpoint endpoint url
   */
  public abstract String getEndpoint();


  /**
   * Retrieve the status of this Node.
   *
   * @return Node status @see mobi.designmyapp.common.container.model.Status
   */
  public abstract Status getStatus();

  public String getTemplateTag() {
    return templateTag;
  }

  public void setTemplateTag(String templateTag) {
    this.templateTag = templateTag;
  }

  /**
   * Indicate if the Node can create containers checking poolSize
   * and running containers List.
   *
   * @return boolean indicating whether a new container can be started.
   */
  public boolean canCreateContainer() {
    return getActiveCount() < this.poolSize;
  }

  /**
   * Indicate if the Node can create containers checking poolSize
   * and running containers List.
   *
   * @param size the number of containers to create.
   * @return boolean indicating whether a new container can be started.
   */
  public boolean canCreateContainers(int size) {
    return getActiveCount() < (this.poolSize - size);
  }

  /**
   * @return retrieves and removes the oldest container
   */
  public Container pollOldestContainer() {
    return containers.poll();
  }

  /**
   * Start a new container.
   *
   * @param config the container config
   */
  public abstract void start(Container config);

  /**
   * Start a new container set.
   *
   * @param configs the container configs
   */
  public abstract void start(Container... configs);

  /**
   * Terminate a container.
   *
   * @param containerId container id to terminate
   */
  public abstract void stop(String containerId);

  /**
   * Restart a container.
   *
   * @param containerId container Id to restart
   * @return the updated container
   */
  public abstract Container restart(String containerId);

  /**
   * Remove a container.
   *
   * @param containerId container id to terminate
   */
  public abstract void remove(String containerId);

  /**
   * Add a container.
   *
   * @param container the container to add
   */
  protected void addContainer(Container container) {
    containers.add(container);
    notifyContainersChanged();
  }

  /**
   * Add a serie of containers.
   *
   * @param containers the containers to add
   */
  protected void addContainers(Container... containers) {
    this.containers.addAll(Arrays.asList(containers));
    notifyContainersChanged();
  }

  /**
   * Update containers states.
   *
   * @param updatedContainers the updated containers
   */
  protected void updateContainers(List<ContainerStatus> updatedContainers) {
    // Updates the containers DesignMyApp knows about.
    for (Container c : this.containers) {
      ContainerStatus status = this.equalsContainerStatus(c, updatedContainers);
      if (status != null) {
        // Container is still remotely present. Update state
        mergeStates(c, status);
      } else {
        // Container is absent remotely. Remove from list.
        // N.B.: deletion while iterating is possible because we use a ConcurrentLinkedQueue implementation.
        containers.remove(c);
      }
    }
    notifyContainersChanged();
  }

  /**
   * Check if a ContainerStatus match this node
   * @param statusList
   * @return
   */
  protected ContainerStatus equalsContainerStatus(Container container,List<ContainerStatus> statusList) {
    for (ContainerStatus status : statusList) {
      //Can't add container.getName().equals(status.getName()) in if
      // because status name has a leading "/"
      if (status.getContainerId().startsWith(container.getContainerId())) {
        return status;
      }
    }
    return null;
  }

  /**
   * Remove a container.
   *
   * @param container the container
   */
  protected void removeContainer(Container container) {
    containers.remove(container);
    notifyContainersChanged();
  }

  /**
   * Add a container to the clean-up list.
   * That means the container will be removed after completion.
   *
   * @param container the clean-up container
   */
  protected void addContainerToClean(Container container) {
    containersToClean.add(container.getContainerId());
  }

  /**
   * Merges the state of the second container into the first one.
   *
   * @param container the container to merge the state to.
   * @param newStatus the container with the updated state.
   */
  protected void mergeStates(Container container, ContainerStatus newStatus) {
    if (container.getOptions().getType() == Container.Type.COMMAND) {
      Container.CommandOptions options = ((Container.CommandOptions) container.getOptions());
      Map<Integer, Integer> newMap = new HashMap<>();
      if (newStatus.getPortMap() == null) {
        newStatus.setPortMap(new HashMap<>());
      }
      for (Map.Entry<String, String> ports : newStatus.getPortMap().entrySet()) {
        newMap.put(Integer.valueOf(ports.getKey()), Integer.valueOf(ports.getValue()));
      }
      options.setPortMap(newMap);
    }
    String id = newStatus.getContainerId().replace("\"", "");
    container.setName(newStatus.getName());
    container.setContainerId(id);
    container.setProgress(newStatus.getProgress());
    container.setStatus(newStatus.getStatus());
    container.setEndpoint(newStatus.getEndpoint());

    // If container was a clean-up container, trigger removal.
    if (container.getStatus().equals(Status.SHUTDOWN) && containersToClean.contains(container.getContainerId())) {
      remove(container.getContainerId());
    }
  }

  /**
   * Notifies the eventual listener that there was a change on the Node.
   */
  private void notifyContainersChanged() {
    if (listener != null) {
      listener.onNodeChanged(this);
    }
  }

  /**
   * Default implementation of compareTo for the ContainerManager.
   * Ordering is by priority and name when priority is equal.
   */
  @Override
  public int compareTo(Node node) {
    if (this.getPriority().equals(node.getPriority())) {
      return this.getName().compareTo(node.getName());
    } else {
      return this.getPriority().compareTo(node.getPriority());
    }
  }


}