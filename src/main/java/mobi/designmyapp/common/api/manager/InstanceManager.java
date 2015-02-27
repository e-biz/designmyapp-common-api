/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.manager;

import mobi.designmyapp.common.api.model.Instance;
import mobi.designmyapp.common.api.provider.InstanceProvider;
import mobi.designmyapp.common.api.strategy.InstanceSelectionStrategy;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Alexandre Nunesse on 24/02/2015.
 */
public abstract class InstanceManager {
  
  public InstanceSelectionStrategy strategy;

  private Set<InstanceProvider> instanceProviders;

  private InstanceSelectionStrategy instanceSelectionStrategy;

  public abstract void addProvider(InstanceProvider instanceProvider, int priority);

  public abstract void addProvider(InstanceProvider instanceProvider);

  public abstract Instance startInstance(String dockerImage, String... args);

  public abstract void stopInstance(String instanceId);

  public abstract void restartInstance(String instanceId);

  public abstract Collection<InstanceProvider> getInstanceProviders();

  public abstract Instance getInstance(String instanceID);

  public InstanceSelectionStrategy getStrategy() {
    return strategy;
  }

  public void setStrategy(InstanceSelectionStrategy strategy) {
    this.strategy = strategy;
  }
}
