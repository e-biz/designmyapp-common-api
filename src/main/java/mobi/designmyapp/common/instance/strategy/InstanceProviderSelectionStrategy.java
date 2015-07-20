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
package mobi.designmyapp.common.instance.strategy;

import mobi.designmyapp.common.instance.model.Status;
import mobi.designmyapp.common.instance.provider.InstanceProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Anas Hammani on 17/07/15.
 * This class represents an instance provider selection strategy used to define how an
 * instance manager will be selected
 */
public enum InstanceProviderSelectionStrategy {
  FIRST_INSTANCE {
    @Override
    public InstanceProvider selectInstanceProvider(Collection<InstanceProvider> instanceProviders) {
      for (InstanceProvider iProvider : instanceProviders) {
        if (!Status.SHUTDOWN.equals(iProvider.getStatus())) {
          return iProvider;
        }
      }
      return null;
    }
  },

  ROUND_ROBIN {
    private int lastIndex = -1;

    @Override
    public InstanceProvider selectInstanceProvider(Collection<InstanceProvider> instanceProviders) {
      List<InstanceProvider> instanceProvidersList = new ArrayList<>(instanceProviders);
      int nbInstances = instanceProvidersList.size();
      int tmpLastIndex = lastIndex;
      for (int i = 1; i <= nbInstances; i++) {
        int index = (tmpLastIndex + i) % nbInstances;
        InstanceProvider instanceProvider = instanceProvidersList.get(index);
        if (Status.RUNNING.equals(instanceProvider.getStatus())) {
          lastIndex = index;
          return instanceProvider;
        }
      }
      return null;
    }
  };

  public abstract InstanceProvider selectInstanceProvider(Collection<InstanceProvider> instanceProviders);
}
