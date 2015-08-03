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

import java.io.Serializable;
import java.util.List;

/**
 * This class provides utility methods for String management
 * Created by Alexandre Nunesse on 16/02/15.
 */
public interface StringUtils {

  /**
   * Escapes single and double quotes.
   *
   * @param s input String
   * @return escaped String
   */
  String escapeQuotes(String s);

  /**
   * Checks whether a string is a JsonPath or not.
   *
   * @param value the string to test
   * @return true if the string is a JsonPath, false otherwise
   */
  boolean isJsonPath(String value);

  /**
   * Checks whether a string is an email or not.
   *
   * @param value the string to test
   * @return true if the string is an email
   */
  boolean isEmail(String value);

  /**
   * Valid a filename, must be alpha numeric, and accept - and _ too.
   *
   * @param fileName the name of the file
   * @return true if the name is valid, false otherwise
   */
  boolean isValidFileName(String fileName);

  /**
   * Transform a list of string into a single string.
   *
   * @param items     the list of strings
   * @param start     the starting string
   * @param separator the separator
   * @param end       the ending string
   * @return the concatenated string
   */
  String stringListBuilder(List<String> items, String start, String separator, String end);

  /**
   * Check whether a string is a phone number or not.
   *
   * @param value the string to test
   * @return true if the string is valid, false otherwise
   */
  boolean isValidPhoneNumber(String value);

  /**
   * Check whether a string contains html tags.
   *
   * @param value the string to test
   * @return true if the value is valid, false otherwise
   */
  boolean noHtmlText(String value);

  /**
   * Checks whether an URL is an image or not.
   *
   * @param value the URL
   * @return true if the URL is an image, false otherwise
   */
  boolean isImageUrl(String value);

  /**
   * Strips all special and invalid characters to format as a real name.
   *
   * @param name the input name.
   * @return the normalized name.
   */
  String normalizeName(String name);

  /**
   * Method to transform an object into a Base64 String.
   *
   * @param object the object to transform
   * @return the encoded string of the object
   */
  String encodeBase64(Serializable object);
}
