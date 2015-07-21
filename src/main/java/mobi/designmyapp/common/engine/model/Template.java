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

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the default template model of your app.
 * You will have to extend this class to create a template matching
 * your application requirements.
 * Created by Loic Ortola on 14/02/15.
 */
public abstract class Template {

  /**
   * The name of the application that will be generated.
   */
  protected String name;

  /**
   * The version of the template to create.
   */
  protected String version;

  /**
   * Unique String referencing your template.
   */
  protected String templateTag;


  /**
   * Base option representing the application icon.
   */
  protected boolean customIcon;

  /**
   * List of available target applications.
   */
  protected List<String> targets;

  public static final String DEFAULT_TEMPLATE_TAG = "generic";
  public static final String TARGET_ANDROID = "android";
  public static final String TARGET_IOS = "ios";
  public static final String TARGET_CONTAINER = "webapp";

  public Template(String templateTag) {
    this.templateTag = templateTag;
    this.name="My Application";
    this.targets=new ArrayList<>();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getTemplateTag() {
    return templateTag;
  }

  public void setTemplateTag(String templateTag) {
    this.templateTag = templateTag;
  }

  public boolean getCustomIcon() {
    return customIcon;
  }

  public void setCustomIcon(boolean customIcon) {
    this.customIcon = customIcon;
  }

  public List<String> getTargets() {
    return targets;
  }

  public void setTargets(List<String> targets) {
    this.targets = targets;
  }
  
  @Override
  public String toString() {
    return "Template{" +
        " name ='"+ name + "\'" +
        ", version ='"+ version + "\'" +
        ", customIcon='" + customIcon + '\'' +
        ", targets=" + targets +
        '}';
  }
}
