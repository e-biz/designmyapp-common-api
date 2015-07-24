package mobi.designmyapp.common.engine.service.provider;

/**
 * Created by Loïc Ortola on 22/06/2015.
 * Used to provide the SDK services
 */
public interface ServiceProvider {

  /**
   * Get sdk service.
   * @param clazz the class
   * @param <T> the object
   * @return the object
   */
  <T> T getService(Class clazz);
}
