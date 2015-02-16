/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.utils;

import mobi.designmyapp.common.api.model.Price;

/**
 * Created by Alexandre Nunesse on 1/6/15.
 */
public interface PriceUtils {

  Price create(String number);

  Price round(Price Price);

  boolean isZero(Price Price);

  boolean eq(Price price, Price Price);

  boolean isNegative(Price Price);
}
