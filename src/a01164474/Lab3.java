package a01164474;

import java.time.Duration;
import java.time.Instant;

import a01164474.ApplicationException;
import a01164474.data.Customer;
import a01164474.io.CustomerReader;
import a01164474.io.CustomerReport;

/**
 * Project: lab3
 * @author Nathan de Souza - A01164474
 */
public class Lab3 {
	
	private static final Instant startTime = Instant.now();
	
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println(startTime);
		System.out.println("------------------------------");
		if (args.length == 0) {
			System.out.println("Input data is missing.");
			printTime();
			System.exit(-1);
		} else {
			new Lab3().run(args[0]);
		}	
	} 	
	
	private void run(String inputData) {
		
		try {
			Customer[] listOfcustomers = CustomerReader.arrayOfCustomer(inputData);
			CustomerReport.write(listOfcustomers);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println();
			System.out.println("------------------------------");
			printTime();
			System.out.println("------------------------------");
		}
	}
	
	public static void printTime() {
		Instant time = Instant.now();
		System.out.println(time);
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, time).toMillis()));
	}
}
