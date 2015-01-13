/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import java.io.InputStream;

/**
 * Created by Christophe Deverre on 01/08/14.
 */
public class UploadRequest {

  private String originalFilename;

  private String portalName;

  private String appId;

  private InputStream obj;

  private Object resources;

  public UploadRequest(String originalFilename,String portalName, String appId, InputStream obj, Object resources) {
    this.originalFilename=originalFilename;
    this.portalName=portalName;
    this.appId=appId;
    this.obj=obj;
    this.resources =resources;
  }

  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public String getPortalName() {
    return portalName;
  }

  public void setPortalName(String portalName) {
    this.portalName = portalName;
  }

  public InputStream getObj() {
    return obj;
  }

  public void setObj(InputStream obj) {
    this.obj = obj;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public Object getResources() {
    return resources;
  }

  public void setResources(Object resources) {
    this.resources = resources;
  }
}
