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
package mobi.designmyapp.common.instance.provider;

import mobi.designmyapp.common.instance.model.Instance;
import mobi.designmyapp.common.instance.model.Status;

import java.util.List;

/**
 * This class represents an instance provider, a provider manage
 * instances (@see mobi.designmyapp.common.instance.model.Instance)
 * Created by Jean Blanchard on 28/10/14.
 */
public abstract class InstanceProvider implements Comparable<InstanceProvider> {

  protected List<Instance> instances;
  protected Integer poolSize;
  protected Integer ttl;
  protected Integer priority;

  /**
   * Retrieve deployed instances.
   * @return deployed instances
   */
  public abstract List<Instance> getInstances();

  /**
   * Refresh the status of the instances.
   */
  public abstract void refreshInstancesState();

  /**
   * Retrieve a single instance by its id, null if the id is not found.
   * @param instanceId instance id to retrieve
   * @return the instance or null if not found
   */
  public abstract Instance getInstance(String instanceId);

  public Integer getPoolSize(){
    return poolSize;
  }

  public void setPoolSize(Integer poolSize){
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
   * @return the name of the provider
   */
  public abstract String getName();

  /**
   * Start a new instance.
   * @param imageName String representing the kind of instance to launch
   * @param options List representing the option to use when starting the instance
   * @param args List representing the args to use when starting the instance
   * @return the started instance if no errors append
   */
  public abstract Instance start(String imageName, List<String> options, List<String> args);

  /**
   * Terminate an instance.
   * @param instanceId instance id to terminate
   */
  public abstract void stop(String instanceId);

  /**
   * Restart an instance.
   * @param instanceId instance Id to restart
   * @return the restarted instance
   */
  public abstract Instance restart(String instanceId);

  /**
   * Retrieve the status of this InstanceProvider.
   * @return InstanceProvider status @see mobi.designmyapp.common.instance.model.Status
   */
  public abstract Status getStatus();

  /**
   * Indicate if the InstanceProvider can create instances checking poolSize
   * and running instances List.
   * @return boolean indicating whether a new instance can be started.
   */
  public abstract boolean canCreateInstance();

  /**
   * Retrieve the number of RUNNING instances.
   * @return number of RUNNING instances
   */
  public abstract int getActiveCount();

  /**
   * Return the provider-level time-to-live for default instances.
   * @return time-to-live
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * Retrieve hostname endpoint.
   * @return hostname endpoint url
   */
  public abstract String getHostname();

  /**
   * Default implementation of compareTo for the InstanceManager.
   */
  @Override
  public int compareTo(InstanceProvider instanceProvider) {
    if (this.getPriority().equals(instanceProvider.getPriority())) {
      return this.getName().compareTo(instanceProvider.getName());
    } else {
      return this.getPriority().compareTo(instanceProvider.getPriority());
    }
  }


}