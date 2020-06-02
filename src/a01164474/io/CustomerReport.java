package a01164474.io;

import java.time.LocalDate;

import a01164474.data.Customer;
import a01164474.data.util.Validator;

/**
 * Project: lab3
 * @author Nathan de Souza - A01164474
 */
public class CustomerReport {

	public static final String HORIZONTAL_LINE = "------------------------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-15s %-15s %-25s %-15s %-15s %-15s %-26s%s%n";
	public static final String CUSTOMER_FORMAT = "%3d. %-6s %-15s %-15s %-25s %-15s %-15s %-15s %-26s%s%n";

	
	private CustomerReport() {
		
	}

	
	public static void write(Customer[] customers) {
		System.out.println();
		System.out.println("Customers Report");
		System.out.println();
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone", "Email", "Join Date");
		System.out.println(HORIZONTAL_LINE);
		
		int i = 0;
		for (Customer index : customers) {
			LocalDate date = index.getJoinDate();
			System.out.format(CUSTOMER_FORMAT, ++i, index.getId(), index.getFirstName(), index.getLastName(), index.getStreetName(),
					index.getCity(), index.getPostalCode(), index.getPhoneNumber(), index.getEmail(), Validator.DATE_FORMAT.format(date));
		}
		System.out.println(HORIZONTAL_LINE);
	}
}
