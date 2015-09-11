package mobi.designmyapp.common.container.model;


public class MigrationRemoteBundle {

  private String host;
  private int port;
  private String securityToken;

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public String getSecurityToken() {
    return securityToken;
  }

  /*=========================================*/
  // BEGIN GENERATED CODE
  /*=========================================*/

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private MigrationRemoteBundle bundle;

    private Builder() {
      bundle = new MigrationRemoteBundle();
    }

    public Builder host(String host) {
      bundle.host = host;
      return this;
    }

    public Builder port(int port) {
      bundle.port = port;
      return this;
    }

    public Builder securityToken(String securityToken) {
      bundle.securityToken = securityToken;
      return this;
    }

    public MigrationRemoteBundle build() {
      return bundle;
    }

  }

  /*=========================================*/
  // END GENERATED CODE
  /*=========================================*/
}
