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

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the default template model of your app.
 * You will have to extend this class to create a template matching
 * your application requirements.
 * Created by Loic Ortola on 14/02/15.
 */
public abstract class Template {

  /**
   * Random UUID referencing your application
   */
  protected String uuid;

  /**
   * Unique string referencing your template
   */
  protected String templateTag;

  /**
   * String representing your template name
   */
  protected String templateName;

  /**
   * Base option representing the application icon
   */
  protected Boolean customIcon;

  /**
   * List of available target applications
   */
  protected List<String> targets;

  /**
   * Representation of the response sent to the frontend once webapp init is done.
   * Object needs to be Serializable
   */
  protected Object webappResponse;

  public static final String DEFAULT_TEMPLATE_TAG = "generic";
  public static final String TARGET_ANDROID = "android";
  public static final String TARGET_IOS = "ios";
  public static final String TARGET_WEBAPP = "webapp";

  public Template(String templateTag) {
    this.templateTag = templateTag;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getTemplateTag() {
    return templateTag;
  }

  public void setTemplateTag(String templateTag) {
    this.templateTag = templateTag;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  public Boolean getCustomIcon() {
    return customIcon;
  }

  public void setCustomIcon(Boolean customIcon) {
    this.customIcon = customIcon;
  }

  public List<String> getTargets() {
    return targets;
  }

  public void setTargets(List<String> targets) {
    this.targets = targets;
  }

  public Object getWebappResponse() {
    return webappResponse;
  }

  public void setWebappResponse(Serializable webappResponse) {
    this.webappResponse = webappResponse;
  }

  @Override
  public String toString() {
    return "Template{" +
        "uuid='" + uuid + '\'' +
        "templateTag='" + templateTag + '\'' +
        ", templateName='" + templateName + '\'' +
        ", customIcon='" + customIcon + '\'' +
        ", targets=" + targets +
        '}';
  }
}
