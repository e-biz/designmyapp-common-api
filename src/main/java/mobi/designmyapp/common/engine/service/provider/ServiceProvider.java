package mobi.designmyapp.common.engine.service.provider;

/**
 * Created by Loïc Ortola on 22/06/2015.
 * Used to provide the SDK services
 */
public interface ServiceProvider {


  <T> T getService(Class clazz);
}
