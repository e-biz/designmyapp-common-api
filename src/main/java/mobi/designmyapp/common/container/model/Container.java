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
package mobi.designmyapp.common.container.model;

import java.net.URI;
import java.util.Map;

/**
 * This class represents a container
 * Created by Jean Blanchard on 22/10/14.
 */
public class Container {
  
  public static enum Type {
    COMMAND, DATA_VOLUME
  }
  
  /**
   * Name of the container
   */
  private String name;

  /**
   * Unique container id
   */
  private String uuid;

  /**
   * Container group of the container. This is used to automatically group multiple containers when built together.
   */
  private String containerGroupUuid;
  
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
   * Deployment or task progress percentage
   */
  private int progress;
  /**
   * Hostname (protocol + hostname)
   */
  private URI hostname;

  /**
   * Port mapping
   */
  private Map<String,String> portMap;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  public URI getHostname() {
    return hostname;
  }

  public void setHostname(URI hostname) {
    this.hostname = hostname;
  }

  public Map<String, String> getPortMap() {
    return portMap;
  }

  public void setPortMap(Map<String, String> portsMap) {
    this.portMap = portsMap;
  }

  public String getContainerGroupUuid() {
    return containerGroupUuid;
  }

  public void setContainerGroupUuid(String containerGroupUuid) {
    this.containerGroupUuid = containerGroupUuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Container container = (Container) o;

    return (uuid != null ? uuid.equals(container.uuid) : container.uuid == null);
  }

  @Override
  public int hashCode() {
    return uuid != null ? uuid.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Instance{" +
        "name='" + name + '\'' +
        ", uuid='" + uuid + '\'' +
        ", image='" + image + '\'' +
        ", status=" + status +
        ", task='" + task + '\'' +
        ", progress=" + progress +
        ", hostname='" + hostname + '\'' +
        ", portMap='"+ portMap +'\'' +
        '}';
  }
}
