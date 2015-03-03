/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class provides utility methods for Zip management
 * Created by Alexandre Nunesse on 07/01/15.
 */
public interface ZipUtils {

  /**
   * Extract Zip file in temp folder to prepare all sources
   * @param zipFile input zip File
   * @param validExtensions input File valid extensions
   * @param errorFiles Files with invalid extensions or names not treated
   * @throws IOException
   */
  void unzip(File zipFile, List<String> validExtensions, List<String> errorFiles) throws IOException;

}
