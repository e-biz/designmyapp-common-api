/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

/**
 * Created by francois on 11/9/14.
 */
public class HtmlDownloadResource {
  private String distributionEndpoint;
  private String distributionHttpEndpoint;
  private String appId;
  private String name;
  private String version;
  private String applicationPackage;
  private boolean ios;
  private boolean android;

  public String getDistributionEndpoint() {
    return distributionEndpoint;
  }

  public void setDistributionEndpoint(String distributionEndpoint) {
    this.distributionEndpoint = distributionEndpoint;
  }

  public String getDistributionHttpEndpoint() {
    return distributionHttpEndpoint;
  }

  public void setDistributionHttpEndpoint(String distributionHttpEndpoint) {
    this.distributionHttpEndpoint = distributionHttpEndpoint;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getApplicationPackage() {
    return applicationPackage;
  }

  public void setApplicationPackage(String applicationPackage) {
    this.applicationPackage = applicationPackage;
  }

  public boolean isIos() {
    return ios;
  }

  public void setIos(boolean ios) {
    this.ios = ios;
  }

  public boolean isAndroid() {
    return android;
  }

  public void setAndroid(boolean android) {
    this.android = android;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private HtmlDownloadResource res;

    private Builder() {
      res = new HtmlDownloadResource();
    }

    public Builder distributionEndpoint(String s) {
      res.distributionEndpoint = s;
      return this;
    }

    public Builder distributionHttpEndpoint(String s) {
      res.distributionHttpEndpoint = s;
      return this;
    }

    public Builder appId(String s) {
      res.appId = s;
      return this;
    }

    public Builder name(String s) {
      res.name = s;
      return this;
    }

    public Builder version(String s) {
      res.version = s;
      return this;
    }

    public Builder applicationPackage(String s) {
      res.applicationPackage = s;
      return this;
    }

    public Builder android(boolean b) {
      res.android = b;
      return this;
    }

    public Builder ios(boolean b) {
      res.ios = b;
      return this;
    }

    public HtmlDownloadResource build() {
      return res;
    }
  }
}
