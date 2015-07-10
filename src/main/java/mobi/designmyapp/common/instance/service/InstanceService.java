package mobi.designmyapp.common.instance.service;

import mobi.designmyapp.common.instance.manager.InstanceManager;
import mobi.designmyapp.common.instance.provider.InstanceProvider;
import mobi.designmyapp.common.instance.provider.InstanceProviderRequest;


/**
 * Created by Loïc Ortola on 04/03/2015.
 */
public interface InstanceService {

  /**
   * Retrieve the template instance manager
   *
   * @param templateTag input template tag
   * @param <T>         output instance manager
   * @return template instance manager
   */
  <T extends InstanceManager> InstanceManager getInstanceManager(String templateTag);

  /**
   * Retrieve an instance provider matching one of the default implementations managed by DesignMyApp
   *
   * @param request the InstanceProviderRequest
   * @return your instance provider object
   */
  InstanceProvider createInstanceProvider(InstanceProviderRequest request);


}
