/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.instance.strategy;

import mobi.designmyapp.common.instance.provider.InstanceProvider;

import java.util.List;

/**
 * Sandbox server selection strategy.
 *
 * Created by Jean Blanchard on 29/10/14.
 */
public interface InstanceSelectionStrategy {

  public InstanceProvider selectInstanceProvider(List<InstanceProvider> instanceProviders);

}
