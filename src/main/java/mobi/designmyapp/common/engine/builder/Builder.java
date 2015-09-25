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
package mobi.designmyapp.common.engine.builder;


import mobi.designmyapp.common.engine.model.Template;
/**
 * Generic builder interface to build a specific template,
 * the interface provides a type.
 * Created by Loïc Ortola on 7/7/14.
 */
public interface Builder<T extends Template> {
  /**
   * Build a template.
   * @param template the template
   */
  void build(T template);

  /**
   * Get the type of the application (android,ios,container).
   * @return the application type.
   */
  Type getType();

  public static enum Type {
    ANDROID, IOS, CONTAINER
  }

}
