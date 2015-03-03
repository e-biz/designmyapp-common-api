/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/

package mobi.designmyapp.common.util;

import java.io.File;

/**
 * This class provides resource utility methods
 * Created by Alexandre Nunesse on 08/01/15.
 */
public interface ResourceUtils {

  /**
   * Get a resource directory for a specific application and namespace
   * @param appId application uuid
   * @param namespace resource namespace
   * @return the specific directory in resources
   */
  File getResourceDirectory(String appId, String namespace);

  /**
   * Create url to retrieve data from server resources
   * @param appId application uuid
   * @param namespace resource namespace
   * @param filename name of the file to expose
   * @param portalName portal to access the file
   * @return a String representing the url to access the file
   */
  String createUrl(String appId, String namespace, String filename, String portalName);

  /**
   * Serialize an object to a File using a default mapper
   * @param destFile the file in which the object will be serialized
   * @param obj the object to serialize
   * @return boolean representing if the serialization was successful or not
   */
  boolean serializeObjectToFile(File destFile, Object obj);

}
