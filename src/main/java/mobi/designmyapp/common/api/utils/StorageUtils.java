/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/

package mobi.designmyapp.common.api.utils;

import java.io.File;

/**
 * Created by Alexandre Nunesse on 1/6/15.
 */
public interface StorageUtils {

  void copyDirectoryContent(File sourceDir, File destDir);

  File locateFile(File sourceDir, String fileRelativePath);

  boolean isWindows();

  boolean isMac();
}
