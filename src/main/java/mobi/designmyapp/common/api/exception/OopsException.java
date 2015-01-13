/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

/**
 * Exception that should never, ever happen, to encapsulate checked exceptions imposed by an API. e.g. a JDK method that takes a String constant.
 * Created by jblanchard on 01/09/14.
 */
public class OopsException extends RuntimeException {
  public OopsException(Throwable cause) {
    super(cause.getMessage(), cause);
  }
}
