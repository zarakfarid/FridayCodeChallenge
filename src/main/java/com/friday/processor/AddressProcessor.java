package com.friday.processor;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.friday.constants.AddressProviderConstants;
import com.friday.pojo.AddressResponse;
import com.friday.utils.CommonUtils;
import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * AddressProcessor
 */
public class AddressProcessor {

	/**
	 * Resolve address with starting digits.
	 *
	 * @param address, the address to resolve
	 * @return the address response
	 */
	public static AddressResponse resolveAddressWithStartingDigits(String address) {
		AddressResponse addressResponse = null;

		address = address.replace(",", "");
		Pattern pattern = Pattern.compile(AddressProviderConstants.ADDRESS_REGEX_START_DIGIT);
		Matcher matcher = pattern.matcher(address);
		if (matcher.matches()) {
			addressResponse = new AddressResponse();
			addressResponse.setHouseNumber(matcher.group(1).trim());
			addressResponse.setStreet(matcher.group(2));
		}
		return addressResponse;
	}

	/**
	 * Resolve address with starting text.
	 *
	 * @param address, the address to resolve
	 * @return the address response
	 */
	public static AddressResponse resolveAddressWithStartingText(String address) {
		AddressResponse addressResponse = null;

		address = address.replace(",", "");
		Pattern pattern = Pattern.compile(AddressProviderConstants.ADDRESS_REGEX_START_TEXT);
		Matcher matcher = pattern.matcher(address);
		if (matcher.matches()) {
			addressResponse = new AddressResponse();
			addressResponse.setStreet(matcher.group(1).trim());
			addressResponse.setHouseNumber(matcher.group(2));
		}
		return addressResponse;
	}

	/**
	 * Resolve address with starting text and digits.
	 *
	 * @param address, the address to resolve
	 * @param numberInAddress, the numbers in the address
	 * @return the address response
	 */
	public static AddressResponse resolveAddressWithStartingTextAndDigits(String address, String[] numberInAddress) {
		AddressResponse addressResponse = null;
		
		address = address.replace(",", "");
		String number = numberInAddress[0];
		int numberStartPos = address.indexOf(number) + number.length();
		
		addressResponse = new AddressResponse();
		addressResponse.setStreet(address.substring(0, numberStartPos).trim());
		addressResponse.setHouseNumber(address.substring(numberStartPos).trim());
		return addressResponse;
	}
}
