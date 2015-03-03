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

import mobi.designmyapp.common.engine.service.PricingService;
import mobi.designmyapp.common.engine.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory to retrieve Utility and Service classes
 * Created by Alexandre Nunesse on 06/01/15.
 */
public class UtilsFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilsFactory.class);

  private static final String IO_UTILS = "mobi.designmyapp.common.util.IOUtilsImpl";
  private static final String IMAGE_UTILS = "mobi.designmyapp.common.util.ImageUtilsImpl";
  private static final String PRICE_UTILS = "mobi.designmyapp.common.util.PriceUtilsImpl";
  private static final String RESOURCE_UTILS = "mobi.designmyapp.common.util.ResourceUtilsImpl";
  private static final String ZIP_UTILS = "mobi.designmyapp.common.util.ZipUtilsImpl";
  private static final String DIGEST_UTILS = "mobi.designmyapp.common.util.DigestUtilsImpl";
  private static final String STRING_UTILS = "mobi.designmyapp.common.util.StringUtilsImpl";

  private static final String RESOURCE_SERVICE = "mobi.designmyapp.engine.service.ResourceServiceImpl";
  private static final String PRICING_SERVICE = "mobi.designmyapp.engine.service.PricingServiceImpl";

  private static IOUtils ioUtils;
  private static ImageUtils imageUtils;
  private static PriceUtils priceUtils;
  private static ResourceUtils resourceUtils;
  private static ZipUtils zipUtils;
  private static DigestUtils digestUtils;
  private static StringUtils stringUtils;

  private static ResourceService resourceService;
  private static PricingService pricingService;

  private UtilsFactory() {

  }

  /**
   * Retrieve IOUtils implementation
   * @return IOUtils instance
   */
  public static IOUtils getIOUtils() {
    if (ioUtils == null) {
      try {
        Class clazz = Class.forName(IO_UTILS);
        ioUtils = (IOUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return ioUtils;
  }

  /**
   * Retrieve ImageUtils implementation
   * @return ImageUtils instance
   */
  public static ImageUtils getImageUtils() {
    if (imageUtils == null) {
      try {
        Class clazz = Class.forName(IMAGE_UTILS);
        imageUtils = (ImageUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return imageUtils;
  }

  /**
   * Retrieve PriceUtils implementation
   * @return PriceUtils instance
   */
  public static PriceUtils getPriceUtils() {
    if (priceUtils == null) {
      try {
        Class clazz = Class.forName(PRICE_UTILS);
        priceUtils = (PriceUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return priceUtils;
  }

  /**
   * Retrieve ResourceUtils implementation
   * @return ResourceUtils instance
   */
  public static ResourceUtils getResourceUtils() {
    if (resourceUtils == null) {
      try {
        Class clazz = Class.forName(RESOURCE_UTILS);
        resourceUtils = (ResourceUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return resourceUtils;
  }

  /**
   * Retrieve ZipUtils implementation
   * @return ZipUtils instance
   */
  public static ZipUtils getZipUtils() {
    if (zipUtils == null) {
      try {
        Class clazz = Class.forName(ZIP_UTILS);
        zipUtils = (ZipUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}",e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return zipUtils;
  }

  /**
   * Retrieve DigestUtils implementation
   * @return DigestUtils instance
   */
  public static DigestUtils getDigestUtils() {
    if (digestUtils == null) {
      try {
        Class clazz = Class.forName(DIGEST_UTILS);
        digestUtils = (DigestUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return digestUtils;
  }

  /**
   * Retrieve StringUtils implementation
   * @return StringUtils instance
   */
  public static StringUtils getStringUtils() {
    if (stringUtils == null) {
      try {
        Class clazz = Class.forName(STRING_UTILS);
        stringUtils = (StringUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return stringUtils;
  }

  /**
   * Retrieve ResourceService implementation
   * @return ResourceService instance
   */
  public static ResourceService getResourceService() {
    if (resourceService == null) {
      try {
        Class clazz = Class.forName(RESOURCE_SERVICE);
        resourceService = (ResourceService) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return resourceService;
  }

  /**
   * Retrieve PricingService implementation
   * @return PricingService instance
   */
  public static PricingService getPricingService() {
    if (pricingService == null) {
      try {
        Class clazz = Class.forName(PRICING_SERVICE);
        pricingService = (PricingService) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return pricingService;
  }
}
