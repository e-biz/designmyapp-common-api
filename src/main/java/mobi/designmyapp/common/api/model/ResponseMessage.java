/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

/**
 * Created by Loïc Ortola on 7/21/14.
 */
public class ResponseMessage {
  private int statusCode;
  private String message;
  private Object result;

  public ResponseMessage(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public ResponseMessage(int statusCode, String message, Object result) {
    this.statusCode = statusCode;
    this.message = message;
    this.result = result;
  }


  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }
}
