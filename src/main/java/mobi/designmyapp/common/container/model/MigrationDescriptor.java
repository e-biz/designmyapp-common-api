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
  private Container migrationContainer;

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

  public Container getMigrationContainer() {
    return migrationContainer;
  }

  public void setMigrationContainer(Container migrationContainer) {
    this.migrationContainer = migrationContainer;
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

    public Builder container(Container container) {
      md.migrationContainer = container;
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
