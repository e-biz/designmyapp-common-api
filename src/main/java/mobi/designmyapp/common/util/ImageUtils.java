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


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


/**
 * This class provides utility methods to manipulate images for your application
 * Created by Alexandre Nunesse on 06/01/15.
 */
public interface ImageUtils {

  /**
   * Resize image to fit icon specs.
   *
   * @param stream   the input stream of the image
   * @param destFile the destination file
   */
  void resizeImageToIcon(InputStream stream, File destFile);

  /**
   * Export to android icons (ldpi/mdpi/hdpi/xhdpi/xxhdpi/xxxhdpi).
   *
   * @param icon      the icon file
   * @param directory the destination directory
   * @param iconName  the icon name
   */
  void saveAndroidIcons(File icon, File directory, String iconName);

  /**
   * Export to ios icons (icon,icon@2x,40,40@2x,50,50@2x,60,60@2x,72,72@2x,76,76@2x,small,small@2x).
   *
   * @param icon      the icon file
   * @param directory the destination directory
   * @param iconName  the icon name
   */
  void saveIosIcons(File icon, File directory, String iconName);

  /**
   * Export to ios splashscreens.
   *
   * @param ss        the splashscreen image file
   * @param directory the destination directory
   */
  void saveIosSplashScreens(File ss, File directory);

  /**
   * Normalize image name replacing non-alphanumeric characters by "_".
   *
   * @param value image input name
   * @return normalized image name
   */
  String normalizeImageName(String value);


  /**
   * Copy Android drawable resources from tmp directory to work directory
   * (drawable-ldpi to drawable-xxhdpi).
   *
   * @param tmpDirectory  tmp input directory
   * @param workDirectory work output directory
   */
  void copyAndroidDrawablesFromTmpToWork(File tmpDirectory, File workDirectory);

  /**
   * Resize image for all densities (ldpi/mdpi/hdpi/xhdpi/xxdpi).
   *
   * @param imageName    image name
   * @param imageFile    image file
   * @param tmpDirectory tmp input directory
   */
  void resizeImageForAllAndroidDensities(String imageName, File imageFile, File tmpDirectory);

  /**
   * Resize image to desired size.
   *
   * @param originalImage the BufferedImage
   * @param maxWidth      the maximum width in px
   * @param maxHeight     the maximum height in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight);

  /**
   * Resize image to desired size.
   *
   * @param originalImageFile the File
   * @param maxWidth          the maximum width in px
   * @param maxHeight         the maximum height in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  BufferedImage resizeImage(File originalImageFile, int maxWidth, int maxHeight);

  /**
   * Crop image to desired size.
   *
   * @param originalImage the BufferedImage
   * @param width         the width in px
   * @param height        the height in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  BufferedImage cropImage(BufferedImage originalImage, int width, int height);

  /**
   * Resize image to desired square size.
   *
   * @param originalImage the BufferedImage
   * @param size          the target size in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  BufferedImage resizeImageSquare(BufferedImage originalImage, int size);

  /**
   * Resize image to desired size.
   *
   * @param originalImageFile the File
   * @param size              the target size in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  BufferedImage resizeImageSquare(File originalImageFile, int size);

  /**
   * Convert image to png.
   *
   * @param srcFile the source file
   * @param dstFile the destination png file
   */
  void convertToPng(File srcFile, File dstFile);

  /**
   * Write buffered image to file.
   *
   * @param image the image
   * @param file  the file
   */
  void writeBufferedImageToFile(BufferedImage image, File file);
}
