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
import mobi.designmyapp.common.container.model.ContainerConfig;
import mobi.designmyapp.common.container.provider.ContainerProvider;
import mobi.designmyapp.common.container.strategy.ContainerProviderSelectionStrategy;

import java.util.Collection;
import java.util.List;

/**
 * This interface represents an container manager
 * (@see mobi.designmyapp.common.instance.provider.ContainerProvider),
 * this manager is used to store a Set of container providers and manage your containers using
 * a predefined strategy (@see mobi.designmyapp.common.instance.strategy.ContainerSelectionStrategy)
 * The ContainerManager singleton can be retrieved by the @see mobi.designmyapp.common.instance.service.ContainerService class.
 * Created by Alexandre Nunesse on 24/02/2015.
 */
public interface ContainerManager {

  void addProvider(ContainerProvider containerProvider, int priority);

  void addProvider(ContainerProvider containerProvider);

  /**
   * Start a new container.
   * WARNING: if you need to launch multiple containers, use {@link #startContainers(mobi.designmyapp.common.container.model.ContainerConfig...)} instead.
   *
   * @param config the container config
   * @return the live container
   */
  Container startContainer(ContainerConfig config);

  /**
   * Start a new set of containers.
   * Those containers will be launched on the same provider.
   *
   * @param configs the container configs
   * @return the live containers
   */
  List<Container> startContainers(ContainerConfig... configs);

  /**
   * Start a new container with a specific time-to-live (in minutes).
   *
   * @param ttl    the container's time-to-live in minutes. After the TTL is expired, the container will be killed.
   * @param config the container config
   * @return the live container
   */
  Container startContainer(int ttl, ContainerConfig config);

  /**
   * Start a new set of containers with a specific time-to-live (in minutes).
   * Those containers will be launched on the same provider.
   *
   * @param ttl    the container's time-to-live in minutes. After the TTL is expired, the container will be killed.
   * @param configs the container configs
   * @return the live containers
   */
  List<Container> startContainers(int ttl, ContainerConfig... configs);

  void stopContainer(String containerId);

  Container restartContainer(String containerId);

  Collection<ContainerProvider> getContainerProviders();

  void setContainerProviders(Collection<ContainerProvider> containerProviders);

  Container getContainer(String containerId);

  void setStrategy(ContainerProviderSelectionStrategy strategy);

}
