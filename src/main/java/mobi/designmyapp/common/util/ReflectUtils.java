package mobi.designmyapp.common.util;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by loic on 22/06/2015.
 */
public class ReflectUtils {

  public static Object invoke(Object obj, Class targetClass, String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Class[] argsClasses = new Class[args.length];
    for (int i = 0; i < args.length; i++) {
      argsClasses[i] = args[i].getClass();
    }
    return targetClass.getMethod(methodName, argsClasses).invoke(obj, args);

  }
}
