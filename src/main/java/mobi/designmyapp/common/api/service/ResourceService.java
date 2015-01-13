/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.service;

import mobi.designmyapp.common.api.builder.Builder;

import java.io.File;

/**
 * Created by Loïc Ortola on 7/24/14.
 */
public interface ResourceService{
  File getResourceDirectory(String appId);
  File getStaticResourcesDirectory(String templateTag);
  File getWorkDirectory(Builder.Type type, String appId);
  File getTmpDirectory(String appId);
  File getTemplateDirectory(Builder.Type type, String templateTag);
  String getEnvironmentBaseUrl();

}
