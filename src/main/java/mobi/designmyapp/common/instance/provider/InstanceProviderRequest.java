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

  public static DesignMyappRequest designMyApp() {
    return new DesignMyappRequest();
  }

  public static class DesignMyappRequest {

    private String keyId ;

    private String secretKey ;

    private String hostname;

    private DesignMyappRequest() {

    }

    public DesignMyappRequest hostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    public DesignMyappRequest keyId(String keyId) {
      this.keyId = keyId;
      return this;
    }
    
    public DesignMyappRequest secretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    public InstanceProviderRequest<DesignMyappRequest> build() {
      if (this.hostname == null || this.keyId == null || this.secretKey == null) {
        throw new NullPointerException("None of this parameter should be null : hostname, keyId, secretKey");
      }
      // Implement your check logic here. (all params set etc...)
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

  public static ElasticBeansTalkRequest elasticBeansTalk() {
    return new ElasticBeansTalkRequest();
  }

  public static class ElasticBeansTalkRequest {

    private String url;
    private String secret;

    private ElasticBeansTalkRequest() {

    }

    public ElasticBeansTalkRequest baseUrl(String url) {
      this.url = url;
      return this;
    }

    public ElasticBeansTalkRequest secret(String secret) {
      this.secret = secret;
      return this;
    }

    // ETC ETC

    public InstanceProviderRequest<ElasticBeansTalkRequest> build() {
      // Implement your check logic here. (all params set etc...)
      return new InstanceProviderRequest<>(this);
    }
  }

}
