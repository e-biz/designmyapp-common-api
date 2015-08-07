package mobi.designmyapp.common.container.service;

import mobi.designmyapp.common.container.manager.ContainerManager;
import mobi.designmyapp.common.container.provider.Node;
import mobi.designmyapp.common.container.provider.NodeRequest;


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
   * Retrieve an node matching one of the default implementations.
   *
   * @param request the nodeRequest
   * @return your node object
   */
  Node createNode(NodeRequest request);


}
