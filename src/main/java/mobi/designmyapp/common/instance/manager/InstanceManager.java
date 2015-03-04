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
package mobi.designmyapp.common.instance.manager;

import mobi.designmyapp.common.instance.model.Instance;
import mobi.designmyapp.common.instance.provider.InstanceProvider;
import mobi.designmyapp.common.instance.strategy.InstanceProviderSelectionStrategy;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * This interface represents an instance provider manager
 * (@see mobi.designmyapp.common.instance.provider.InstanceProvider),
 * this manager is used to store a Set of instance providers and manage their instances using
 * a predefined strategy (@see mobi.designmyapp.common.instance.strategy.InstanceSelectionStrategy)
 * The InstanceManager singleton can be retrieved by the @see mobi.designmyapp.common.instance.service.InstanceService class.
 * Created by Alexandre Nunesse on 24/02/2015.
 */
public interface InstanceManager {

  void addProvider(InstanceProvider instanceProvider, int priority);

  void addProvider(InstanceProvider instanceProvider);

  Instance startInstance(String dockerImage,List<String> options, List<String> args);

  void stopInstance(String instanceId);

  Instance restartInstance(String instanceId);

  Collection<InstanceProvider> getInstanceProviders();
  
  Instance getInstance(String instanceID);

}
