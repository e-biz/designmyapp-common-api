package mobi.designmyapp.common.container.listener;

import mobi.designmyapp.common.container.provider.ContainerProvider;

/**
 * Created by Loïc Ortola on 23/07/2015.
 * This class provides update callbacks to the ContainerManager Instance.
 */
public interface ContainerProviderChangeListener {
  void onContainerProviderChanged(ContainerProvider provider);
}