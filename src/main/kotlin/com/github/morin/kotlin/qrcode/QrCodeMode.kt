/*
 * Copyright 2020 Baptiste MORIN (morinb)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.morin.kotlin.qrcode

/**
 * A QR code encodes a string of text.
 * The QR code standard has four modes for encoding text: numeric, alphanumeric, byte, and Kanji.
 * Each mode encodes the text as a string of bits (1s and 0s),
 * but each mode uses a different method for converting the text into bits.
 * Each method is optimized to generate the shortest possible string of bits for that data type.
 *
 */
enum class QrCodeMode {
    /**
     * Numeric mode is for decimal digits 0 through 9.
     */
    NUMERIC,

    /**
     * Alphanumeric mode is for the decimal digits 0 through 9,
     * as well as uppercase letters (not lowercase!), and the symbols $, %, *, +, -, ., /, and : as well as a space.
     */
    ALPHANUMERIC,

    /**
     * Byte mode, by default, is for characters from the ISO-8859-1 character set.
     * However, some QR code scanners can automatically detect if UTF-8 is used in byte mode instead.
     */
    BYTE,

    /**
     * Kanji mode is for double-byte characters from the Shift JIS character set.
     * While UTF-8 can encode Kanji characters, it must use three or four bytes to do so.
     * Shift JIS, on the other hand, uses just two bytes to encode each Kanji character,
     * so Kanji mode compresses Kanji characters more efficiently.
     *
     * If the entire input string consists of characters in the double-byte range of Shift JIS, use Kanji mode.
     * It is also possible to use multiple modes within the same QR code.
     */
    KANJI,

    /**
     * Extended Channel Interpretation (ECI) mode specifies the character set (e.g. UTF-8) directly.
     * However, some QR code readers do not support ECI mode and will not understand QR codes that use it.
     */
    ECI,

    /**
     * Structured Append mode encodes data across multiple QR codes, up to a maximum of 16 QR codes.
     * I will not be discussing this mode in this tutorial but may add more information at a later time.
     */
    STRUCTURED_APPEND,

    /**
     * FNC1 mode allows the QR code to function as a GS1 barcode.
     */
    FNC1
}
