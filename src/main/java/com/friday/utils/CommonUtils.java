package com.friday.utils;

/**
 * The Class CommonUtils.
 */
public class CommonUtils {

	/**
	 * Checks if Address starts from a digit.
	 *
	 * @param address the address
	 * @return true, if successful
	 */
	public static boolean addressStartFromDigit(String address) {
		address = address.replace(",", "");
		return Character.isDigit(address.charAt(0));
	}
	
	/**
	 * Gets the digits from the address.
	 *
	 * @param address, the address
	 * @return the digits from address
	 */
	public static String[] getDigitsFromAddress(String address){
		address = address.replace(",", "");
        return (address.replaceAll("[a-zA-Záéíóúä]","").trim().split(" "));
    }
}
