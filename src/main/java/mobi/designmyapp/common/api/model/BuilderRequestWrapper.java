/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

/**
 * Created by Loïc Ortola on 8/21/14.
 */
public class BuilderRequestWrapper {

  private String applicationPackage;
  private String srcDirectory;
  private String distDirectory;

  public String getApplicationPackage() {
    return applicationPackage;
  }

  public void setApplicationPackage(String applicationPackage) {
    this.applicationPackage = applicationPackage;
  }

  public String getSrcDirectory() {
    return srcDirectory;
  }

  public void setSrcDirectory(String srcDirectory) {
    this.srcDirectory = srcDirectory;
  }

  public String getDistDirectory() {
    return distDirectory;
  }

  public void setDistDirectory(String distDirectory) {
    this.distDirectory = distDirectory;
  }

}
