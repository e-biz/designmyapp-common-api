package mobi.designmyapp.common.api.utils;

import java.io.File;

/**
 * Created by Loïc Ortola on 2/5/2015.
 */
public interface DigestUtils {

  /**
   *
   * @param data
   * @return
   */
  String shaHex(String data);

  /**
   * Calculates the SHA-1 digest and returns the value as a hex string
   * @param f file to digest
   * @return SHA-1 digest as a hex string
   */
  String createHash(File f);
}