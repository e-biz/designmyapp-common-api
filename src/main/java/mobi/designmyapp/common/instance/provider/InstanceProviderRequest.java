package mobi.designmyapp.common.instance.provider;

/**
 * Created by loic on 11/03/2015.
 */
public class InstanceProviderRequest<T> {

  private T obj;

  public T get() {
    return obj;
  }

  private InstanceProviderRequest(T obj) {
    this.obj = obj;
  }

  /**
   * DesignMyAppRequest is used to create a new InstanceProvider using three parameters : 
   * A hostname that point to the instance provider client 
   * A keyId and a secretKey that protect your instance provider client
   * 
   * Use the builder pattern to create a new request :
   * InstanceProviderRequest request = InstanceProviderRequest.designMyApp()
   *    .hostname("http://monServeurUrl:8080")
   *    .keyId("myKeyId")
   *    .secretKey("mySecretKey")
   *    .build();
   *
   */
  public static DesignMyAppRequest designMyApp() {
    return new DesignMyAppRequest();
  }

  public static class DesignMyAppRequest {

    private String keyId ;

    private String secretKey ;

    private String hostname;

    private DesignMyAppRequest() {
    }

    public DesignMyAppRequest hostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    public DesignMyAppRequest keyId(String keyId) {
      this.keyId = keyId;
      return this;
    }
    
    public DesignMyAppRequest secretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    public InstanceProviderRequest<DesignMyAppRequest> build() {
      if (this.hostname == null || this.keyId == null || this.secretKey == null) {
        throw new NullPointerException("None of this parameter should be null : hostname, keyId, secretKey");
      }
      return new InstanceProviderRequest<>(this);
    }

    public String getKeyId() {
      return keyId;
    }

    public String getSecretKey() {
      return secretKey;
    }

    public String getHostname() {
      return hostname;
    }
  }
}
