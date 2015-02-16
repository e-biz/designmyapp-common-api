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

  private static final String FILE_MANAGEMENT_UTILS = "mobi.designmyapp.common.utils.FileManagementUtilsImpl";
  private static final String IMAGE_UTILS = "mobi.designmyapp.common.utils.ImageUtilsImpl";
  private static final String PRICE_UTILS = "mobi.designmyapp.common.utils.PriceUtilsImpl";
  private static final String RESOURCE_UTILS = "mobi.designmyapp.common.utils.ResourceUtilsImpl";
  private static final String STORAGE_UTILS = "mobi.designmyapp.common.utils.StorageUtilsImpl";
  private static final String ZIP_UTILS = "mobi.designmyapp.common.utils.ZipUtilsImpl";
  private static final String DIGEST_UTILS = "mobi.designmyapp.common.utils.DigestUtilsImpl";

  private static final String RESOURCE_SERVICE = "mobi.designmyapp.engine.service.ResourceServiceImpl";
  private static final String PRICING_SERVICE = "mobi.designmyapp.engine.service.PricingServiceImpl";

  private static FileManagementUtils fileManagementUtils;
  private static ImageUtils imageUtils;
  private static PriceUtils priceUtils;
  private static ResourceUtils resourceUtils;
  private static StorageUtils storageUtils;
  private static ZipUtils zipUtils;
  private static DigestUtils digestUtils;

  private static ResourceService resourceService;
  private static PricingService pricingService;

  private UtilsFactory() {

  }

  public static FileManagementUtils getFileManagementUtils() {
    if (fileManagementUtils == null) {
      try {
        Class clazz = Class.forName(FILE_MANAGEMENT_UTILS);
        fileManagementUtils = (FileManagementUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return fileManagementUtils;
  }

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

  public static StorageUtils getStorageUtils() {
    if (storageUtils == null) {
      try {
        Class clazz = Class.forName(STORAGE_UTILS);
        storageUtils = (StorageUtils) clazz.newInstance();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.warn("Cannot instanciate util: {}", e.getMessage());
        throw new IllegalStateException(e);
      }
    }
    return storageUtils;
  }

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
