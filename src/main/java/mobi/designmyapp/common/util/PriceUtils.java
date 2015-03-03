/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
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
   * @param  price1
   * @param  price2
   * @return true if the params are equivalent
   */
  boolean eq(BigDecimal price1, BigDecimal price2);

  /**
   * Test if this BigDecimal is strictly lower than zero
   * @param price
   * @return true if the param is strictly lower than zero
   */
  boolean isNegative(BigDecimal price);
}
