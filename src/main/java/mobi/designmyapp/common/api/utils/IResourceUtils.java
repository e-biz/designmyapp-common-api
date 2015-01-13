/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/

package mobi.designmyapp.common.api.utils;

import java.io.File;

/**
 * Created by Alexandre Nunesse on 1/8/15.
 */
public interface IResourceUtils {

  File getResourceDirectory(String appId, String nameSpace);

  String createUrl(String appId, String namespace, String filename, String portalName);

  boolean serializeObjectToFile(File destFile, Object obj);

}
