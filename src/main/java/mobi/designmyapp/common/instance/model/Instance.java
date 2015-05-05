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
package mobi.designmyapp.common.instance.model;

import java.util.Map;

/**
 * This class represents an instance that can be any kind of running device
 * (physical server, docker image,...)
 * Created by Jean Blanchard on 22/10/14.
 */
public class Instance {

  /**
   * Name of the instance
   */
  private String name;

  /**
   * Unique id of the instance
   */
  private String id;

  /**
   * Type/Image of the instance
   */
  private String image;

  /**
   * Actual status
   */
  private Status status;

  /**
   * Actual running task
   */
  private String task;

  /**
   * Deployment or task progress
   */
  private int progress;

  /**
   * Memory management
   */
  private String cgroupMemoryRoot = null;

  private String protocol;

  /**
   *
   */
  private String hostname;

  /**
   * Port mapping
   */
  private Map<String,String> portsMap;

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

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public Map<String, String> getPortsMap() {
    return portsMap;
  }

  public void setPortsMap(Map<String, String> portsMap) {
    this.portsMap = portsMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Instance instance = (Instance) o;

    return (id != null ? id.equals(instance.id) : instance.id == null);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Instance{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", image='" + image + '\'' +
        ", status=" + status +
        ", task='" + task + '\'' +
        ", progress=" + progress +
        ", cgroupMemoryRoot='" + cgroupMemoryRoot + '\'' +
        ", hostname='" + hostname + '\'' +
        ", portsMap='"+ portsMap +'\'' +
        '}';
  }
}
