/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

/**
 * Created by Jean Blanchard on 22/10/14.
 */
public class Instance {

  private String name;
  private String id;
  private String image;
  private Status status;
  private String task;
  private int progress;
  private String cgroupMemoryRoot = null;
  private String uri;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public String getCgroupMemoryRoot() {
    return cgroupMemoryRoot;
  }

  public void setCgroupMemoryRoot(String cgroupMemoryRoot) {
    this.cgroupMemoryRoot = cgroupMemoryRoot;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Instance instance = (Instance) o;

    if (id != null ? !id.equals(instance.id) : instance.id != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
