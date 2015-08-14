package mobi.designmyapp.common.container.model;

/**
 * Created by Anas Hammani on 09/07/15.
 */
public class ContainerProgressRequest {

  private int percentage;

  private String message;

  /**
   * Default constructor.
   */
  public ContainerProgressRequest() {

  }

  /**
   * Convenient builder.
   * @return Builder
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


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static class Builder {
    private ContainerProgressRequest containerProgressRequest;

    /**
     * Private default Constructor.
     */
    private Builder() {
      containerProgressRequest = new ContainerProgressRequest();
    }

    /**
     * Set the percentage.
     * @param percentage Percentage
     * @return The builder
     */
    public Builder percentage(int percentage) {
      containerProgressRequest.setPercentage(percentage);
      return this;
    }

    /**
     * Set the message.
     * @param message Message
     * @return The builder
     */
    public Builder message(String message) {
      containerProgressRequest.setMessage(message);
      return this;
    }

    /**
     * Create effectively the object.
     * @return The built object
     */
    public ContainerProgressRequest build() {
      return containerProgressRequest;
    }
  }
}
