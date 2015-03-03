/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.engine.service;

import mobi.designmyapp.common.engine.model.Pricing;


/**
 * This class provides pricing services
 * Created by Loïc Ortola on 24/07/14.
 */
public interface PricingService {

  /**
   * Retrieve template specific pricing from template tag
   * @param templateTag input template tag
   * @return template pricing instance
   */
  <T extends Pricing> T getPricing(String templateTag);

}
