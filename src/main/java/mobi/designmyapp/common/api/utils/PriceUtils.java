/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.utils;

import java.math.BigDecimal;

/**
 * Created by Alexandre Nunesse on 06/01/15.
 */
public interface PriceUtils {

  BigDecimal create(String number);

  BigDecimal round(BigDecimal price);

  boolean isZero(BigDecimal price);

  boolean eq(BigDecimal price, BigDecimal Price);

  boolean isNegative(BigDecimal price);
}
