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

    private String url;

    private DesignMyappRequest() {

    }

    public DesignMyappRequest baseUrl(String url) {
      this.url = url;
      return this;
    }

    // ETC ETC
    public InstanceProviderRequest<DesignMyappRequest> build() {
      // Implement your check logic here. (all params set etc...)
      return new InstanceProviderRequest(this);
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
      return new InstanceProviderRequest(this);
    }
  }

}
