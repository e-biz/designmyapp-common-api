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
import mobi.designmyapp.common.container.provider.ContainerProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Anas Hammani on 17/07/15.
 * This class represents an instance provider selection strategy used to define how an
 * instance manager will be selected
 */
public enum ContainerProviderSelectionStrategy {

  FIRST_CONTAINER {
    @Override
    public ContainerProvider selectContainerProvider(Collection<ContainerProvider> containerProviders, int size, boolean replaceOldestWhenFull) {
      // Used to store the ideal candidate when all instance providers are full.
      ContainerProvider firstFullCandidate = null;

      for (ContainerProvider provider : containerProviders) {
        if (Status.RUNNING.equals(provider.getStatus())) {
          if (provider.canCreateContainer()) {
            // There is room, let's go.
            return provider;
          } else {
            // InstanceProvider is full. Store first candidate
            if (firstFullCandidate == null) {
              firstFullCandidate = provider;
            }
          }
        }
      }
      // All instance providers are full, but this one is the best according to the current strategy.
      if (firstFullCandidate != null && replaceOldestWhenFull) {
        return firstFullCandidate;
      }
      return null;
    }
  },

  ROUND_ROBIN {
    private int lastIndex = -1;

    @Override
    public ContainerProvider selectContainerProvider(Collection<ContainerProvider> containerProviders, int size, boolean replaceOldestWhenFull) {
      List<ContainerProvider> containerProvidersList = new ArrayList<>(containerProviders);
      int providerSize = containerProvidersList.size();
      int tmpLastIndex = lastIndex;
      ContainerProvider firstFullCandidate = null;

      for (int i = 1; i <= providerSize; i++) {
        int index = (tmpLastIndex + i) % providerSize;
        ContainerProvider containerProvider = containerProvidersList.get(index);
        if (Status.RUNNING.equals(containerProvider.getStatus())) {
          // InstanceProvider running, we can check stuff.
          if (containerProvider.canCreateContainers(size)) {
            // There is room, let's go.
            lastIndex = index;
            return containerProvider;
          } else {
            // InstanceProvider is full. Store first candidate
            if (firstFullCandidate == null && containerProvider.getPoolSize() >= size) {
              firstFullCandidate = containerProvider;
            }
          }
        }
      }
      // All instance providers are full, but this one is the best according to the current strategy.
      if (firstFullCandidate != null && replaceOldestWhenFull) {
        return firstFullCandidate;
      }
      return null;
    }
  };

  /**
   * Describe the strategy for pick a ContainerProvider.
   * @param containerProviders the containerProviders collection
   * @param size the pool size
   * @param replaceOldestWhenFull true if we want to replace oldest containerProvider when pool is full
   * @return the chosen ContainerProvider
   */
  public abstract ContainerProvider selectContainerProvider(Collection<ContainerProvider> containerProviders, int size, boolean replaceOldestWhenFull);

  /**
   * Describe the strategy for pick a ContainerProvider.
   * @param containerProviders the containerProviders collection
   * @param replaceOldestWhenFull true if we want to replace oldest containerProvider when pool is full
   * @return the chosen ContainerProvider
   */
  public ContainerProvider selectContainerProvider(Collection<ContainerProvider> containerProviders, boolean replaceOldestWhenFull) {
    return selectContainerProvider(containerProviders, 1, replaceOldestWhenFull);
  }
}
