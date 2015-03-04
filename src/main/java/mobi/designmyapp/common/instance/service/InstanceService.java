package mobi.designmyapp.common.instance.service;

import mobi.designmyapp.common.instance.manager.InstanceManager;

/**
 * Created by Loïc Ortola on 04/03/2015.
 */
public interface InstanceService {
  /**
   * Retrieve the template instance manager
   * @param templateTag input template tag
   * @return template instance manager
   */
  <T extends InstanceManager> InstanceManager getInstanceManager(String templateTag);
}
