/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.engine.service;

import mobi.designmyapp.common.engine.model.Portal;
import mobi.designmyapp.common.engine.model.Pricing;


/**
 * Created by Loïc Ortola on 24/07/14.
 */
public interface PricingService {
  <T extends Pricing> T getPricing(Portal portal, String templateTag);
}
