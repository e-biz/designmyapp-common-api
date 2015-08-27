package mobi.designmyapp.common.container.model;

import java.util.Map;

public class ContainerStatus {

  /**
   * Name of the container.
   */
  private String name;

  /**
   * Unique container id.
   */
  private String containerId;

  /**
   * Actual status.
   */
  private Status status;

  /**
   * Deployment or task progress percentage.
   */
  private int progress;

  /**
   * Endpoint (protocol + endpoint).
   */
  private String endpoint;

  /**
   * Port mapping.
   */
  private Map<String, String> portsMap;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public Map<String, String> getPortsMap() {
    return portsMap;
  }

  public void setPortsMap(Map<String, String> portsMap) {
    this.portsMap = portsMap;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  @Override
  public String toString() {
    return "ContainerStatus{" +
        "name='" + name + '\'' +
        ", containerId='" + containerId + '\'' +
        ", status=" + status +
        ", progress=" + progress +
        ", endpoint=" + endpoint +
        ", portsMap=" + portsMap +
        '}';
  }
}
