/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

public class BuildErrorException extends RuntimeException {

  public BuildErrorException() {
  }

  public BuildErrorException(String s) {
    super(s);
  }

  public BuildErrorException(Exception e) {
    super(e);
  }

  public BuildErrorException(String s, Exception e) {
    super(s, e);
  }

}
