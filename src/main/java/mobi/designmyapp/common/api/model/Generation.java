/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import mobi.designmyapp.common.api.resolver.GenerationTypeIdResolver;
import org.jongo.marshall.jackson.oid.Id;

import java.util.List;

/**
 * Created by Alexandre Nunesse on 7/18/14.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "templateTag")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeIdResolver(GenerationTypeIdResolver.class)
public abstract class Generation {
  @Id
  protected String uuid;
  protected String name;
  protected String applicationPackage;
  protected Boolean customIcon;
  protected String version;
  protected Portal portal;
  protected User user;
  protected String templateTag;
  protected String templateName;
  protected List<String> targets;

  public static final String TARGET_ANDROID = "android";
  public static final String TARGET_IOS = "ios";

  public Generation() {
    this.name = "My First App";
    this.applicationPackage = "mobi.designmyapp";
    this.customIcon = false;
    this.version = "0.0.0";
  }

  public Generation(String applicationPackage) {
    this.applicationPackage = applicationPackage;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getApplicationPackage() {
    return applicationPackage;
  }

  public void setApplicationPackage(String applicationPackage) {
    this.applicationPackage = applicationPackage;
  }

  public boolean isCustomIcon() {
    return customIcon;
  }

  public void setCustomIcon(boolean customIcon) {
    this.customIcon = customIcon;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Portal getPortal() {
    return portal;
  }

  public void setPortal(Portal portal) {
    this.portal = portal;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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
    return "Generation{" +
        "uuid='" + uuid + '\'' +
        ", name='" + name + '\'' +
        ", package='" + applicationPackage + '\'' +
        ", customIcon=" + customIcon +
        ", version='" + version + '\'' +
        ", portal=" + portal +
        ", user=" + user +
        ", templateTag='" + templateTag + '\'' +
        ", templateName='" + templateName + '\'' +
        ", targets='" + targets + '\'' +
        '}';
  }
}
