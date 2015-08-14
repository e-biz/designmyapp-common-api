package mobi.designmyapp.common.engine.service;

import mobi.designmyapp.common.container.model.ContainerProgressRequest;

/**
 * Service to provide progress capabilities.
 */
public interface ProgressService {
  /**
   * Set the progress for a given task.
   *
   * @param appId App ID
   * @param taskId Unique task identifier
   * @param progress Progression information
   */
  void progress(String appId, String taskId, ContainerProgressRequest progress);
}
