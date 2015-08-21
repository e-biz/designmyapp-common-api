package mobi.designmyapp.common.container.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anas Hammani on 09/07/15.
 */
public class ContainerProgress {

  private int percentage;

  private List<String> messages;

  /**
   * Default constructor.
   */
  public ContainerProgress() {

  }

  /**
   * Convenient builder.
   * @return Builder for this object.
   */
  public static Builder builder() {
    return new Builder();
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
        "percentage=" + percentage +
        ", messages=" + messages +
        '}';
  }

  public static class Builder {
    private ContainerProgress containerProgress;

    /**
     * Private default constructor.
     */
    private Builder() {
      containerProgress = new ContainerProgress();
    }

    /**
     * Set the percentage.
     * @param percentage Percentage
     * @return The builder
     */
    public Builder percentage(int percentage) {
      containerProgress.setPercentage(percentage);
      return this;
    }

    /**
     * Set the messages.
     * @param messages Messages
     * @return The builder
     */
    public Builder messages(List<String> messages) {
      containerProgress.setMessages(messages);
      return this;
    }

    /**
     * Set the message.
     * @param message Message
     * @return The builder
     */
    public Builder message(String message) {
      containerProgress.addMessage(message);
      return this;
    }

    /**
     * Build effectively.
     * @return The built object.
     */
    public ContainerProgress build() {
      return containerProgress;
    }
  }
}
