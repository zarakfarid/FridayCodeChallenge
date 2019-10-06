package com.friday.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.friday.pojo.AddressResponse;
import com.friday.processor.AddressProcessor;
import com.friday.utils.CommonUtils;

/**
 * Unit test for simple App.
 */
public class ApplicationTests {

	@Test
	public void testAddressProcessorSimpleCases_1() {
		String address_1 = "Winterallee 3";

		// assert statements
		AddressResponse result = new AddressResponse();
		result.setHouseNumber("3");
		result.setStreet("Winterallee");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_1));

	}

	@Test
	public void testAddressProcessorSimpleCases_2() {
		String address_2 = "Musterstrasse 45";

		AddressResponse result = new AddressResponse();
		result.setHouseNumber("45");
		result.setStreet("Musterstrasse");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_2));
	}

	@Test
	public void testAddressProcessorSimpleCases_3() {
		String address_3 = "Blaufeldweg 123B";

		AddressResponse result = new AddressResponse();
		result.setHouseNumber("123B");
		result.setStreet("Blaufeldweg");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_3));
	}

	@Test
	public void testAddressProcessorComplexCases_1() {
		String address_1 = "Am Bächle 23";

		// assert statements
		AddressResponse result = new AddressResponse();
		result.setHouseNumber("23");
		result.setStreet("Am Bächle");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_1));
	}

	@Test
	public void testAddressProcessorComplexCases_2() {
		String address_2 = "Auf der Vogelwiese 23 b";

		AddressResponse result = new AddressResponse();
		result.setHouseNumber("23 b");
		result.setStreet("Auf der Vogelwiese");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_2));
	}

	@Test
	public void testAddressProcessorComplexCases_3() {
		String address_3 = "Calle Aduana, 29";

		AddressResponse result = new AddressResponse();
		result.setHouseNumber("29");
		result.setStreet("Calle Aduana");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingText(address_3));
	}

	@Test
	public void testAddressProcessorComplexCases_4() {
		String address_4 = "Calle 39 No 1540";

		AddressResponse result = new AddressResponse();
		result.setHouseNumber("No 1540");
		result.setStreet("Calle 39");
		String[] numberInAddress = CommonUtils.getDigitsFromAddress(address_4);
		assertEquals(result, AddressProcessor.resolveAddressWithStartingTextAndDigits(address_4, numberInAddress));
	}

	@Test
	public void testAddressProcessorMoreComplexCases_1() {
		String address_1 = "4, rue de la revolution";

		// assert statements
		AddressResponse result = new AddressResponse();
		result.setHouseNumber("4");
		result.setStreet("rue de la revolution");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingDigits(address_1));
	}

	@Test
	public void testAddressProcessorMoreComplexCases_2() {
		String address_2 = "200 Broadway Av";

		// assert statements
		AddressResponse result = new AddressResponse();
		result.setHouseNumber("200");
		result.setStreet("Broadway Av");
		assertEquals(result, AddressProcessor.resolveAddressWithStartingDigits(address_2));
	}

}
