/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.engine.service;

import mobi.designmyapp.common.engine.builder.Builder;
import java.io.File;

/**
 * This class provides resource services
 * Created by Loïc Ortola on 24/07/14.
 */
public interface ResourceService {

  /**
   * Retrieve the resource directory of an application
   * @param appId application uuid
   * @return the application resource directory
   */
  File getResourceDirectory(String appId);

  /**
   * Retrieve the static resources directory for a specific template tag
   * @param templateTag input template tag
   * @return the static resources directory
   */
  File getStaticResourcesDirectory(String templateTag);

  /**
   * Retrieve the work directory typed for current target
   * @param type build target type
   * @param appId application uuid
   * @return the work directory
   */
  File getWorkDirectory(Builder.Type type, String appId);

  /**
   * Retrieve the tmp directory of an application
   * @param appId application uuid
   * @return the tmp directory
   */
  File getTmpDirectory(String appId);

  /**
   * Retrieve the template directory for a specific template and target
   * @param type build target type
   * @param templateTag input template tag
   * @return the template directory
   */
  File getTemplateDirectory(Builder.Type type, String templateTag);

  /**
   * Retrieve environment URL
   * @return current environment base URL
   */
  String getEnvironmentBaseUrl();
}
