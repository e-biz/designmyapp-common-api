/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

public class NoTargetException extends RuntimeException {

  public NoTargetException() {
    super("No target has been specified. Please specify at least one target to complete request.");
  }

}
