/*
 Copyright 2015 eBusiness Information
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package mobi.designmyapp.common.engine.model;

import java.io.InputStream;

/**
 * This class represents an upload request that will be used
 * to call a custom upload processor @see mobi.designmyapp.sdk.processor.uploadProcessor.
 * It will allow you to upload any custom resources for your application.
 * Created by Christophe Deverre on 01/08/14.
 */
public class UploadRequest {

  /**
   * Original uploaded file name
   */
  private String originalFilename;

  /**
   * Name of the portal on which the request is made
   */
  private String portalName;

  /**
   * Application id
   */
  private String appId;

  /**
   * Stream containing the Object to save
   */
  private InputStream obj;

  /**
   * Object to store additional resources
   */
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
