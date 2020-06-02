package a01164474.data.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import a01164474.ApplicationException;

/**
 * Project: lab3
 * @author Nathan de Souza - A01164474
 */
public class Validator {
	
	
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");
	
	private static final String DATEYYYYMMDD_PATTERN = "(20\\d{2})(\\d{2})(\\d{2})";
	
	//validating email
	public static String getEmailAddress(String email) throws ApplicationException {

		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {
			return email;
		} else {
			throw new ApplicationException(String.format("Invalid email: %s", email));
		}
	}

	//validating postal code
	public static String getPostalCode(String postalCode) throws ApplicationException {

		Pattern pattern = Pattern.compile("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$");
		Matcher matcher = pattern.matcher(postalCode);

		if (matcher.matches()) {
			return postalCode;
		} else {
			throw new ApplicationException(String.format("Invalid postal code: %s", postalCode));
		}
	}

	//validating phoneNumber
	public static String getPhoneNumber(String phoneNumber) throws ApplicationException {

		Pattern pattern = Pattern.compile("^([(][0-9][0-9][0-9][)])\\s([0-9][0-9][0-9][-][0-9][0-9][0-9][0-9])$");
		Matcher matcher = pattern.matcher(phoneNumber);

		if (matcher.matches()) {
			return phoneNumber;
		} else {
			throw new ApplicationException(String.format("Invalid phone number: %s", phoneNumber));
		}
	}	
	
	//validating date/time
	public static LocalDate getJoinedDate(String dateFormatted) throws ApplicationException {
		
		LocalDate joinDate = null;
		
		if (!dateFormatted.matches(DATEYYYYMMDD_PATTERN)) {
			throw new ApplicationException(String.format("Invalid joined date: %s", dateFormatted));
		}
		try {
			joinDate = LocalDate.parse(dateFormatted, DateTimeFormatter.ofPattern("yyyyMMdd"));
		} catch (Exception element) {
			throw new ApplicationException(String.format("Invalid joined date: %s", dateFormatted));
		}

		return joinDate;
	}
}
