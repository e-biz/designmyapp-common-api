package mobi.designmyapp.common.container.service;

import mobi.designmyapp.common.container.manager.ContainerManager;
import mobi.designmyapp.common.container.provider.ContainerProvider;
import mobi.designmyapp.common.container.provider.ContainerProviderRequest;


/**
 * Created by Loïc Ortola on 04/03/2015.
 */
public interface ContainerService {

  /**
   * Retrieve the template instance manager.
   *
   * @param templateTag input template tag
   * @param <T>         output instance manager
   * @return template instance manager
   */
  <T extends ContainerManager> ContainerManager getContainerManager(String templateTag);

  /**
   * Retrieve an instance provider matching one of the default implementations.
   *
   * @param request the InstanceProviderRequest
   * @return your instance provider object
   */
  ContainerProvider createContainerProvider(ContainerProviderRequest request);


}
