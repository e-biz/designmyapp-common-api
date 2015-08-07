package mobi.designmyapp.common.container.listener;

import mobi.designmyapp.common.container.provider.Node;

/**
 * Created by Loïc Ortola on 23/07/2015.
 * This class provides update callbacks to the ContainerManager Instance.
 */
public interface NodeChangeListener {

  /**
   * Callback is triggered when a Node has an updated state.
   *
   * @param node the updated node
   */
  void onNodeChanged(Node node);
}