package com.friday;

import com.friday.pojo.AddressResponse;
import com.friday.processor.AddressProcessor;
import com.friday.utils.CommonUtils;
import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * @author Syed Zarak Farid
 */
public class Application {

	/** The Constant gson. */
	private static final Gson gson = new Gson();

	/**
	 * The main method.
	 *
	 * @param args the input string
	 */
	public static void main(String[] args) {

		AddressResponse addressResponse = null;

		if (args.length > 0) {
			String address = args[0];

			// There are 4 cases fundamentally
			// 1. Address starting from digits
			// 2. Address starting from digits with text in the middle
			// 3. Address starting from text
			// 4. Address starting from text with digits in the middle
			if (address != null && !address.isEmpty()) {

				// 1. Address starting from digits
				// 2. Address starting from digits with digits in the middle
				if (CommonUtils.addressStartFromDigit(address)) {
					addressResponse = AddressProcessor.resolveAddressWithStartingDigits(address);
				} else {
					// 4. Address starting from text with digits in the middle
					String[] numberInAddress = CommonUtils.getDigitsFromAddress(address);
					if (numberInAddress.length > 1) {
						addressResponse = AddressProcessor.resolveAddressWithStartingTextAndDigits(address,
								numberInAddress);
					} else {
						// 3. Address starting from text
						addressResponse = AddressProcessor.resolveAddressWithStartingText(address);
					}
				}

				System.out.println(gson.toJson(addressResponse));
			}
		} else {
			System.out.println("Please input a valid address");
		}

	}
}
