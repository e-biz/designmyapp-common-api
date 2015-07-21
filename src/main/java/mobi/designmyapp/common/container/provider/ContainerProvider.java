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

import mobi.designmyapp.common.container.model.Container;
import mobi.designmyapp.common.container.model.ContainerConfig;
import mobi.designmyapp.common.container.model.Status;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This class represents an container provider, a provider manage
 * containers (@see mobi.designmyapp.common.container.model.Container)
 * Created by Jean Blanchard on 28/10/14.
 */
public abstract class ContainerProvider implements Comparable<ContainerProvider> {

  protected String templateTag;
  private ConcurrentLinkedQueue<Container> containers;
  protected Integer poolSize;
  protected Integer ttl;
  protected Integer priority;

  /**
   * Constructor.
   * @param templateTag the template tag
   */
  public ContainerProvider(String templateTag) {
    this.templateTag = templateTag;
    this.containers = new ConcurrentLinkedQueue<>();
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
   * Update a container.
   * @param containers
   */
  protected void updateContainers(List<Container> containers) {
    //TODO
  }

  /**
   * Remove a container.
   * @param container
   */
  protected void removeContainer(Container container) {
    //TODO
  }

  /**
   * Refresh the status of the containers.
   */
  public abstract void refreshContainersState();

  /**
   * Retrieve a single container by its id, null if the id is not found.
   *
   * @param containerId container id to retrieve
   * @return the container or null if not found
   */
  public Container getContainer(String containerId) {
    for (Container container : containers) {
      if (container.getUuid().equals(containerId)) {
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

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * Friendly name for this provider.
   *
   * @return the name of the provider
   */
  public String getName() {
    return ContainerProvider.class.getSimpleName();
  }

  /**
   * Start a new container.
   *
   * @param config the container config
   * @return the started container if no errors append
   */
  public abstract Container start(ContainerConfig config);

  /**
   * Start a new container set.
   *
   * @param configs the container configs
   * @return the started container if no errors append
   */
  public abstract List<Container> start(ContainerConfig... configs);

  /**
   * Terminate an container.
   *
   * @param containerId container id to terminate
   */
  public abstract void stop(String containerId);

  /**
   * Restart an container.
   *
   * @param containerId container Id to restart
   * @return the restarted container
   */
  public abstract Container restart(String containerId);

  /**
   * Retrieve the status of this ContainerProvider.
   *
   * @return ContainerProvider status @see mobi.designmyapp.common.container.model.Status
   */
  public abstract Status getStatus();

  /**
   * Indicate if the ContainerProvider can create containers checking poolSize
   * and running containers List.
   *
   * @return boolean indicating whether a new container can be started.
   */
  public boolean canCreateContainer() {
    return getActiveCount() < this.poolSize;
  }

  /**
   * Indicate if the ContainerProvider can create containers checking poolSize
   * and running containers List.
   *
   * @param size the number of containers to create.
   * @return boolean indicating whether a new container can be started.
   */
  public boolean canCreateContainers(int size) {
    return getActiveCount() < (this.poolSize - size);
  }

  /**
   * Retrieve the number of RUNNING containers.
   *
   * @return number of RUNNING containers
   */
  public int getActiveCount() {
    return containers.size();
  }

  /**
   * Return the provider-level time-to-live for default containers.
   *
   * @return time-to-live
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * @return retrieves and removes the oldest container
   */
  public Container pollOldestContainer() {
    return containers.poll();
  }

  /**
   * Retrieve hostname endpoint.
   *
   * @return hostname endpoint url
   */
  public abstract String getHostname();

  /**
   * Default implementation of compareTo for the ContainerManager.
   */
  @Override
  public int compareTo(ContainerProvider containerProvider) {
    if (this.getPriority().equals(containerProvider.getPriority())) {
      return this.getName().compareTo(containerProvider.getName());
    } else {
      return this.getPriority().compareTo(containerProvider.getPriority());
    }
  }


}