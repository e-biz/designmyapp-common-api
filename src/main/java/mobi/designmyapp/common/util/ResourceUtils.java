/*
 Copyright 2015 eBusiness Information
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
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
