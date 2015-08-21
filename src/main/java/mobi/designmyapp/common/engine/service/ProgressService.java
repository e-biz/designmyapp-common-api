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
   * @param buildStepKey Unique build step key
   * @param progress Progression information
   */
  void progress(String appId, String buildStepKey, ContainerProgressRequest progress);
}
