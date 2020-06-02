package a01164474.io;

import a01164474.ApplicationException;
import a01164474.data.Customer;
import a01164474.data.util.Validator;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Project: lab3
 * @author Nathan de Souza - A01164474
 */
public class CustomerReader {
	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";

	/**
	 * Default Constructor
	 */
	public CustomerReader() {
	}
	
	
	public static Customer[] arrayOfCustomer(String input) throws ApplicationException {
		String[] check = input.split(RECORD_DELIMITER);
		Customer[] listOfCustomers = new Customer[check.length];
		
		int i = 0;
		for (String args : check) {
			Customer customer = readCustomerString(args);
			listOfCustomers[i++] = customer;
		}

		return listOfCustomers;
	}
	
	private static Customer readCustomerString(String args) throws ApplicationException {
		
		String[] arrayOfCustomer = args.split(FIELD_DELIMITER);
		if (arrayOfCustomer.length != Customer.COUNTER_ELEMENTS) {
			throw new ApplicationException(String.format("Expected %d but got %d: %s", Customer.COUNTER_ELEMENTS, arrayOfCustomer.length, Arrays.toString(arrayOfCustomer)));
		}

		int index = 0;
		String id = arrayOfCustomer[index++];
		String firstName = arrayOfCustomer[index++];
		String lastName = arrayOfCustomer[index++];
		String street = arrayOfCustomer[index++];
		String city = arrayOfCustomer[index++];
		String postalCode = Validator.getPostalCode(arrayOfCustomer[index++]);
		String phoneNumber = Validator.getPhoneNumber(arrayOfCustomer[index++]);
		String emailAddress = Validator.getEmailAddress(arrayOfCustomer[index++]);
		LocalDate joinDate = Validator.getJoinedDate(arrayOfCustomer[index]);
		Customer customer = null;

		customer = new Customer.Builder(id, phoneNumber ).firstName(firstName).lastName(lastName).streetName(street).city(city).postalCode(postalCode)
				.email(emailAddress).setJoinDate(joinDate).build();

		return customer;
	}
}
