package mobi.designmyapp.common.container.provider;

/**
 * Created by Loïc Ortola on 11/03/2015.
 */
public class ContainerProviderRequest<T> {

  private T obj;

  /**
   * Constructor.
   * @param obj the object
   */
  private ContainerProviderRequest(T obj) {
    this.obj = obj;
  }

  /**
   * Get obj attribute.
   * @return obj
   */
  public T get() {
    return obj;
  }


  /*=========================================*/
  // BEGIN GENERATED CODE
  /*=========================================*/

  /*=========================================*/
  /*------------BUILDER----------------------*/
  /*=========================================*/

  /**
   * DesignMyAppRequest is used to create a new ContainerProvider using three parameters (all mandatory):
   * Your template tag.
   * A hostname that point to the container provider client
   * A keyId and a secretKey that protect your container provider client
   * <p/>
   * The particularity of this provider, is that it can be used directly with our default implementation of
   * the Container manager API. ( See knowledge Base at 3.1.2 of the 2 section )
   * <p/>
   * Use the builder pattern to create a new request :
   * ContainerProviderRequest request = ContainerProviderRequest.designMyApp()
   * .templateTag("myTemplateTag")
   * .hostname("http://myServeurUrl:8080")
   * .keyId("myKeyId")
   * .secretKey("mySecretKey")
   * .poolSize(20)
   * .ttl(60) [optional]
   * .build();
   *
   * @return new DesignMyAppRequest container
   */
  public static DesignMyAppRequest designMyApp() {
    return new DesignMyAppRequest();
  }

  public static class DesignMyAppRequest {

    private String templateTag;

    private String keyId;

    private String secretKey;

    private String hostname;

    private int poolSize;

    private int ttl;

    private DesignMyAppRequest() {
    }

    public DesignMyAppRequest templateTag(String templateTag) {
      this.templateTag = templateTag;
      return this;
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
     * The provider containers Time To Live in minutes.
     * If this parameter is not provided, the containers will live forever, unless set otherwise.
     * If this parameter is provided, it will force each container to be automatically shutdown after that ttl is expired.
     *
     * @param ttl the children containers time to live in minutes
     * @return building DesignMyAppRequest
     */
    public DesignMyAppRequest ttl(int ttl) {
      if (ttl < 0) {
        throw new IllegalArgumentException("TTL Cannot be negative.");
      }
      this.ttl = ttl;
      return this;
    }

    public ContainerProviderRequest<DesignMyAppRequest> build() {
      if (this.hostname == null || this.hostname == null || this.keyId == null || this.secretKey == null || this.poolSize <= 0) {
        throw new IllegalArgumentException("None of these parameters should be null : templateTag, hostname, keyId, secretKey, and poolSize must be strictly superior to 0");
      }
      return new ContainerProviderRequest<>(this);
    }

    public String getKeyId() {
      return keyId;
    }

    public String getSecretKey() {
      return secretKey;
    }

    public String getTemplateTag() {
      return templateTag;
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
  /*=========================================*/
  // END GENERATED CODE
  /*=========================================*/
}
