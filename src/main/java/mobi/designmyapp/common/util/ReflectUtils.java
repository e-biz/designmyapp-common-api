package mobi.designmyapp.common.util;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Loïc Ortola on 22/06/2015.
 */
public class ReflectUtils {
  /**
   * Invoke a method of an object generically.
   * @param obj the object upon method is invoked
   * @param targetClass the target class
   * @param methodName the method name
   * @param args the function arguments
   * @return the result of the invocation
   * @throws NoSuchMethodException {@link NoSuchMethodException}
   * @throws InvocationTargetException {@link InvocationTargetException}
   * @throws IllegalAccessException {@link IllegalAccessException}
   */
  public static Object invoke(Object obj, Class targetClass, String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Class[] argsClasses = new Class[args.length];
    for (int i = 0; i < args.length; i++) {
      argsClasses[i] = args[i].getClass();
    }
    return targetClass.getMethod(methodName, argsClasses).invoke(obj, args);

  }
}
