/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.resolver;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import mobi.designmyapp.common.api.model.Generation;

import java.util.Map;

/**
 * Created by Loïc Ortola on 8/4/14.
 */
public class GenerationTypeIdResolver implements TypeIdResolver {

  private JavaType mBaseType;

  private static Map<String,Class<? extends Generation>> generationMap;

  public static void setGenerationMap(Map<String,Class<? extends Generation>> map) {
    generationMap = map;
  }

  @Override
  public void init(JavaType baseType)
  {
    mBaseType = baseType;
  }

  @Override
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.NAME;
  }

  @Override
  public String idFromValue(Object obj)
  {
    return idFromValueAndType(obj, obj.getClass());
  }

  @Override
  public String idFromBaseType()
  {
    return idFromValueAndType(null, mBaseType.getRawClass());
  }

  @Override
  public String idFromValueAndType(Object obj, Class<?> clazz)
  {
    for(Map.Entry<String, Class<? extends Generation>> entry : generationMap.entrySet())
      if(entry.getValue().equals(clazz))
        return entry.getKey();
    return null;
  }

  @Override
  public JavaType typeFromId(String type)
  {
    Class<?> clazz = generationMap.get(type);
    if(clazz == null)
      for(Class cl : generationMap.values())
        if(cl.getSimpleName().equals(type))
          clazz = cl;
    if(clazz == null)
      throw new IllegalStateException("Cannot find generation object");
    return TypeFactory.defaultInstance().constructSpecializedType(mBaseType, clazz);
  }
}
