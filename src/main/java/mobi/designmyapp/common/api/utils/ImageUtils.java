/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/

package mobi.designmyapp.common.api.utils;

/**
 * Created by Alexandre Nunesse on 1/6/15.
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

  @Deprecated
  void resizeImageForAllAndroidDensities(String imageName, File imageFile, File tmpDirectory, boolean force);

  void resizeImageForAllAndroidDensities(String imageName, File imageFile, File tmpDirectory);

  BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight);

  BufferedImage cropImage(BufferedImage originalImage, int width, int height);

  BufferedImage resizeImageSquare(BufferedImage originalImage, int size);

  BufferedImage resizeImageSquare(File originalImageFile, int size);

  BufferedImage resizeImage(File originalImageFile, int maxWidth, int maxHeight);

  void convertToPng(File srcFile, File dstFile);

  void writeBufferedImageToFile(BufferedImage image, File file);
}
