/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.utils;


import freemarker.template.Configuration;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;


public interface IFileManagementUtils {

  public String generateKey();

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
   * Escapes single and double quotes
   */
  String escapeQuotes(String s);

  /**
   * Perform token replacement in multiple files
   * @param model the model object. Any attribute name matching a token will have its value replace the token
   * @param srcDirectory the source directory (read-only)
   * @param parseList the relative paths from the source directory
   * @param destDirectory the destination directory
   */
  void replaceTokens(Object model, File srcDirectory, List<String> parseList, File destDirectory);

  /**
   * Parse all the given files with the given freemarker configuration and copy them
   */
  void parseAndCopyAll(Configuration configuration, Object model, File sourceDirectory, List<String> filesToBeParsedRelativePath, File targetDirectory);

  File locateFile(File sourceDir, String fileRelativePath);

  String computePackage(String appName, String applicationPackage, String templateTag);

  void copyDataFromTmpToWork(File tmp, File work);

  void copySourceFromTmpToWork(File tmp, File work);

  void assertCanRead(String dir);

  void assertCanWrite(String dir);

  String getExtension(String name);

  String getNameWithoutExtension(String name);

  void copyAndroidDrawablesFromTmpToWork(File tmpDirectory, File workDirectory);

  void moveImagesFromTmpToAssetsPictures(String tmpPath, String workPath);

  void cleanDirectory(File directory);

  String readFileToString(File file) throws IOException;

  void copyInputStreamToFile(InputStream inputStream, File file);

  void deleteDirectory(File file);

  void deleteFile(File file);

  void moveFile(File srcFile, File destFile);

  BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight);

  void writeBufferedImageToFile(BufferedImage image, File file);

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
   * Checks whether an URL is an image or not
   * @param value the URL
   * @return true if the URL is an image, false otherwise
   */
  boolean isImageUrl(String value);

  /**
   * Checks whether a string is a JsonPath or not
   * @param value the string to test
   * @return true if the string is a JsonPath, false otherwise
   */
  boolean isJsonPath(String value);

  /**
   * Prevents path hacks such as ../my/path or /opt/my/path
   * @param pathToTest the initial path
   * @return a string cleared of all eventual path hacks
   */
  String parsePath(String pathToTest);

  /**
   * Valid a filename, must be alpha numeric, and accept - and _ too.
   *
   * @param fileName the name of the file
   * @return true if the name is valid, false otherwise
   */
  boolean isValidFileName(String fileName);

  void eraseAndCopyDir(File sourceDir, File destDir);

  boolean isEmail(String value);

  boolean isValidPhoneNumber(String value);

  boolean noHtmlText(String value);

  String stringListBuilder(List<String> items, String start, String separator, String end);

  String createHash(File f);

  InputStream openClassPathResource(String path);

  String removeExtension(String fileName);
}
