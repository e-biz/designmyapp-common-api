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
  protected Integer priority;

  /**
   * Retrieve deployed instances
   * @return
   */
  public abstract List<Instance> getInstances();

  /**
   * Refresh the status of the instances
   */
  public abstract void refreshInstancesState();

  /**
   * Retrieve a single instance by its id
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
   */
  public abstract String getName();

  /**
   * Start a new instance.
   */
  public abstract Instance start(String imageName, List<String> options, List<String> args);

  /**
   * Terminate an instance.
   */
  public abstract void stop(String instanceId);

  /**
   * Restart an instance
   */
  public abstract Instance restart(String instanceId);

  /**
   * Retrieve the status of this InstanceProvider
   * @return
   */
  public abstract Status getStatus();

  /**
   * Indicates whether a new instance can be started.
   */
  public abstract boolean canCreateInstance();

  /**
   * Retrieve the number of RUNNING instances
   * @return
   */
  public abstract int getActiveCount();

  /**
   * Default implementation of compareTo for the InstanceManager.
   * @param instanceProvider
   * @return
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