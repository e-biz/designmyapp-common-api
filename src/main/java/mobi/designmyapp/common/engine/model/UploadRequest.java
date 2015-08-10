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
//TODO REFACTOR THE CLASS, apiKey?? appId?? resources??
public class UploadRequest {

  /**
   * Original uploaded file name.
   */
  private String originalFilename;

  /**
   * Name of the apiKey on which the request is made.
   */
  private String apiKey;

  /**
   * Application id.
   */
  private String appId;

  /**
   * Stream containing the Object to save.
   */
  private InputStream obj;

  /**
   * Object to store additional resources.
   */
  private Object resources;


  /**
   * String for the destFilename.
   */
  private String destFilename;


  /**
   * Constructor.
   * @param originalFilename the original uploaded file name
   * @param apiKey name of the apiKey on which the request is made
   * @param appId the application id
   * @param obj the object to save in stream
   * @param resources Object to store additional resources
   * @param destFilename String for the destFilename
   */
  public UploadRequest(String originalFilename, String apiKey, String appId, InputStream obj, Object resources, String destFilename) {
    this.originalFilename = originalFilename;
    this.apiKey = apiKey;
    this.appId = appId;
    this.obj = obj;
    this.resources = resources;
    this.destFilename = destFilename;
  }

  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
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

  public String getDestFilename() {
    return destFilename;
  }

  public void setDestFilename(String destFilename) {
    this.destFilename = destFilename;
  }
}
