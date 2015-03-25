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
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * This class provides IO utility methods
 */
public interface IOUtils {

  /**
   * Retrieve a pseudo randomly generated UUID.
   * @return  A randomly generated UUID key
   */
  String generateKey();

  /**
   * Copy srcFile to destFile
   */
  void copyFile(File srcFile, File destFile);

  /**
   * Copy srcFile to destDir
   */
  void copyFileToDirectory(File srcFile, File destDir);

  /**
   * Copy all files in sourceDir to destDir.
   */
  void copyDirectoryContent(File sourceDir, File destDir);

  /**
   * Perform token replacement in multiple files
   * @param model the model object. Any attribute name matching a token will have its value replace the token
   * @param srcDirectory the source directory (read-only)
   * @param parseList the relative paths from the source directory
   * @param destDirectory the destination directory
   * Warning: this method should not be used anymore, as it could create issues in the workflow in case non-custom files are modified
   * Use @see mobi.designmyapp.common.IOUtils#replaceTokens(Map<String,String> model, File srcFile, File destFile) instead
   */
  @Deprecated
  void replaceTokens(Object model, Boolean exceptionHandling, File srcDirectory, List<String> parseList, File destDirectory);

  /**
   * Perform token replacement in a file
   * @param model the model object. The key being the token name, and value the String it will be replaced by
   * @param srcFile the source file (read-only)
   * @param destFile the destination file
   */
  void replaceTokens(Map<String,String> model, File srcFile, File destFile);

  /**
   * Locate for the file with fileRelativePath in directory sourceDir
   * @param sourceDir
   * @param fileRelativePath
   * @return file if found
   */
  File locateFile(File sourceDir, String fileRelativePath);

  /**
   * Compute application full name with applicationPackage.templateTag.appName
   * The appName is normalized
   * @param appName
   * @param applicationPackage
   * @param templateTag
   * @return
   */
  String computePackage(String appName, String applicationPackage, String templateTag);

  /**
   * Check whether the dir is readable
   * @param dir
   */
  void assertCanRead(String dir);

  /**
   * Check whether the dir is writeable
   * @param dir
   */
  void assertCanWrite(String dir);

  /**
   * Retrieve file extension from file name
   * @param name the name
   * @return the extension only
   */
  String getExtension(String name);

  /**
   * Retrieve file name without extension from name
   * @param name the name
   * @return the name only
   */
  String getNameWithoutExtension(String name);

  /**
   * Removes the extension from a filename
   * @param fileName  the filename to query
   * @return the filename minus the extension
   */
  String removeExtension(String fileName);

  /**
   * Cleans a directory without deleting it.
   * @param directory directory to clean
   */
  void cleanDirectory(File directory);

  /**
   * Reads the contents of a file into a String
   * @param file  the file to read
   * @return the file contents
   */
  String readFileToString(File file) throws IOException;

  /**
   * Copies bytes from an inputStream to a file
   * file. The directories up to file
   * will be created if they don't already exist.
   * will be overwritten if it already exists.
   * @param inputStream  the InputStream to copy bytes from
   * @param file  the non-directory File to write bytes to
   */
  void copyInputStreamToFile(InputStream inputStream, File file);

  /**
   * Deletes a directory recursively.
   * @param file  directory to delete
   */
  void deleteDirectory(File file);

  /**
   * Deletes a file. If file is a directory, delete it and all sub-directories.
   * @param file  file or directory to delete, must not be {@code null}
   */
  void deleteFile(File file);

  /**
   * Moves a file.
   * When the destination file is on another file system, do a "copy and delete".
   * @param srcFile the file to be moved
   * @param destFile the destination file
   */
  void moveFile(File srcFile, File destFile);

  /**
   * Create drawable reference in res/values/public.xml
   * @param imageName the name of the image
   * @param drawableId the drawable resource id (android)
   * @param tempDirectory the destination directory
   */
  void createImageReference(String imageName, int drawableId, File tempDirectory);

  /**
   * Convert Minutes to milliseconds
   * @param minutes the number of minutes
   * @return the millisecond representation of the provided minutes
   */
  long minToMillis(long minutes);

  /**
   * Prevents path hacks such as ../my/path or /opt/my/path
   * @param pathToTest the initial path
   * @return a string cleared of all eventual path hacks
   */
  String parsePath(String pathToTest);

  /**
   * Cleans destDir without deleting it and copies
   * sourceDir whole directory its location preserving the file dates
   * @param sourceDir  an existing directory to copy
   * @param destDir  the new directory
   */
  void eraseAndCopyDir(File sourceDir, File destDir);

  /**
   * Finds a resource with a given name.  The rules for searching resources
   * associated with a given class are implemented by the defining
   * ClassLoader of the class
   * @param  path name of the desired resource
   * @return      A InputStream object or null if
   *              no resource with this name is found
   */
  InputStream openClassPathResource(String path);

  /**
   * Check whether the current environment is windows based
   * @return
   */
  boolean isWindows();

  /**
   * Check whether the current environment is mac based
   * @return
   */
  boolean isMac();

}
