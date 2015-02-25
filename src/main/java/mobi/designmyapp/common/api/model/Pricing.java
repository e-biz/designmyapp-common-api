/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import mobi.designmyapp.common.api.utils.UtilsFactory;


/**
 * This class represents the default pricing model for your app.
 * You will later be able to customize and change those values in your admin area,
 * or even specify different prices depending on which portal it is on.
 * Only put attributes, and use PriceUtils.create() to set up your prices
 */
public abstract class Pricing {

  public Price templatePrice = Price.ZERO;

  public void validate() {
    if (UtilsFactory.getPriceUtils().isNegative(templatePrice)) {
      templatePrice = UtilsFactory.getPriceUtils().create("0.00");
    }
  }
}
