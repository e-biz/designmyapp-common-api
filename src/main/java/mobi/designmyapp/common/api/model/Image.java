/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import mobi.designmyapp.common.api.utils.UtilsFactory;

/**
 * Created by Loïc Ortola on 7/7/14.
 */
public class Image {

  private String fileName;
  private String originalName;
  private String url;

  private Image() {
  }

  public Image(String fileName, String originalName, String url) {
    this.fileName = fileName;
    this.originalName = originalName;
    this.url = url;
  }

  public String getOriginalName() {
    return originalName;
  }

  public String getFileName() {
    return fileName;
  }

  public String getUrl() {
    return url;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private Image image;

    private Builder() {
      image = new Image();
    }

    public Builder fileName(String fileName) {
      image.fileName = fileName;
      return this;
    }

    public Builder originalName(String originalName) {
      image.originalName = originalName;
      return this;
    }

    public URLBuilder prepareUrl() {
      return new URLBuilder(image);
    }

  }

  public static class URLBuilder {

    private Image image;
    private String portal;
    private String appId;
    private String namespace;

    private URLBuilder(Image image) {
      this.image = image;
    }

    public URLBuilder portal(String portal) {
      this.portal = portal;
      return this;
    }

    public URLBuilder appId(String appId) {
      this.appId = appId;
      return this;
    }

    public URLBuilder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Image build() {
      if(namespace == null || appId == null || image.getFileName() == null)
        throw new IllegalStateException("fileName, appId and namespace fields are mandatory.");
      image.url = UtilsFactory.getResourceUtils().createUrl(appId, namespace, image.getFileName(), portal);
      return image;
    }

  }

  @Override
  public String toString() {
    return "Image{" +
        "fileName='" + fileName + '\'' +
        ", originalName='" + originalName + '\'' +
        ", url='" + url + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Image image = (Image) o;

    if (!fileName.equals(image.fileName)) return false;
    if (originalName != null ? !originalName.equals(image.originalName) : image.originalName != null) return false;
    if (!url.equals(image.url)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = fileName.hashCode();
    result = 31 * result + (originalName != null ? originalName.hashCode() : 0);
    result = 31 * result + url.hashCode();
    return result;
  }
}
