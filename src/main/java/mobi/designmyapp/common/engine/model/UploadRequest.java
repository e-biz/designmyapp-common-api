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
   * Original uploaded file name.
   */
  private String originalFilename;

  /**
   * Stream containing the Object to save.
   */
  private InputStream obj;

  /**
   * String for the destFilename.
   */
  private String destFilename;

  private String namespace;


  /**
   * Constructor.
   *
   * @param originalFilename the original uploaded file name
   * @param namespace the namespace corresponding to this upload
   * @param obj the object to save in stream
   * @param destFilename String for the destFilename
   */
  public UploadRequest(String namespace, String originalFilename, InputStream obj, String destFilename) {
    this.namespace = namespace;
    this.originalFilename = originalFilename;
    this.obj = obj;
    this.destFilename = destFilename;
  }

  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public InputStream getObj() {
    return obj;
  }

  public void setObj(InputStream obj) {
    this.obj = obj;
  }

  public String getDestFilename() {
    return destFilename;
  }

  public void setDestFilename(String destFilename) {
    this.destFilename = destFilename;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }
}
