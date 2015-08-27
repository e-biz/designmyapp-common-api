package mobi.designmyapp.common.container.provider;

/**
 * Created by Loïc Ortola on 11/03/2015.
 */
public class NodeRequest<T> {

  private T obj;

  /**
   * Constructor.
   *
   * @param obj the object
   */
  private NodeRequest(T obj) {
    this.obj = obj;
  }

  /**
   * Get obj attribute.
   *
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
   * DesignMyAppRequest is used to create a new Node using three parameters (all mandatory):
   * Your template tag.
   * A endpoint that point to the node client
   * A keyId and a secretKey that protect your node client
   * <p/>
   * The particularity of this node, is that it can be used directly with our default implementation of
   * the Container manager API. ( See knowledge Base at 3.1.2 of the 2 section )
   * <p/>
   * Use the builder pattern to create a new request :
   * NodeRequest request = NodeRequest.designMyApp()
   * .templateTag("myTemplateTag")
   * .endpoint("http://myServeurUrl:8080")
   * .keyId("myKeyId")
   * .secretKey("mySecretKey")
   * .poolSize(20)
   * .ttl(60) [optional]
   * .priority(1) [optional]
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

    private String endpoint;

    private int poolSize;

    private int ttl;

    private int priority;

    private DesignMyAppRequest() {
    }

    public DesignMyAppRequest templateTag(String templateTag) {
      this.templateTag = templateTag;
      return this;
    }

    public DesignMyAppRequest endpoint(String endpoint) {
      this.endpoint = endpoint;
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
     * The node Time To Live in minutes.
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

    public DesignMyAppRequest priority(int priority) {
      if (priority < 0) {
        throw new IllegalArgumentException("Priority Cannot be less than 0.");
      }
      this.priority = priority;
      return this;
    }

    public NodeRequest<DesignMyAppRequest> build() {
      if (this.endpoint == null || this.endpoint == null || this.keyId == null || this.secretKey == null || this.poolSize <= 0) {
        throw new IllegalArgumentException("None of these parameters should be null : templateTag, endpoint, keyId, secretKey, and poolSize must be strictly superior to 0");
      }
      return new NodeRequest<>(this);
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

    public String getEndpoint() {
      return endpoint;
    }

    public int getPoolSize() {
      return poolSize;
    }

    public int getTtl() {
      return ttl;
    }

    public int getPriority() {
      return priority;
    }
  }

  /**
   * AmazonEc2Request is used to create a new Node using three parameters (all mandatory):
   * Your template tag.
   * A endpoint that point representing the amazon region API endpoint
   * Your Amazon accessKey and secretKey with launch rights to your Amazon Account
   * Warning: we recommend that you create dedicated rights for DesignMyApp instances within Amazon EC2
   * <p/>
   * The particularity of this node, is that it can be used directly with our default implementation of
   * the Container manager API. ( See knowledge Base at 3.1.2 of the 2 section )
   * <p/>
   * Use the builder pattern to create a new request :
   * NodeRequest request = NodeRequest.amazonEc2()
   * .templateTag("myTemplateTag")
   * .endpoint("ec2.us-east-1.amazonaws.com")
   * .accessKey("myAmazonAccessKey")
   * .secretKey("myAmazonSecretKey")
   * .volumeSize(20)
   * .poolSize(20)
   * .securityGroups("launch-wizard-6")
   * .instanceType("t2.medium")
   * .name("myName") [optional]
   * .ttl(60) [optional]
   * .priority(1) [optional]
   * .lazy(true) [optional]
   * .build();
   *
   * @return new AmazonEc2Request container
   */
  public static AmazonEc2Request amazonEc2() {
    return new AmazonEc2Request();
  }

  public static class AmazonEc2Request {

    private String name;

    private String templateTag;

    private String accessKey;

    private String secretKey;

    private String endpoint;

    private String[] securityGroups;

    private String instanceType;

    private int volumeSize;

    private int poolSize;

    private int ttl;

    private int priority;

    private boolean lazy;

    private AmazonEc2Request() {
    }

    public AmazonEc2Request name(String name) {
      this.name = name;
      return this;
    }

    public AmazonEc2Request templateTag(String templateTag) {
      this.templateTag = templateTag;
      return this;
    }

    public AmazonEc2Request endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public AmazonEc2Request accessKey(String accessKey) {
      this.accessKey = accessKey;
      return this;
    }

    public AmazonEc2Request secretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    public AmazonEc2Request securityGroups(String... securityGroups) {
      this.securityGroups = securityGroups;
      return this;
    }

    public AmazonEc2Request instanceType(String instanceType) {
      this.instanceType = instanceType;
      return this;
    }

    public AmazonEc2Request volumeSize(int volumeSize){
      this.volumeSize = volumeSize;
      return this;
    }

    public AmazonEc2Request poolSize(int poolSize) {
      if (poolSize <= 0) {
        throw new IllegalArgumentException("PoolSize Cannot be less than or equal to 0.");
      }
      this.poolSize = poolSize;
      return this;
    }

    /**
     * The node Time To Live in minutes.
     * If this parameter is not provided, the containers will live forever, unless set otherwise.
     * If this parameter is provided, it will force each container to be automatically shutdown after that ttl is expired.
     *
     * @param ttl the children containers time to live in minutes
     * @return building AmazonEc2Request
     */
    public AmazonEc2Request ttl(int ttl) {
      if (ttl < 0) {
        throw new IllegalArgumentException("TTL Cannot be negative.");
      }
      this.ttl = ttl;
      return this;
    }

    public AmazonEc2Request priority(int priority) {
      if (priority < 0) {
        throw new IllegalArgumentException("Priority Cannot be less than 0.");
      }
      this.priority = priority;
      return this;
    }

    /**
     * Laziness of an Amazon node can be defined so that it does not launch a dedicated instance before it is necessary.
     * Enabling lazy mode will meaningfully increase the container init time on first container start.
     *
     * @param lazy to enable or not
     * @return building AmazonEc2Request
     */
    public AmazonEc2Request lazy(boolean lazy) {
      this.lazy = lazy;
      return this;
    }

    public NodeRequest<AmazonEc2Request> build() {
      if (this.endpoint == null || this.endpoint == null || this.accessKey == null || this.secretKey == null || this.instanceType == null || this.securityGroups == null || this.poolSize <= 0 || this.volumeSize <= 0) {
        throw new IllegalArgumentException("None of these parameters should be null : templateTag, endpoint, accessKey, secretKey, instanceType, securityGroups, and poolSize and volumeSize must be strictly superior to 0");
      }
      return new NodeRequest<>(this);
    }

    public String getName() {
      return name;
    }

    public String getAccessKey() {
      return accessKey;
    }

    public String getSecretKey() {
      return secretKey;
    }

    public String getTemplateTag() {
      return templateTag;
    }

    public String getEndpoint() {
      return endpoint;
    }

    public int getVolumeSize() {
      return volumeSize;
    }

    public int getPoolSize() {
      return poolSize;
    }

    public String getInstanceType() {
      return instanceType;
    }

    public String[] getSecurityGroups() {
      return securityGroups;
    }

    public int getTtl() {
      return ttl;
    }

    public int getPriority() {
      return priority;
    }

    public boolean isLazy() {
      return lazy;
    }
  }

  /**
   * GoogleComputeRequest is used to create a new Node using parameters (all mandatory):
   * Your template tag.
   * A endpoint that point representing the amazon region API endpoint
   * Your Amazon accessKey and secretKey with launch rights to your Amazon Account
   * Warning: we recommend that you create dedicated rights for DesignMyApp instances within Amazon EC2
   * <p/>
   * The particularity of this node, is that it can be used directly with our default implementation of
   * the Container manager API. ( See knowledge Base at 3.1.2 of the 2 section )
   * <p/>
   * Use the builder pattern to create a new request :
   * NodeRequest request = NodeRequest.googleCompute()
   * .templateTag("myTemplateTag")
   * .instanceName("myInstanceName")
   * .clientId("myGoogleClientId")
   * .clientSecret("myGoogleClientSecret")
   * .accessToken("myAccessToken")
   * .zoneName("myZoneName")
   * .projectId("myProjectId")
   * .volumeSize(10)
   * .build();
   *
   * @return new GoogleComputeRequest container
   */
  public static GoogleComputeRequest googleCompute() {
    return new GoogleComputeRequest();
  }

  public static class GoogleComputeRequest {
    /** Min volume size required */
    private static final long VOLUME_SIZE_MIN = 10L;

    private String templateTag;
    private String instanceName;
    private String clientId;
    private String clientSecret;
    private String accessToken;
    private String zoneName;
    private String projectId;
    private String instanceType;
    private long volumeSize;
    private int poolSize;
    private int ttl;
    private int priority;

    private GoogleComputeRequest() {}

    public GoogleComputeRequest templateTag(String templateTag) {
      this.templateTag = templateTag;
      return this;
    }

    public GoogleComputeRequest instanceName(String instanceName) {
      this.instanceName = instanceName;
      return this;
    }

    public GoogleComputeRequest clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    public GoogleComputeRequest clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    public GoogleComputeRequest accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public GoogleComputeRequest zoneName(String zoneName) {
      this.zoneName = zoneName;
      return this;
    }

    public GoogleComputeRequest projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    public GoogleComputeRequest instanceType(String instanceType) {
      this.instanceType = instanceType;
      return this;
    }

    public GoogleComputeRequest volumeSize(long volumeSize) {
      this.volumeSize = volumeSize;
      return this;
    }

    public GoogleComputeRequest poolSize(int poolSize) {
      if (poolSize <= 0) {
        throw new IllegalArgumentException("PoolSize Cannot be less than or equal to 0.");
      }
      this.poolSize = poolSize;
      return this;
    }

    public GoogleComputeRequest ttl(int ttl) {
      if (ttl < 0) {
        throw new IllegalArgumentException("TTL Cannot be negative.");
      }
      this.ttl = ttl;
      return this;
    }

    public GoogleComputeRequest priority(int priority) {
      if (priority < 0) {
        throw new IllegalArgumentException("Priority Cannot be less than 0.");
      }
      this.priority = priority;
      return this;
    }

    public NodeRequest<GoogleComputeRequest> build() {
      if (instanceName == null || clientId == null || clientSecret == null
          || accessToken == null || zoneName == null || projectId == null
          || instanceType == null) {
        throw new IllegalArgumentException("All fields are required");
      }
      if (volumeSize < VOLUME_SIZE_MIN) {
        throw new IllegalArgumentException("Minimum required volume size is " + VOLUME_SIZE_MIN);
      }
      if (poolSize <= 0) {
        throw new IllegalArgumentException("PoolSize Cannot be less than or equal to 0.");
      }
      if (ttl < 0) {
        throw new IllegalArgumentException("TTL Cannot be negative.");
      }
      if (priority < 0) {
        throw new IllegalArgumentException("Priority Cannot be less than 0.");
      }
      return new NodeRequest<>(this);
    }

    public String getTemplateTag() {
      return templateTag;
    }

    public String getInstanceName() {
      return instanceName;
    }

    public String getClientId() {
      return clientId;
    }

    public String getClientSecret() {
      return clientSecret;
    }

    public String getAccessToken() {
      return accessToken;
    }

    public String getZoneName() {
      return zoneName;
    }

    public String getProjectId() {
      return projectId;
    }

    public long getVolumeSize() {
      return volumeSize;
    }

    public String getInstanceType() {
      return instanceType;
    }

    public int getPoolSize() {
      return poolSize;
    }

    public int getTtl() {
      return ttl;
    }

    public int getPriority() {
      return priority;
    }
  }

  /*=========================================*/
  // END GENERATED CODE
  /*=========================================*/
}
