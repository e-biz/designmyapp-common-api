/*
 Copyright © 2014 by eBusiness Information
 All rights reserved. This source code or any portion thereof
 may not be reproduced or used in any manner whatsoever
 without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.utils;

import mobi.designmyapp.common.api.service.PricingService;
import mobi.designmyapp.common.api.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alexandre Nunesse on 1/6/15.
 */
public class UtilsFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilsFactory.class);

  private static final String FILE_MANAGEMENT_UTILS = "mobi.designmyapp.common.utils.FileManagementUtils";
  private static final String IMAGE_UTILS = "mobi.designmyapp.common.utils.ImageUtils";
  private static final String PRICE_UTILS = "mobi.designmyapp.common.utils.PriceUtils";
  private static final String RESOURCE_UTILS = "mobi.designmyapp.common.utils.ResourceUtils";
  private static final String STORAGE_UTILS = "mobi.designmyapp.common.utils.StorageUtils";
  private static final String ZIP_UTILS = "mobi.designmyapp.common.utils.ZipUtils";
  private static final String DIGEST_UTILS = "mobi.designmyapp.common.utils.DigestUtils";

  private static final String RESOURCE_SERVICE = "mobi.designmyapp.engine.service.ResourceServiceImpl";
  private static final String PRICING_SERVICE = "mobi.designmyapp.engine.service.PricingServiceImpl";

  private static IFileManagementUtils fileManagementUtils;
  private static IImageUtils imageUtils;
  private static IPriceUtils priceUtils;
  private static IResourceUtils resourceUtils;
  private static IStorageUtils storageUtils;
  private static IZipUtils zipUtils;
  private static IDigestUtils digestUtils;

  private static ResourceService resourceService;
  private static PricingService pricingService;

  private UtilsFactory() {

  }

  public static IFileManagementUtils getFileManagementUtils() {
    if (fileManagementUtils == null) {
      try {
        Class clazz = Class.forName(FILE_MANAGEMENT_UTILS);
        fileManagementUtils = (IFileManagementUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return fileManagementUtils;
  }

  public static IImageUtils getImageUtils() {
    if (imageUtils == null) {
      try {
        Class clazz = Class.forName(IMAGE_UTILS);
        imageUtils = (IImageUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return imageUtils;
  }

  public static IPriceUtils getPriceUtils() {
    if (priceUtils == null) {
      try {
        Class clazz = Class.forName(PRICE_UTILS);
        priceUtils = (IPriceUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return priceUtils;
  }

  public static IResourceUtils getResourceUtils() {
    if (resourceUtils == null) {
      try {
        Class clazz = Class.forName(RESOURCE_UTILS);
        resourceUtils = (IResourceUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return resourceUtils;
  }

  public static IStorageUtils getStorageUtils() {
    if (storageUtils == null) {
      try {
        Class clazz = Class.forName(STORAGE_UTILS);
        storageUtils = (IStorageUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return storageUtils;
  }

  public static IZipUtils getZipUtils() {
    if (zipUtils == null) {
      try {
        Class clazz = Class.forName(ZIP_UTILS);
        zipUtils = (IZipUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}",e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return zipUtils;
  }

  public static IDigestUtils getDigestUtils() {
    if (digestUtils == null) {
      try {
        Class clazz = Class.forName(DIGEST_UTILS);
        digestUtils = (IDigestUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return digestUtils;
  }

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
