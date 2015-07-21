package mobi.designmyapp.common.container.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anas Hammani on 09/07/15.
 */
public class InstantiationProgress {
  private String containerId;

  private int percentage;

  private List<String> messages;

  /**
   * Default constructor.
   */
  public InstantiationProgress() {

  }

  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public int getPercentage() {
    return percentage;
  }

  public void setPercentage(int percentage) {
    this.percentage = percentage;
  }


  public List<String> getMessages() {
    return messages;
  }


  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  /**
   * Add a message to message list.
   *
   * @param message the message to add.
   */
  public void addMessage(String message) {
    if (messages == null) {
      messages = new ArrayList<>();
    }
    this.messages.add(message);
  }

  @Override
  public String toString() {
    return "InstanceProgress{" +
        "containerId='" + containerId + '\'' +
        ", percentage=" + percentage +
        ", messages=" + messages +
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

    InstantiationProgress progress = (InstantiationProgress) o;

    return !(containerId != null ? !containerId.equals(progress.containerId) : progress.containerId != null);

  }

  @Override
  public int hashCode() {
    return containerId != null ? containerId.hashCode() : 0;
  }
}
