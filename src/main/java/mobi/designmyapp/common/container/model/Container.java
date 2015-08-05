package mobi.designmyapp.common.container.model;

import mobi.designmyapp.common.util.UtilsFactory;

import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Loïc Ortola on 21/07/2015.
 * <p/>
 * The Container represents Container.
 * Containers can be of two types:
 * <ul>
 * <li>Data Volume Container: Does not have a task, but is a persistent data volume. See it as an attached storage space.
 *
 * @see <a href="https://docs.docker.com/userguide/dockervolumes/#adding-a-data-volume">https://docs.docker.com/userguide/dockervolumes/#adding-a-data-volume</a></li>
 * <li>Command Container: Has a task, executes one main command.</li>
 * </ul>
 * This is a perfect example of how 4 containers could be composed together.
 * <p/>
 * The 4 images are:
 * dma-storage: A DataVolumeContainer supposed to persist three folders
 * dma-mongo: A database using the dma-storage
 * dma-engine: A web application using both the dma-storage and linked to the database.
 * dma-website: A website using the dma-storage, the web application and the database.
 * <p/>
 * Container dockerVolumeConfig = Container.builder()
 * .name("my-docker-volume")
 * .image("dma-storage")
 * .toDataVolumeContainer()
 * .addVolume(Volume.create("/opt/data"))
 * .addVolume(Volume.create("/var/log"))
 * .addVolume(Volume.create("/home/myhomefolder"))
 * .build();
 * <p/>
 * Container dockerDbConfig = Container.builder()
 * .name("my-docker-db")
 * .image("dma-mongo")
 * .toCommandContainer()
 * .bindDataVolumeContainer("my-docker-volume")
 * .mode(Mode.DETACHED)
 * .build();
 * <p/>
 * Container dockerWebappConfig = Container.builder()
 * .name("my-docker-webapp")
 * .image("dma-engine")
 * .toCommandContainer()
 * .bindDataVolumeContainer("my-docker-volume")
 * .addEnvVariable(EnvVariable.create("M2_HOME", "/home/myhomefolder/.m2/repository"))
 * .addEnvVariable(EnvVariable.create("DMA_ENVIRONMENT", "PRODUCTION"))
 * .linkContainer(Link.create("my-docker-db", "dma-db"))
 * .mode(Mode.DETACHED)
 * .build();
 * <p/>
 * Container dockerWebsiteConfig = Container.builder()
 * .name("my-docker-website")
 * .image("dma-website")
 * .toCommandContainer()
 * .bindDataVolumeContainer("my-docker-volume")
 * .linkContainer(Link.create("my-docker-db", "dma-db"))
 * .linkContainer(Link.create("my-docker-webapp", "dma-api"))
 * .mode(Mode.DETACHED)
 * .build();
 * <p/>
 * /*
 * This is another example of a typical batch container.
 * Using the CLEANUP mode, the container image will be completely removed after completion.
 * The bound data-volume will not be removed though.
 * <p/>
 * Container dockerBackupConfig = Container.builder()
 * .name("my-docker-backup")
 * .image("dma-backup")
 * .toCommandContainer()
 * .bindDataVolumeContainer("my-docker-volume")
 * .mode(Mode.CLEANUP)
 * .build();
 * <p/>
 * <p/>
 * This example lays out how to bind host volumes and ports.
 * Warning: in a multi-container environment, those commands should be used with care.
 * Only one container will be able to be bound to a particular port.
 * <p/>
 * Container dockerExposedConfig = Container.builder()
 * .name("my-docker-exposed")
 * .image("dma-official-website")
 * .toCommandContainer()
 * .bindHostVolume(HostVolume.create("/var/www", "/var/www"))
 * .mapPortToHost(PortForwarding.create(80, 80))
 * .mapPortToHost(PortForwarding.create(443, 443))
 * .mapPortToHost(PortForwarding.create("8000-8005", "8000-8005"))
 * .mode(Mode.CLEANUP)
 * .build();
 * <p/>
 * <p/>
 * You can also use faster builder methods to avoid calling the XX.create factories:
 * <p/>
 * <p/>
 * Container dockerFastConfig = Container.builder()
 * .name("my-docker-website")
 * .image("dma-website")
 * .toCommandContainer()
 * .bindDataVolumeContainer("my-docker-volume")
 * .bindHostVolume("/var/www", "/var/www")
 * .addEnvVariable("DMA_ENVIRONMENT", "PRODUCTION")
 * .linkContainer("my-docker-db", "dma-db")
 * .linkContainer("my-docker-webapp", "dma-api")
 * .mapPortToHost(443, 443)
 * .mapPortToHost("8000-8005", "8000-8005")
 * .mode(Mode.DETACHED)
 * .build();*
 */
public class Container {

  public static enum Type {
    COMMAND, DATA_VOLUME
  }

  private String containerId;
  private String containerGroupId;
  private String name;
  private Image image;
  private Options options;

  private int progress;
  private Status status;
  private URI endpoint;

  /**
   * Default constructor.
   */
  protected Container() {
  }


  /*=========================================*/
  // BEGIN GENERATED CODE
  /*=========================================*/
  
  public String getContainerId() {
    return containerId;
  }

  public String getContainerGroupId() {
    return containerGroupId;
  }

  public String getName() {
    return name;
  }

  public Image getImage() {
    return image;
  }

  public <T extends Options> T getOptions() {
    return (T) options;
  }

  public int getProgress() {
    return progress;
  }

  public Status getStatus() {
    return status;
  }

  public URI getEndpoint() {
    return endpoint;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public void setContainerGroupId(String containerGroupId) {
    this.containerGroupId = containerGroupId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public void setOptions(Options options) {
    this.options = options;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setEndpoint(URI endpoint) {
    this.endpoint = endpoint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Container that = (Container) o;

    if (image != null ? !image.equals(that.image) : that.image != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (options != null ? !options.equals(that.options) : that.options != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (image != null ? image.hashCode() : 0);
    result = 31 * result + (options != null ? options.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Container{" +
        "containerId='" + containerId + '\'' +
        ", containerGroupId='" + containerGroupId + '\'' +
        ", name='" + name + '\'' +
        ", image='" + image + '\'' +
        ", options=" + options +
        ", progress=" + progress +
        ", status=" + status +
        ", endpoint=" + endpoint +
        '}';
  }

/*=========================================*/
  // END GENERATED CODE
  /*=========================================*/

  /**
   * Builder method to build a custom Container.
   * Warning: Two types of containers can be created: CommandContainer and DataVolumeContainer.
   * Name and image should be filled in before
   *
   * @return the Container Builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /*=========================================*/
  // BEGIN GENERATED CODE
  /*=========================================*/

  public static class Builder {
    protected Container config;

    private Builder() {
      config = new Container();
    }


    public Builder name(String name) {
      config.name = name;
      return this;
    }

    public Builder image(Image image) {
      config.image = image;
      return this;
    }

    public Builder image(String image) {
      config.image = Image.create(image);
      return this;
    }

    /**
     * Set Container to CommandContainer.
     *
     * @return the CommandContainerBuilder
     */
    public CommandContainerBuilder toCommandContainer() {
      assertMandatoryFieldsValid();
      return new CommandContainerBuilder(config);
    }

    /**
     * Set Container to DataVolumeContainer.
     *
     * @return the DataVolumeContainerBuilder
     */
    public DataVolumeContainerBuilder toDataVolumeContainer() {
      assertMandatoryFieldsValid();
      return new DataVolumeContainerBuilder(config);
    }

    /**
     * Assert that name and image were filled out.
     *
     * @throws java.lang.IllegalStateException if not.
     */
    private void assertMandatoryFieldsValid() {
      if (config.name == null || config.name.trim().isEmpty() || config.image == null || config.image.name.trim().isEmpty()) {
        throw new IllegalStateException("Container image and name must be filled out before calling toCommandContainer or toDataVolumeContainer");
      }
    }
  }

  public static class Image {
    private String name;
    private String remote;
    private boolean fromDockerFile;
    private String authHeader;

    /**
     * POJO Constructor.
     */
    public Image() {

    }

    private Image(String name, String remote, boolean fromDockerFile) {
      this.name = name;
      this.remote = remote;
      this.fromDockerFile = fromDockerFile;
    }

    private Image(String name, String remote, boolean fromDockerFile, String authHeader) {
      this(name, remote, fromDockerFile);
      this.authHeader = authHeader;
    }


    /**
     * Build an image which already exists on the target machine.
     *
     * @param image  the image name
     * @return the Image instance
     */
    public static Image create(String image) {
      return new Image(image, null, false);
    }

    /**
     * Build an image from an external docker file.
     *
     * @param image  the image name
     * @param remote a Git repository URI or HTTP/HTTPS URI build source. If the URI specifies a filename, the file’s contents are placed into a file called Dockerfile.
     * @return the Image instance
     */
    public static Image buildFromDockerFile(String image, String remote) {
      return new Image(image, remote, true);
    }

    /**
     * Pull an image from an external docker registry.
     *
     * @param image  the image name
     * @param remote the registry to pull from
     * @return the Image instance
     */
    public static Image pullFromRegistry(String image, String remote) {
      return new Image(image, remote, false);
    }

    /**
     * Pull an image from an external docker registry.
     *
     * @param image  the image name
     * @param remote the registry to pull from
     * @param login the login to register to the registry
     * @param password the paswword to register to the registry
     * @return the Image instance
     */
    public static Image pullFromRegistry(String image, String remote, String login, String password) {
      ImageAuthentification imageAuthentification = new ImageAuthentification(login,password);
      String authHeader=UtilsFactory.getStringUtils().encodeBase64(imageAuthentification);
      return new Image(image, remote, false, authHeader);

    }

    public String getName() {
      return name;
    }

    public String getRemote() {
      return remote;
    }

    public String getAuthHeader() {
      return authHeader;
    }

    public boolean isFromDockerFile() {
      return fromDockerFile;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setRemote(String remote) {
      this.remote = remote;
    }

    public void setAuthHeader(String authHeader) {
      this.authHeader = authHeader;
    }

    public void setFromDockerFile(boolean fromDockerFile) {
      this.fromDockerFile = fromDockerFile;
    }

    private static class ImageAuthentification implements Serializable {
      private String username;
      private String password;

      public ImageAuthentification(String username, String password) {
        this.username = username;
        this.password = password;
      }
    }
  }



  /**
   * Represents a data-volume.
   *
   * @see <a href="https://docs.docker.com/userguide/dockervolumes/#adding-a-data-volume">https://docs.docker.com/userguide/dockervolumes/#adding-a-data-volume</a>
   */
  public static class Volume {
    private String path;

    /**
     * Pojo Constructor.
     */
    public Volume() {
    }

    /**
     * Constructor.
     *
     * @param path the data-volume path which will be exposed
     */
    private Volume(String path) {
      this.path = path;
    }

    /**
     * Factory method for Volume.
     *
     * @param path the data-volume path which will be exposed
     * @return the new Volume instance
     */
    public static Volume create(String path) {
      return new Volume(path);
    }


    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }
  }

  /**
   * Represents a host directory volume.
   *
   * @see <a href="https://docs.docker.com/userguide/dockervolumes/#mount-a-host-directory-as-a-data-volume">https://docs.docker.com/userguide/dockervolumes/#mount-a-host-directory-as-a-data-volume</a>
   */

  public static class HostVolume {
    private String hostPath;
    private String containerPath;

    /**
     * Pojo Constructor.
     */
    private HostVolume() {
    }

    /**
     * Constructor.
     *
     * @param hostPath      the host absolute path which will be mounted
     * @param containerPath the container absolute path to which it will be mounted on
     */
    private HostVolume(String hostPath, String containerPath) {
      this.hostPath = hostPath;
      this.containerPath = containerPath;
    }

    /**
     * Factory method for HostVolume.
     *
     * @param hostPath      the host absolute path which will be mounted
     * @param containerPath the container absolute path to which it will be mounted on
     * @return the new HostVolume instance
     */
    public static HostVolume create(String hostPath, String containerPath) {
      return new HostVolume(hostPath, containerPath);

    }

    public String getHostPath() {
      return hostPath;
    }

    public void setHostPath(String hostPath) {
      this.hostPath = hostPath;
    }

    public String getContainerPath() {
      return containerPath;
    }

    public void setContainerPath(String containerPath) {
      this.containerPath = containerPath;
    }
  }

  /**
   * Represents the running mode. Can either be detached or cleanup.
   *
   * @see <a href="https://docs.docker.com/reference/run/#detached-d">https://docs.docker.com/reference/run/#detached-d</a>
   * @see <a href="https://docs.docker.com/reference/run/#clean-up-rm">https://docs.docker.com/reference/run/#clean-up-rm</a>
   */
  public static enum Mode {
    /**
     * Will remove the container after task completion.
     */
    CLEANUP,
    /**
     * Starts the container in detached mode
     */
    DETACHED
  }

  /**
   * Represents an environment variable.
   *
   * @see <a href="https://docs.docker.com/reference/run/#env-environment-variables">https://docs.docker.com/reference/run/#env-environment-variables</a>
   */
  public static class EnvVariable {
    private String key;
    private String value;

    /**
     * Pojo Constructor.
     */
    public EnvVariable() {

    }

    /**
     * Constructor.
     * ex: PATH=/to/my/path
     *
     * @param key   the env variable key (PATH)
     * @param value the env value (/to/my/path)
     */
    private EnvVariable(String key, String value) {
      this.key = key;
      this.value = value;
    }

    /**
     * Factory method for EnvVariable.
     * ex: PATH=/to/my/path
     *
     * @param key   the env variable key (PATH)
     * @param value the env value (/to/my/path)
     * @return the new EnvVariable instance
     */
    public static EnvVariable create(String key, String value) {
      return new EnvVariable(key, value);
    }

    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  /**
   * Represents a link.
   *
   * @see <a href="https://docs.docker.com/userguide/dockerlinks/">https://docs.docker.com/userguide/dockerlinks/</a>
   */
  public static class Link {
    private String name;
    private String alias;

    /**
     * Pojo Constructor.
     */
    public Link() {

    }

    /**
     * Constructor.
     *
     * @param name  the container name to be linked to
     * @param alias the DNS alias the container will be callable from (added to /etc/hosts)
     */
    private Link(String name, String alias) {
      this.name = name;
      this.alias = alias;
    }

    /**
     * Factory method for Link.
     *
     * @param name  the container name to be linked to
     * @param alias the DNS alias the container will be callable from (added to /etc/hosts)
     * @return the new Link instance
     */
    public static Link create(String name, String alias) {
      return new Link(name, alias);
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAlias() {
      return alias;
    }

    public void setAlias(String alias) {
      this.alias = alias;
    }
  }

  /**
   * Represents the container's command to execute.
   *
   * @see <a href="https://docs.docker.com/reference/run/#general-form">https://docs.docker.com/reference/run/#general-form</a>
   */
  public static class Command {
    private String cmd;
    private String[] args;

    /**
     * Pojo Constructor.
     */
    public Command() {

    }

    /**
     * Constructor.
     *
     * @param cmd  the command to execute
     * @param args the command args (optional)
     */
    private Command(String cmd, String... args) {
      this.cmd = cmd;
      this.args = args;
    }

    /**
     * Factory method for Command.
     *
     * @param cmd  the container command to execute
     * @param args the command args (optional)
     * @return the new Command instance
     */
    public static Command create(String cmd, String... args) {
      return new Command(cmd, args);

    }

    public String getCmd() {
      return cmd;
    }

    public void setCmd(String cmd) {
      this.cmd = cmd;
    }

    public String[] getArgs() {
      return args;
    }

    public void setArgs(String[] args) {
      this.args = args;
    }
  }

  /**
   * Represents a port forwarding map entry.
   *
   * @see <a href="https://docs.docker.com/reference/run/#expose-incoming-ports">https://docs.docker.com/reference/run/#expose-incoming-ports</a>
   */
  public static class PortForwarding {
    private int host;
    private int container;
    private String hostRange;
    private String containerRange;

    /**
     * Pojo Constructor.
     */
    public PortForwarding() {

    }

    /**
     * Constructor.
     *
     * @param host      the host port to be exposed
     * @param container the container port to be mapped to
     */
    private PortForwarding(int host, int container) {
      this.host = host;
      this.container = container;
    }

    /**
     * Constructor.
     *
     * @param hostRange      the host port range to be exposed
     * @param containerRange the container port range to be mapped to
     */
    private PortForwarding(String hostRange, String containerRange) {
      this.hostRange = hostRange;
      this.containerRange = containerRange;
    }

    /**
     * Constructor.
     *
     * @param hostPort      the host port to be exposed
     * @param containerPort the container port to be mapped to
     * @return the new PortForwarding instance
     */
    public static PortForwarding create(int hostPort, int containerPort) {
      return new PortForwarding(hostPort, containerPort);
    }

    public static PortForwarding create(String hostPortRange, String containerPortRange) {
      Pattern p = Pattern.compile("^\\d+-\\d+$");
      if (!p.matcher(hostPortRange).matches() || !p.matcher(containerPortRange).matches()) {
        throw new IllegalArgumentException("Port Range must be declared like this: XXXXX-YYYYY. example: 80-123");
      }
      Pattern p2 = Pattern.compile("-");
      String[] hostPorts = p2.split(hostPortRange);
      String[] containerPorts = p2.split(hostPortRange);
      if (!isValidRangeSet(hostPorts, containerPorts)) {
        throw new IllegalArgumentException("Range Set is invalid. All ports in Range must be between 1 and 65535.");
      }
      return new PortForwarding(hostPortRange, containerPortRange);
    }

    /**
     * Checks whether the port range set is valid or not.
     *
     * @param host      the host port range array
     * @param container the container port range array
     * @return true if valid, false otherwise
     */
    private static boolean isValidRangeSet(String[] host, String[] container) {
      int beginHost = Integer.parseInt(host[0]);
      int endHost = Integer.parseInt(host[1]);
      int beginContainer = Integer.parseInt(container[0]);
      int endContainer = Integer.parseInt(container[1]);
      return (isValidRange(beginHost, endHost) && isValidRange(beginHost, endHost) && (endHost - beginHost) == (endContainer - beginContainer));
    }

    /**
     * Checks whether a port range is valid or not.
     *
     * @param begin the begin port
     * @param end   the end port
     * @return true if valid, false otherwise
     */
    private static boolean isValidRange(int begin, int end) {
      return (isValidPort(begin) && isValidPort(end) && (end > begin));
    }

    /**
     * Checks whether a port is valid or not.
     *
     * @param port the port
     * @return true if valid, false otherwise
     */
    private static boolean isValidPort(int port) {
      return port > 0 && port < 65535;
    }

    public int getContainer() {
      return container;
    }

    public int getHost() {
      return host;
    }

    public String getContainerRange() {
      return containerRange;
    }

    public String getHostRange() {
      return hostRange;
    }

    public void setHost(int host) {
      this.host = host;
    }

    public void setContainer(int container) {
      this.container = container;
    }

    public void setHostRange(String hostRange) {
      this.hostRange = hostRange;
    }

    public void setContainerRange(String containerRange) {
      this.containerRange = containerRange;
    }
  }

  public static abstract class Options {
    protected Type type;

    public Type getType() {
      return type;
    }

    public void setType(Type type) {
      this.type = type;
    }
  }

  public static class DataVolumeOptions extends Options {
    protected Set<Volume> volumes;

    public Set<Volume> getVolumes() {
      return volumes;
    }
    public void setVolumes(Set<Volume> volumes) {
      this.volumes = volumes;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      DataVolumeOptions that = (DataVolumeOptions) o;

      if (volumes != null ? !volumes.equals(that.volumes) : that.volumes != null) {
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return volumes != null ? volumes.hashCode() : 0;
    }

    @Override
    public String toString() {
      return "DataVolumeOptions{" +
          "volumes=" + volumes +
          '}';
    }
  }

  public static class CommandOptions extends Options {
    protected Set<String> dataVolumeContainers;
    protected Set<HostVolume> hostVolumes;
    protected Set<EnvVariable> envVariables;
    protected Mode mode;
    protected Set<Link> links;
    protected boolean mapExposedPorts;
    protected Map<Integer, Integer> portMap;
    protected Command command;

    public Set<String> getDataVolumeContainers() {
      return dataVolumeContainers;
    }

    public Set<HostVolume> getHostVolumes() {
      return hostVolumes;
    }

    public Set<EnvVariable> getEnvVariables() {
      return envVariables;
    }

    public Mode getMode() {
      return mode;
    }

    public Set<Link> getLinks() {
      return links;
    }

    public Command getCommand() {
      return command;
    }

    public boolean getMapExposedPorts() {
      return mapExposedPorts;
    }

    public Map<Integer, Integer> getPortMap() {
      return portMap;
    }

    public void setDataVolumeContainers(Set<String> dataVolumeContainers) {
      this.dataVolumeContainers = dataVolumeContainers;
    }

    public void setHostVolumes(Set<HostVolume> hostVolumes) {
      this.hostVolumes = hostVolumes;
    }

    public void setEnvVariables(Set<EnvVariable> envVariables) {
      this.envVariables = envVariables;
    }

    public void setMode(Mode mode) {
      this.mode = mode;
    }

    public void setLinks(Set<Link> links) {
      this.links = links;
    }

    public void setMapExposedPorts(boolean mapExposedPorts) {
      this.mapExposedPorts = mapExposedPorts;
    }

    public void setPortMap(Map<Integer, Integer> portMap) {
      this.portMap = portMap;
    }

    public void setCommand(Command command) {
      this.command = command;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      CommandOptions that = (CommandOptions) o;

      if (dataVolumeContainers != null ? !dataVolumeContainers.equals(that.dataVolumeContainers) : that.dataVolumeContainers != null) {
        return false;
      }
      if (envVariables != null ? !envVariables.equals(that.envVariables) : that.envVariables != null) {
        return false;
      }
      if (hostVolumes != null ? !hostVolumes.equals(that.hostVolumes) : that.hostVolumes != null) {
        return false;
      }
      if (links != null ? !links.equals(that.links) : that.links != null) {
        return false;
      }
      if (mode != that.mode) {
        return false;
      }
      if (portMap != null ? !portMap.equals(that.portMap) : that.portMap != null) {
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int result = dataVolumeContainers != null ? dataVolumeContainers.hashCode() : 0;
      result = 31 * result + (hostVolumes != null ? hostVolumes.hashCode() : 0);
      result = 31 * result + (envVariables != null ? envVariables.hashCode() : 0);
      result = 31 * result + (mode != null ? mode.hashCode() : 0);
      result = 31 * result + (links != null ? links.hashCode() : 0);
      result = 31 * result + (portMap != null ? portMap.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "CommandOptions{" +
          "dataVolumeContainers=" + dataVolumeContainers +
          ", hostVolumes=" + hostVolumes +
          ", envVariables=" + envVariables +
          ", mode=" + mode +
          ", links=" + links +
          ", mapExposedPorts=" + mapExposedPorts +
          ", portMap=" + portMap +
          ", command=" + command +
          '}';
    }

  }

  public static abstract class ContainerBuilder {
    protected Container config;

    public ContainerBuilder(Container config) {
      this.config = config;
    }

    public Container build() {
      return config;
    }
  }

  public static class DataVolumeContainerBuilder extends ContainerBuilder {
    private DataVolumeOptions options;

    private DataVolumeContainerBuilder(Container container) {
      super(container);
      this.options = new DataVolumeOptions();

      this.options.type = Type.DATA_VOLUME;
      this.config.options = options;
    }

    public DataVolumeContainerBuilder addVolume(String path) {
      return addVolume(Volume.create(path));
    }

    public DataVolumeContainerBuilder addVolume(Volume v) {
      if (options.volumes == null) {
        options.volumes = new HashSet<>();
      }
      options.volumes.add(v);
      return this;
    }
  }

  public static class CommandContainerBuilder extends ContainerBuilder {
    private CommandOptions options;

    private CommandContainerBuilder(Container container) {
      super(container);
      this.options = new CommandOptions();

      this.options.type = Type.COMMAND;
      this.config.options = options;
      this.options.mode = Mode.DETACHED;
      this.options.portMap = new HashMap<>();
    }

    public CommandContainerBuilder bindDataVolumeContainer(String v) {
      if (options.dataVolumeContainers == null) {
        options.dataVolumeContainers = new HashSet<>();
      }
      options.dataVolumeContainers.add(v);
      return this;
    }

    public CommandContainerBuilder bindHostVolume(String hostPath, String containerPath) {
      return bindHostVolume(HostVolume.create(hostPath, containerPath));
    }

    public CommandContainerBuilder bindHostVolume(HostVolume v) {
      if (options.hostVolumes == null) {
        options.hostVolumes = new HashSet<>();
      }
      options.hostVolumes.add(v);
      return this;
    }

    public CommandContainerBuilder addEnvVariable(String key, String value) {
      return addEnvVariable(EnvVariable.create(key, value));
    }

    public CommandContainerBuilder addEnvVariable(EnvVariable e) {
      if (options.envVariables == null) {
        options.envVariables = new HashSet<>();
      }
      options.envVariables.add(e);
      return this;
    }

    public CommandContainerBuilder mode(Mode mode) {
      options.mode = mode;
      return this;
    }

    public CommandContainerBuilder linkContainer(String name, String alias) {
      return linkContainer(Link.create(name, alias));
    }

    public CommandContainerBuilder linkContainer(Link l) {
      if (options.links == null) {
        options.links = new HashSet<>();
      }
      options.links.add(l);
      return this;
    }

    public CommandContainerBuilder executeCommand(String cmd, String... args) {
      return executeCommand(Command.create(cmd, args));
    }

    public CommandContainerBuilder executeCommand(Command command) {
      if (options.command != null) {
        throw new IllegalStateException("Can only execute one command.");
      }
      options.command = command;
      return this;
    }

    public CommandContainerBuilder mapExposedPorts(boolean map) {
      options.mapExposedPorts = map;
      return this;
    }

    public CommandContainerBuilder mapPortToHost(PortForwarding portForwarding) {
      if (portForwarding.host > 0) {
        mapPortToHost(portForwarding.host, portForwarding.container);
      } else {
        mapPortToHost(portForwarding.hostRange, portForwarding.containerRange);
      }
      return this;
    }

    public CommandContainerBuilder mapPortToHost(int hostPort, int containerPort) {
      if (options.portMap == null) {
        options.portMap = new HashMap<>();
      }
      if (!PortForwarding.isValidPort(hostPort) || !PortForwarding.isValidPort(containerPort)) {
        throw new IllegalArgumentException("Port Range must be declared like this: XXXXX-YYYYY. example: 80-123");
      }
      options.portMap.put(containerPort, hostPort);
      return this;
    }

    public CommandContainerBuilder mapPortToHost(String hostPortRange, String containerPortRange) {
      Pattern p = Pattern.compile("^\\d+-\\d+$");
      if (!p.matcher(hostPortRange).matches() || !p.matcher(containerPortRange).matches()) {
        throw new IllegalArgumentException("Port Range must be declared like this: XXXXX-YYYYY. example: 80-123");
      }
      Pattern p2 = Pattern.compile("-");
      String[] hostPorts = p2.split(hostPortRange);
      String[] containerPorts = p2.split(hostPortRange);

      if (!PortForwarding.isValidRangeSet(hostPorts, containerPorts)) {
        throw new IllegalArgumentException("Range Set is invalid. All ports in Range must be between 1 and 65535.");
      }

      int beginHostPort = Integer.valueOf(hostPorts[0]);
      int beginContainerPort = Integer.valueOf(containerPorts[0]);
      int rangeSize = Integer.valueOf(hostPorts[1]) - beginHostPort;

      for (Integer i = 0; i < rangeSize; i++) {
        options.portMap.put(beginContainerPort + i, beginHostPort + i);
      }
      return this;
    }
  }
  
  /*=========================================*/
  // END GENERATED CODE
  /*=========================================*/

}
