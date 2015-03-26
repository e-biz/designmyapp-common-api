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
package mobi.designmyapp.common.util;

import java.math.BigDecimal;

/**
 * This class provides utility pricing methods
 * Created by Alexandre Nunesse on 06/01/15.
 */
public interface PriceUtils {

  /**
   * Translates the String representation of BigDecimal
   * into a BigDecimal
   * @param number String representation
   * @return new BigDecimal number
   */
  BigDecimal create(String number);

  /**
   * This method return a half down rounded price
   * @param price immutable input price
   * @return output rounded price
   */
  BigDecimal round(BigDecimal price);

  /**
   * Test if this BigDecimal is equivalent to zero
   * @param  price to compare with zero
   * @return true if the price equals zero
   */
  boolean isZero(BigDecimal price);

  /**
   * Test if two BigDecimals are equivalent
   * @param  price1 1st BigDecimal to test
   * @param  price2 2nd BigDecimal to test
   * @return true if the params are equivalent
   */
  boolean eq(BigDecimal price1, BigDecimal price2);

  /**
   * Test if this BigDecimal is strictly lower than zero
   * @param price input price
   * @return true if the param is strictly lower than zero
   */
  boolean isNegative(BigDecimal price);
}
