/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mobi.designmyapp.common.deserializer.PriceDeserializer;
import mobi.designmyapp.common.serializer.PriceSerializer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * Created by Christophe Deverre on 13/08/14.
 */
@JsonSerialize(using = PriceSerializer.class)
@JsonDeserialize(using = PriceDeserializer.class)
public class Price extends BigDecimal {

  /**
   * <p>
   * Translates a character array representation of a
   * {@code BigDecimal} into a {@code BigDecimal}, accepting the
   * same sequence of characters as the {@link #Price(String)}
   * constructor, while allowing a sub-array to be specified.
   * </p>
   * <p>Note that if the sequence of characters is already available
   * within a character array, using this constructor is faster than
   * converting the {@code char} array to string and using the
   * {@code BigDecimal(String)} constructor .
   *
   * @param in     {@code char} array that is the source of characters.
   * @param offset first character in the array to inspect.
   * @param len    number of characters to consider.
   * @throws NumberFormatException if {@code in} is not a valid
   *                               representation of a {@code BigDecimal} or the defined subarray
   *                               is not wholly within {@code in}.
   * @since 1.5
   */
  public Price(char[] in, int offset, int len) {
    super(in, offset, len);
  }

  /**
   * <p>Translates a character array representation of a
   * {@code BigDecimal} into a {@code BigDecimal}, accepting the
   * same sequence of characters as the {@link #Price(String)}
   * constructor, while allowing a sub-array to be specified and
   * with rounding according to the context settings.
   * </p>
   * <p>Note that if the sequence of characters is already available
   * within a character array, using this constructor is faster than
   * converting the {@code char} array to string and using the
   * {@code BigDecimal(String)} constructor .
   *
   * @param in     {@code char} array that is the source of characters.
   * @param offset first character in the array to inspect.
   * @param len    number of characters to consider..
   * @param mc     the context to use.
   * @throws ArithmeticException   if the result is inexact but the
   *                               rounding mode is {@code UNNECESSARY}.
   * @throws NumberFormatException if {@code in} is not a valid
   *                               representation of a {@code BigDecimal} or the defined subarray
   *                               is not wholly within {@code in}.
   * @since 1.5
   */
  public Price(char[] in, int offset, int len, MathContext mc) {
    super(in, offset, len, mc);
  }

  /**
   * <p>
   * Translates a character array representation of a
   * {@code BigDecimal} into a {@code BigDecimal}, accepting the
   * same sequence of characters as the {@link #Price(String)}
   * constructor.
   * </p>
   * <p>
   * Note that if the sequence of characters is already available
   * as a character array, using this constructor is faster than
   * converting the {@code char} array to string and using the
   * {@code BigDecimal(String)} constructor .
   *
   * @param in {@code char} array that is the source of characters.
   * @throws NumberFormatException if {@code in} is not a valid
   *                               representation of a {@code BigDecimal}.
   * @since 1.5
   */
  public Price(char[] in) {
    super(in);
  }

  /**
   * <p>
   * Translates a character array representation of a
   * {@code BigDecimal} into a {@code BigDecimal}, accepting the
   * same sequence of characters as the {@link #Price(String)}
   * constructor and with rounding according to the context
   * settings.
   * </p>
   * <p>Note that if the sequence of characters is already available
   * as a character array, using this constructor is faster than
   * converting the {@code char} array to string and using the
   * {@code BigDecimal(String)} constructor .
   *
   * @param in {@code char} array that is the source of characters.
   * @param mc the context to use.
   * @throws ArithmeticException   if the result is inexact but the
   *                               rounding mode is {@code UNNECESSARY}.
   * @throws NumberFormatException if {@code in} is not a valid
   *                               representation of a {@code BigDecimal}.
   * @since 1.5
   */
  public Price(char[] in, MathContext mc) {
    super(in, mc);
  }

  /**
   * <p>
   * Translates the string representation of a {@code BigDecimal}
   * into a {@code BigDecimal}.  The string representation consists
   * of an optional sign, {@code '+'} (<tt> '&#92;u002B'</tt>) or
   * {@code '-'} (<tt>'&#92;u002D'</tt>), followed by a sequence of
   * zero or more decimal digits ("the integer"), optionally
   * followed by a fraction, optionally followed by an exponent.
   * </p>
   * <p>The fraction consists of a decimal point followed by zero
   * or more decimal digits.  The string must contain at least one
   * digit in either the integer or the fraction.  The number formed
   * by the sign, the integer and the fraction is referred to as the
   * <i>significand</i>.
   * </p>
   * <p>The exponent consists of the character {@code 'e'}
   * (<tt>'&#92;u0065'</tt>) or {@code 'E'} (<tt>'&#92;u0045'</tt>)
   * followed by one or more decimal digits.  The value of the
   * exponent must lie between -{@link Integer#MAX_VALUE} ({@link
   * Integer#MIN_VALUE}+1) and {@link Integer#MAX_VALUE}, inclusive.
   * </p>
   * <p>More formally, the strings this constructor accepts are
   * described by the following grammar:
   * <blockquote>
   * <dl>
   * <dt><i>BigDecimalString:</i>
   * <dd><i>Sign<sub>opt</sub> Significand Exponent<sub>opt</sub></i>
   * <dt><i>Sign:</i>
   * <dd>{@code +}
   * <dd>{@code -}
   * <dt><i>Significand:</i>
   * <dd><i>IntegerPart</i> {@code .} <i>FractionPart<sub>opt</sub></i>
   * <dd>{@code .} <i>FractionPart</i>
   * <dd><i>IntegerPart</i>
   * <dt><i>IntegerPart:</i>
   * <dd><i>Digits</i>
   * <dt><i>FractionPart:</i>
   * <dd><i>Digits</i>
   * <dt><i>Exponent:</i>
   * <dd><i>ExponentIndicator SignedInteger</i>
   * <dt><i>ExponentIndicator:</i>
   * <dd>{@code e}
   * <dd>{@code E}
   * <dt><i>SignedInteger:</i>
   * <dd><i>Sign<sub>opt</sub> Digits</i>
   * <dt><i>Digits:</i>
   * <dd><i>Digit</i>
   * <dd><i>Digits Digit</i>
   * <dt><i>Digit:</i>
   * <dd>any character for which {@link Character#isDigit}
   * returns {@code true}, including 0, 1, 2 ...
   * </dl>
   * </blockquote>
   * <p>The scale of the returned {@code BigDecimal} will be the
   * number of digits in the fraction, or zero if the string
   * contains no decimal point, subject to adjustment for any
   * exponent; if the string contains an exponent, the exponent is
   * subtracted from the scale.  The value of the resulting scale
   * must lie between {@code Integer.MIN_VALUE} and
   * {@code Integer.MAX_VALUE}, inclusive.
   * </p>
   * <p>The character-to-digit mapping is provided by {@link
   * Character#digit} set to convert to radix 10.  The
   * String may not contain any extraneous characters (whitespace,
   * for example).
   * </p>
   * <p>
   * <b>Examples:</b><br>
   * The value of the returned {@code BigDecimal} is equal to
   * <i>significand</i> &times; 10<sup>&nbsp;<i>exponent</i></sup>.
   * For each string on the left, the resulting representation
   * [{@code BigInteger}, {@code scale}] is shown on the right.
   * <pre>
   * "0"            [0,0]
   * "0.00"         [0,2]
   * "123"          [123,0]
   * "-123"         [-123,0]
   * "1.23E3"       [123,-1]
   * "1.23E+3"      [123,-1]
   * "12.3E+7"      [123,-6]
   * "12.0"         [120,1]
   * "12.3"         [123,1]
   * "0.00123"      [123,5]
   * "-1.23E-12"    [-123,14]
   * "1234.5E-4"    [12345,5]
   * "0E+7"         [0,-7]
   * "-0"           [0,0]
   * </pre>
   * <p>Note: For values other than {@code float} and
   * {@code double} NaN and &plusmn;Infinity, this constructor is
   * compatible with the values returned by {@link Float#toString}
   * and {@link Double#toString}.  This is generally the preferred
   * way to convert a {@code float} or {@code double} into a
   * BigDecimal, as it doesn't suffer from the unpredictability of
   * the {@link #Price(double)} constructor.
   *
   * @param val String representation of {@code BigDecimal}.
   * @throws NumberFormatException if {@code val} is not a valid
   *                               representation of a {@code BigDecimal}.
   */
  public Price(String val) {
    super(val);
  }

  /**
   * Translates the string representation of a {@code BigDecimal}
   * into a {@code BigDecimal}, accepting the same strings as the
   * {@link #Price(String)} constructor, with rounding
   * according to the context settings.
   *
   * @param val string representation of a {@code BigDecimal}.
   * @param mc  the context to use.
   * @throws ArithmeticException   if the result is inexact but the
   *                               rounding mode is {@code UNNECESSARY}.
   * @throws NumberFormatException if {@code val} is not a valid
   *                               representation of a BigDecimal.
   * @since 1.5
   */
  public Price(String val, MathContext mc) {
    super(val, mc);
  }

  /**
   * <p>
   * Translates a {@code double} into a {@code BigDecimal} which
   * is the exact decimal representation of the {@code double}'s
   * binary floating-point value.  The scale of the returned
   * {@code BigDecimal} is the smallest value such that
   * <tt>(10<sup>scale</sup> &times; val)</tt> is an integer.
   * </p>
   * <b>Notes:</b>
   * <ol>
   * <li>
   * The results of this constructor can be somewhat unpredictable.
   * One might assume that writing {@code new BigDecimal(0.1)} in
   * Java creates a {@code BigDecimal} which is exactly equal to
   * 0.1 (an unscaled value of 1, with a scale of 1), but it is
   * actually equal to
   * 0.1000000000000000055511151231257827021181583404541015625.
   * This is because 0.1 cannot be represented exactly as a
   * {@code double} (or, for that matter, as a binary fraction of
   * any finite length).  Thus, the value that is being passed
   * <i>in</i> to the constructor is not exactly equal to 0.1,
   * appearances notwithstanding.
   * </li>
   * <li>
   * The {@code String} constructor, on the other hand, is
   * perfectly predictable: writing {@code new BigDecimal("0.1")}
   * creates a {@code BigDecimal} which is <i>exactly</i> equal to
   * 0.1, as one would expect.  Therefore, it is generally
   * recommended that the {@linkplain #Price(String)
   * <tt>String</tt> constructor} be used in preference to this one.
   * </li>
   * <li>
   * When a {@code double} must be used as a source for a
   * {@code BigDecimal}, note that this constructor provides an
   * exact conversion; it does not give the same result as
   * converting the {@code double} to a {@code String} using the
   * {@link Double#toString(double)} method and then using the
   * {@link #Price(String)} constructor.  To get that result,
   * use the {@code static} {@link #valueOf(double)} method.
   * </li>
   * </ol>
   * @param val {@code double} value to be converted to
   *            {@code BigDecimal}.
   * @throws NumberFormatException if {@code val} is infinite or NaN.
   */
  public Price(double val) {
    super(val);
  }

  /**
   * <p>
   * Translates a {@code double} into a {@code BigDecimal}, with
   * rounding according to the context settings.  The scale of the
   * {@code BigDecimal} is the smallest value such that
   * <tt>(10<sup>scale</sup> &times; val)</tt> is an integer.
   * </p>
   * <p>The results of this constructor can be somewhat unpredictable
   * and its use is generally not recommended; see the notes under
   * the {@link #Price(double)} constructor.
   *
   * @param val {@code double} value to be converted to
   *            {@code BigDecimal}.
   * @param mc  the context to use.
   * @throws ArithmeticException   if the result is inexact but the
   *                               RoundingMode is UNNECESSARY.
   * @throws NumberFormatException if {@code val} is infinite or NaN.
   * @since 1.5
   */
  public Price(double val, MathContext mc) {
    super(val, mc);
  }

  /**
   * Translates a {@code BigInteger} into a {@code BigDecimal}.
   * The scale of the {@code BigDecimal} is zero.
   *
   * @param val {@code BigInteger} value to be converted to
   *            {@code BigDecimal}.
   */
  public Price(BigInteger val) {
    super(val);
  }

  /**
   * Translates a {@code BigInteger} into a {@code BigDecimal}
   * rounding according to the context settings.  The scale of the
   * {@code BigDecimal} is zero.
   *
   * @param val {@code BigInteger} value to be converted to
   *            {@code BigDecimal}.
   * @param mc  the context to use.
   * @throws ArithmeticException if the result is inexact but the
   *                             rounding mode is {@code UNNECESSARY}.
   * @since 1.5
   */
  public Price(BigInteger val, MathContext mc) {
    super(val, mc);
  }

  /**
   * Translates a {@code BigInteger} unscaled value and an
   * {@code int} scale into a {@code BigDecimal}.  The value of
   * the {@code BigDecimal} is
   * <tt>(unscaledVal &times; 10<sup>-scale</sup>)</tt>.
   *
   * @param unscaledVal unscaled value of the {@code BigDecimal}.
   * @param scale       scale of the {@code BigDecimal}.
   */
  public Price(BigInteger unscaledVal, int scale) {
    super(unscaledVal, scale);
  }

  /**
   * Translates a {@code BigInteger} unscaled value and an
   * {@code int} scale into a {@code BigDecimal}, with rounding
   * according to the context settings.  The value of the
   * {@code BigDecimal} is <tt>(unscaledVal &times;
   * 10<sup>-scale</sup>)</tt>, rounded according to the
   * {@code precision} and rounding mode settings.
   *
   * @param unscaledVal unscaled value of the {@code BigDecimal}.
   * @param scale       scale of the {@code BigDecimal}.
   * @param mc          the context to use.
   * @throws ArithmeticException if the result is inexact but the
   *                             rounding mode is {@code UNNECESSARY}.
   * @since 1.5
   */
  public Price(BigInteger unscaledVal, int scale, MathContext mc) {
    super(unscaledVal, scale, mc);
  }

  /**
   * Translates an {@code int} into a {@code BigDecimal}.  The
   * scale of the {@code BigDecimal} is zero.
   *
   * @param val {@code int} value to be converted to
   *            {@code BigDecimal}.
   * @since 1.5
   */
  public Price(int val) {
    super(val);
  }

  /**
   * Translates an {@code int} into a {@code BigDecimal}, with
   * rounding according to the context settings.  The scale of the
   * {@code BigDecimal}, before any rounding, is zero.
   *
   * @param val {@code int} value to be converted to {@code BigDecimal}.
   * @param mc  the context to use.
   * @throws ArithmeticException if the result is inexact but the
   *                             rounding mode is {@code UNNECESSARY}.
   * @since 1.5
   */
  public Price(int val, MathContext mc) {
    super(val, mc);
  }

  /**
   * Translates a {@code long} into a {@code BigDecimal}.  The
   * scale of the {@code BigDecimal} is zero.
   *
   * @param val {@code long} value to be converted to {@code BigDecimal}.
   * @since 1.5
   */
  public Price(long val) {
    super(val);
  }

  /**
   * Translates a {@code long} into a {@code BigDecimal}, with
   * rounding according to the context settings.  The scale of the
   * {@code BigDecimal}, before any rounding, is zero.
   *
   * @param val {@code long} value to be converted to {@code BigDecimal}.
   * @param mc  the context to use.
   * @throws ArithmeticException if the result is inexact but the
   *                             rounding mode is {@code UNNECESSARY}.
   * @since 1.5
   */
  public Price(long val, MathContext mc) {
    super(val, mc);
  }

  public Price(BigDecimal bigDecimal) {
    super(bigDecimal.toString());
  }

  public static final Price ONE = new Price(BigDecimal.ONE);

  public static final Price TEN = new Price(BigDecimal.TEN);

  public static final Price ZERO = new Price(BigDecimal.ZERO);

  /**
   * Returns a {@code BigDecimal} whose value is {@code (this +
   * augend)}, and whose scale is {@code max(this.scale(),
   * augend.scale())}.
   *
   * @param augend value to be added to this {@code BigDecimal}.
   * @return {@code this + augend}
   */
  @Override
  public Price add(BigDecimal augend) {
    return new Price(super.add(augend));
  }

  /**
   * Returns a {@code BigDecimal} whose value is <tt>(this &times;
   * multiplicand)</tt>, and whose scale is {@code (this.scale() +
   * multiplicand.scale())}.
   *
   * @param multiplicand value to be multiplied by this {@code BigDecimal}.
   * @return {@code this * multiplicand}
   */
  @Override
  public Price multiply(BigDecimal multiplicand) {
    return new Price(super.multiply(multiplicand));
  }

  /**
   * Returns a {@code BigDecimal} whose value is {@code (this -
   * subtrahend)}, and whose scale is {@code max(this.scale(),
   * subtrahend.scale())}.
   *
   * @param subtrahend value to be subtracted from this {@code BigDecimal}.
   * @return {@code this - subtrahend}
   */
  @Override
  public Price subtract(BigDecimal subtrahend) {
    return new Price(super.subtract(subtrahend));
  }

  /**
   * Returns a {@code BigDecimal} whose value is {@code (this /
   * divisor)}, and whose preferred scale is {@code (this.scale() -
   * divisor.scale())}; if the exact quotient cannot be
   * represented (because it has a non-terminating decimal
   * expansion) an {@code ArithmeticException} is thrown.
   *
   * @param divisor value by which this {@code BigDecimal} is to be divided.
   * @return {@code this / divisor}
   * @throws ArithmeticException if the exact quotient does not have a
   *                             terminating decimal expansion
   * @author Joseph D. Darcy
   * @since 1.5
   */
  @Override
  public Price divide(BigDecimal divisor) {
    return new Price(super.divide(divisor));
  }

  /**
   * Returns a {@code BigDecimal} whose value is the absolute value
   * of this {@code BigDecimal}, and whose scale is
   * {@code this.scale()}.
   *
   * @return {@code abs(this)}
   */
  @Override
  public Price abs() {
    return new Price(super.abs());
  }

  /**
   * Returns a {@code BigDecimal} whose value is {@code (-this)},
   * and whose scale is {@code this.scale()}.
   *
   * @return {@code -this}.
   */
  @Override
  public Price negate() {
    return new Price(super.negate());
  }

  /**
   * <p>
   * Returns a {@code BigDecimal} whose value is {@code (+this)}, and whose
   * scale is {@code this.scale()}.
   * </p>
   * <p>
   * This method, which simply returns this {@code BigDecimal}
   * is included for symmetry with the unary minus method {@link
   * #negate()}.
   *
   * @return {@code this}.
   * @see #negate()
   * @since 1.5
   */
  @Override
  public Price plus() {
    return new Price(super.plus());
  }

  /**
   * Returns the minimum of this {@code BigDecimal} and
   * {@code val}.
   *
   * @param val value with which the minimum is to be computed.
   * @return the {@code BigDecimal} whose value is the lesser of this
   * {@code BigDecimal} and {@code val}.  If they are equal,
   * as defined by the {@link #compareTo(java.math.BigDecimal) compareTo}
   * method, {@code this} is returned.
   * @see #compareTo(java.math.BigDecimal)
   */
  @Override
  public Price min(BigDecimal val) {
    return new Price(super.min(val));
  }

  /**
   * Returns the maximum of this {@code BigDecimal} and {@code val}.
   *
   * @param val value with which the maximum is to be computed.
   * @return the {@code BigDecimal} whose value is the greater of this
   * {@code BigDecimal} and {@code val}.  If they are equal,
   * as defined by the {@link #compareTo(java.math.BigDecimal) compareTo}
   * method, {@code this} is returned.
   * @see #compareTo(java.math.BigDecimal)
   */
  @Override
  public Price max(BigDecimal val) {
    return new Price(super.max(val));
  }
}
