/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import java.util.List;

/**
 * Created by Loic Ortola on 14/02/15.
 */

public abstract class Template {
  protected String uuid;
  protected String templateTag;
  protected String templateName;
  protected List<String> targets;

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

  public List<String> getTargets() {
    return targets;
  }

  public void setTargets(List<String> targets) {
    this.targets = targets;
  }

  @Override
  public String toString() {
    return "Template{" +
        "uuid='" + uuid + '\'' +
        "templateTag='" + templateTag + '\'' +
        ", templateName='" + templateName + '\'' +
        ", targets=" + targets +
        '}';
  }
}
