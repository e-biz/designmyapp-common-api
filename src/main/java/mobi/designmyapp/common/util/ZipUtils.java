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
