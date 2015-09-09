package mobi.designmyapp.common.container.model;

/**
 * Created by Loïc Ortola on 03/08/2015.
 * A Migration Descriptor is use to declare a migration path.
 * To migrate from version A to version B, a migration container needs to be provided.
 * The container will be linked to the original
 */
public class MigrationDescriptor {

  private String versionFrom;
  private String versionTo;
  private String migrationImage;
  private Integer pauseTimeout;
  private Integer migrationTimeout;
  private Integer dumpTimeout;
  private Integer exposedBundleTtl;

  public String getVersionFrom() {
    return versionFrom;
  }

  public void setVersionFrom(String versionFrom) {
    this.versionFrom = versionFrom;
  }

  public String getVersionTo() {
    return versionTo;
  }

  public void setVersionTo(String versionTo) {
    this.versionTo = versionTo;
  }

  public String getMigrationImage() {
    return migrationImage;
  }

  public void setMigrationImage(String image) {
    this.migrationImage = image;
  }

  public Integer getPauseTimeout() {
    return pauseTimeout;
  }

  public void setPauseTimeout(Integer pauseTimeout) {
    this.pauseTimeout = pauseTimeout;
  }

  public Integer getMigrationTimeout() {
    return migrationTimeout;
  }

  public void setMigrationTimeout(Integer migrationTimeout) {
    this.migrationTimeout = migrationTimeout;
  }

  public Integer getDumpTimeout() {
    return dumpTimeout;
  }

  public void setDumpTimeout(Integer dumpTimeout) {
    this.dumpTimeout = dumpTimeout;
  }

  public Integer getExposedBundleTtl() {
    return exposedBundleTtl;
  }

  public void setExposedBundleTtl(Integer exposedBundleTtl) {
    this.exposedBundleTtl = exposedBundleTtl;
  }


  /*=========================================*/
  // BEGIN GENERATED CODE
  /*=========================================*/

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private MigrationDescriptor md;

    private Builder() {
      md = new MigrationDescriptor();
    }

    public Builder from(String version) {
      md.versionFrom = version;
      return this;
    }

    public Builder to(String version) {
      md.versionTo = version;
      return this;
    }

    public Builder migrationImage(String image) {
      md.migrationImage = image;
      return this;
    }

    public Builder pauseTimeout(Integer pauseTimeout) {
      md.pauseTimeout = pauseTimeout;
      return this;
    }

    public Builder migrationTimeout(Integer migrationTimeout) {
      md.migrationTimeout = migrationTimeout;
      return this;
    }

    public Builder dumpTimeout(Integer dumpTimeout) {
      md.dumpTimeout = dumpTimeout;
      return this;
    }

    public MigrationDescriptor build() {
      return md;
    }

  }
  
  /*=========================================*/
  // END GENERATED CODE
  /*=========================================*/

}
