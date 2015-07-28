package mobi.designmyapp.common.container.model;

import java.net.URI;
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
   * Hostname (protocol + hostname).
   */
  private URI hostname;

  /**
   * Port mapping.
   */
  private Map<String, String> portMap;

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

  public Map<String, String> getPortMap() {
    return portMap;
  }

  public void setPortMap(Map<String, String> portMap) {
    this.portMap = portMap;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public URI getHostname() {
    return hostname;
  }

  public void setHostname(URI hostname) {
    this.hostname = hostname;
  }
}
