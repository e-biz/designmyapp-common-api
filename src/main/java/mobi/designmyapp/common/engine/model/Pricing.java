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
package mobi.designmyapp.common.engine.model;

import mobi.designmyapp.common.util.UtilsFactory;

import java.math.BigDecimal;


/**
 * This class represents the default pricing model for your app.
 * You will later be able to customize and change those values in your admin area,
 * or even specify different prices depending on which apiKey it is on.
 * Only put attributes, and use PriceUtils.create() to set up your prices
 */
public abstract class Pricing {

  public BigDecimal templatePrice = BigDecimal.ZERO;

  public void validate() {
    if (UtilsFactory.getPriceUtils().isNegative(templatePrice)) {
      templatePrice = UtilsFactory.getPriceUtils().create("0.00");
    }
  }
}
