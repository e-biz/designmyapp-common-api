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

import mobi.designmyapp.common.engine.service.ContextService;
import mobi.designmyapp.common.engine.service.PricingService;
import mobi.designmyapp.common.engine.service.provider.ServiceProvider;
import mobi.designmyapp.common.instance.service.InstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Factory to retrieve Utility and Service classes
 * Created by Alexandre Nunesse on 06/01/15.
 */
public class UtilsFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilsFactory.class);

  private static final String IO_UTILS = "mobi.designmyapp.common.util.impl.IOUtilsImpl";
  private static final String IMAGE_UTILS = "mobi.designmyapp.common.util.impl.ImageUtilsImpl";
  private static final String PRICE_UTILS = "mobi.designmyapp.common.util.impl.PriceUtilsImpl";
  private static final String ZIP_UTILS = "mobi.designmyapp.common.util.impl.ZipUtilsImpl";
  private static final String DIGEST_UTILS = "mobi.designmyapp.common.util.impl.DigestUtilsImpl";
  private static final String STRING_UTILS = "mobi.designmyapp.common.util.impl.StringUtilsImpl";

  private static IOUtils ioUtils;
  private static ImageUtils imageUtils;
  private static PriceUtils priceUtils;
  private static ZipUtils zipUtils;
  private static DigestUtils digestUtils;
  private static StringUtils stringUtils;

  private static ServiceProvider serviceProvider;
  private static ServiceProvider serviceProviderProxy;

  static {

    InvocationHandler serviceProviderHandler = (proxy, method, args) -> {

      if (serviceProvider != null) {
        return ReflectUtils.invoke(serviceProvider, ServiceProvider.class, method.getName(), args);
      } else {
        // The first and only argument of the sole serviceProviderMethod is a class
        Class returnclazz = (Class) args[0];
        return Proxy.newProxyInstance(returnclazz.getClassLoader(), new Class[]{returnclazz}, new ServiceInvocationHandler());
      }

    };
    serviceProviderProxy = (ServiceProvider) Proxy.newProxyInstance(ServiceProvider.class.getClassLoader(), new Class[]{ServiceProvider.class}, serviceProviderHandler);
  }

  public static class ServiceInvocationHandler implements InvocationHandler {

    private Object instance;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Class clazz = proxy.getClass();
      if (instance == null) {
        instance = serviceProvider.getService(clazz);
      }
      return instance == null ? null : ReflectUtils.invoke(instance, clazz, method.getName(), args);
    }
  }

  private UtilsFactory() {
  }

  /**
   * This is called by the engine system to set the service provider
   * @param provider the service provider
   */
  public static void setServiceProvider(ServiceProvider provider) {
    serviceProvider = provider;
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
   * Retrieve ContextService implementation
   * @return ContextService instance
   */
  public static ContextService getContextService() {
    return serviceProviderProxy.getService(ContextService.class);
  }

  /**
   * Retrieve PricingService implementation
   * @return PricingService instance
   */
  public static PricingService getPricingService() {
    return serviceProviderProxy.getService(PricingService.class);
  }

  /**
   * Retrieve InstanceService implementation
   * @return InstanceService instance
   */
  public static InstanceService getInstanceService() {
    return serviceProviderProxy.getService(InstanceService.class);
  }
}
