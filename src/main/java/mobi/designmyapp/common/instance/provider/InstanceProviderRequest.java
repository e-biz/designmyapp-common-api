package mobi.designmyapp.common.instance.provider;

/**
 * Created by Loïc Ortola on 11/03/2015.
 */
public class InstanceProviderRequest<T> {

  private T obj;

  private InstanceProviderRequest(T obj) {
    this.obj = obj;
  }

  public T get() {
    return obj;
  }

  /**
   * DesignMyAppRequest is used to create a new InstanceProvider using three parameters (all mandatory):
   * A hostname that point to the instance provider client
   * A keyId and a secretKey that protect your instance provider client
   *
   * The particularity of this provider, is that it can be used directly with our default implementation of
   * the Instance manager API. ( See knowledge Base at 3.1.2 of the 2 section )
   *
   * Use the builder pattern to create a new request :
   * InstanceProviderRequest request = InstanceProviderRequest.designMyApp()
   *    .hostname("http://myServeurUrl:8080")
   *    .keyId("myKeyId")
   *    .secretKey("mySecretKey")
   *    .poolSize(20)
   *    .ttl(60) <- optional
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

    private int poolSize;

    private int ttl;

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

    public DesignMyAppRequest poolSize(int poolSize) {
      if (poolSize <= 0) {
        throw new IllegalArgumentException("PoolSize Cannot be less than or equal to 0.");
      }
      this.poolSize = poolSize;
      return this;
    }

    /**
     * The provider instances Time To Live in minutes.
     * If this parameter is not provided, the instances will live forever, unless set otherwise.
     * If this parameter is provided, it will force each instance to be automatically shutdown after that ttl is expired.
     * @param ttl the children instances time to live in minutes
     * @return
     */
    public DesignMyAppRequest ttl(int ttl) {
      if (ttl < 0) {
        throw new IllegalArgumentException("TTL Cannot be negative.");
      }
      this.ttl = ttl;
      return this;
    }

    public InstanceProviderRequest<DesignMyAppRequest> build() {
      if (this.hostname == null || this.keyId == null || this.secretKey == null || this.poolSize <= 0) {
        throw new IllegalArgumentException("None of these parameters should be null : hostname, keyId, secretKey, and poolSize must be strictly superior to 0");
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

    public int getPoolSize() {
      return poolSize;
    }

    public int getTtl() {
      return ttl;
    }
  }
}
