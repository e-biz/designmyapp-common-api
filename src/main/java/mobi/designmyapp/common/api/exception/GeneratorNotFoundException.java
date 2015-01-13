/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.exception;

/**
 * Created by Loïc Ortola on 7/25/14.
 */
public class GeneratorNotFoundException extends RuntimeException {

  public GeneratorNotFoundException() {
    super("No generator could be found for the template tag requested. Please select a valid template tag to complete request.");
  }
}
