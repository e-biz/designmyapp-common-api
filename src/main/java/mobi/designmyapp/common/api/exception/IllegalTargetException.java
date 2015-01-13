/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

public class IllegalTargetException extends RuntimeException {

  public IllegalTargetException() {
    super("The specified target is not valid for the current template. Please specify a valid target to complete request.");
  }

}
