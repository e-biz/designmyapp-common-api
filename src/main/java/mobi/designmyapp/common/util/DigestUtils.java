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
 * This class provides utility methods to generate hash data
 * Created by Loïc Ortola on 05/02/15.
 */
public interface DigestUtils {

  /**
   * Calculates the SHA-1 digest and returns the value as a hex string
   * @param data Data to digest
   * @return SHA-1 digest as a hex string
   */
  String shaHex(String data);

  /**
   * Calculates the SHA-1 digest and returns the value as a hex string
   * @param f file to digest
   * @return SHA-1 digest as a hex string
   */
  String createHash(File f);
}