/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.provider;

import mobi.designmyapp.common.api.model.Instance;
import mobi.designmyapp.common.api.model.Status;

import java.util.List;

/**
 * Created by Jean Blanchard on 28/10/14.
 */
public abstract class InstanceProvider implements Comparable<InstanceProvider> {

  protected List<Instance> instances;
  protected Integer poolSize;
  protected Integer priority;

  public abstract List<Instance> getInstances();

  public abstract void refreshInstancesState();

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
  public abstract Instance start(String dockerImageName, String... args);

  /**
   * Terminate an instance.
   */
  public abstract void stop(String instanceId);

  /**
   * Restart an instance
   */
  public abstract Instance restart(String instanceId);

  public abstract Status getStatus();

  /**
   * Indicates whether a new instance can be started.
   */
  public abstract boolean canCreateInstance();

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