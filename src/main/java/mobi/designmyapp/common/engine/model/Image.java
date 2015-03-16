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

import mobi.designmyapp.common.util.UtilsFactory;

/**
 * This class represents an image to be used in the application
 * Created by Loïc Ortola on 07/07/14.
 */
public class Image {

  /**
   * Generated image filename
   */
  private String fileName;

  /**
   * Image original filename
   */
  private String originalName;

  /**
   * Image access url
   */
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
      if(namespace == null || appId == null || image.getFileName() == null) {
        throw new IllegalStateException("fileName, appId and namespace fields are mandatory.");
      }
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Image image = (Image) o;

    return (fileName.equals(image.fileName) && url.equals(image.url) &&
        originalName != null ? originalName.equals(image.originalName) : image.originalName == null);
  }

  @Override
  public int hashCode() {
    int result = fileName.hashCode();
    result = 31 * result + (originalName != null ? originalName.hashCode() : 0);
    result = 31 * result + url.hashCode();
    return result;
  }
}
