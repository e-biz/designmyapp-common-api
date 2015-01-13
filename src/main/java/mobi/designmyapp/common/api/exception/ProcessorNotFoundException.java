/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

/**
 * Created by Loïc Ortola on 7/23/14.
 */
public class ProcessorNotFoundException extends RuntimeException {
  public ProcessorNotFoundException() {
    super("No processor could be found to perform request.");
  }
}
