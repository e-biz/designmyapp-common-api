/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandre Nunesse on 1/7/15.
 */
public interface IZipUtils {

  void unzip(File zipFile, List<String> validExtensions, List<String> errorFiles) throws IOException;

}
