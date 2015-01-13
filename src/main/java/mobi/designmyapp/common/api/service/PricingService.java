/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.service;

import mobi.designmyapp.common.api.model.Portal;
import mobi.designmyapp.common.api.model.Pricing;


/**
 * Created by Loïc Ortola on 7/24/14.
 */
public interface PricingService {
  <T extends Pricing> T getPricing(Portal portal, String templateTag);
}
