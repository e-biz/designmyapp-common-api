/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

/**
 * Created by Loïc Ortola on 7/21/14.
 */
public class InvalidExtensionException extends IllegalArgumentException {
  public InvalidExtensionException() {
    super("The file extension is invalid. Please provide the right file to complete request.");
  }
}
