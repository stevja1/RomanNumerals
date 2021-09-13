package com.adobe.interviews.servicetest.RomanNumerals.services;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsService {
    private static final Map<String,String> numeralMap = new HashMap<>();

    /**
     * Initialize a lookup table containing the major Roman numerals for different orders of magnitude
     */
    private static void initializeMap() {
        if(numeralMap.size() == 0) {
            numeralMap.put("1.0", "");
            numeralMap.put("1.1", "I");
            numeralMap.put("1.2", "II");
            numeralMap.put("1.3", "III");
            numeralMap.put("1.4", "IV");
            numeralMap.put("1.5", "V");
            numeralMap.put("1.6", "VI");
            numeralMap.put("1.7", "VII");
            numeralMap.put("1.8", "VIII");
            numeralMap.put("1.9", "IX");
            numeralMap.put("2.1", "X");
            numeralMap.put("2.2", "XX");
            numeralMap.put("2.3", "XXX");
            numeralMap.put("2.4", "XL");
            numeralMap.put("2.5", "L");
            numeralMap.put("2.6", "LX");
            numeralMap.put("2.7", "LXX");
            numeralMap.put("2.8", "LXXX");
            numeralMap.put("2.9", "XC");
            numeralMap.put("3.1", "C");
            numeralMap.put("3.2", "CC");
            numeralMap.put("3.3", "CCC");
            numeralMap.put("3.4", "CD");
            numeralMap.put("3.5", "D");
            numeralMap.put("3.6", "DC");
            numeralMap.put("3.7", "DCC");
            numeralMap.put("3.8", "DCCC");
            numeralMap.put("3.9", "CM");
            numeralMap.put("4.1", "M");
            numeralMap.put("4.2", "MM");
            numeralMap.put("4.3", "MMM");
        }
    }

    /**
     * Returns a matching Roman numeral for a provided index value. If a matching value isn't
     * found, null is returned.
     * @param index The index to search for. Formatted like this: "1.1" -> "I". See map in this
     *              class for more details.
     * @return String|null Null on match failure. String containing value on success.
     */
    private static String getMapValue(String index) {
        initializeMap();
        return numeralMap.get(index);
    }

    /**
     * Convert a decimal to Roman numeral. Can be used for numbers above zero and below 3999.
     * @param number The number to convert
     * @return The Roman numeral representation of the number
     * @throws ArithmeticException Thrown if the number provided is below 1 or greater than 3999
     * @throws StringIndexOutOfBoundsException Thrown if internally, a map index is generated that doesn't match any
     * in the pre-defined list in this class.
     */
    public static String convertNumber(int number) throws ArithmeticException {
        if(number < 1 || number > 3999) {
            throw new ArithmeticException("Number "+number+" isn't supported. Number must be above 0 and below 4000.");
        }

        int digit;
        int index = 1;
        String numeral = "";
        String mapIndex;
        while(number > 0) {
            // Isolate the right-most digit
            digit = number % 10;
            // Remove the right-most digit from the number for the next loop
            number = (int)Math.floor(number / 10);
            // Find the appropriate Roman numeral for this digit
            mapIndex = String.format("%d.%d", index, digit);
            numeral = getMapValue(mapIndex) + numeral;
            if(numeral == null) {
                throw new StringIndexOutOfBoundsException("No entry found for index: "+mapIndex);
            }
            ++index;
        }
        return numeral;
    }
}
