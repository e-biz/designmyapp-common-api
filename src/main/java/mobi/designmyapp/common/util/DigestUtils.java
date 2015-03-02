package mobi.designmyapp.common.util;

import java.io.File;

/**
 * Created by Loïc Ortola on 05/02/15.
 */
public interface DigestUtils {

  /**
   * Calculates the SHA-1 digest and returns the value as a hex string
   * @param data Data to digest
   * @return SHA-1 digest as a hex string
   */
  String shaHex(String data);

  /**
   * Calculates the SHA-1 digest and returns the value as a hex string
   * @param f file to digest
   * @return SHA-1 digest as a hex string
   */
  String createHash(File f);
}