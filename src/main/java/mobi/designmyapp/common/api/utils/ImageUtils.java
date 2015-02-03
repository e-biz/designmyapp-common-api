/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/

package mobi.designmyapp.common.api.utils;

/**
 * Created by Alexandre Nunesse on 06/01/15.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public interface ImageUtils {

  void resizeImageToIcon(InputStream stream, File destFile);

  void saveAndroidIcons(File icon, File directory, String iconName);

  void saveIosIcons(File icon, File directory, String iconName);

  void saveIosSplashScreens(File ss, File directory);

  String normalizeImageName(String value);

  /**
   * Copy Android drawable resources from tmp directory to work directory
   * (drawable-ldpi to drawable-xxhdpi)
   * @param tmpDirectory
   * @param workDirectory
   */
  void copyAndroidDrawablesFromTmpToWork(File tmpDirectory, File workDirectory);

  void resizeImageForAllAndroidDensities(String imageName, File imageFile, File tmpDirectory);

  BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight);

  BufferedImage cropImage(BufferedImage originalImage, int width, int height);

  BufferedImage resizeImageSquare(BufferedImage originalImage, int size);

  BufferedImage resizeImageSquare(File originalImageFile, int size);

  BufferedImage resizeImage(File originalImageFile, int maxWidth, int maxHeight);

  void convertToPng(File srcFile, File dstFile);

  void writeBufferedImageToFile(BufferedImage image, File file);
}
