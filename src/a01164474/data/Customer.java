package a01164474.data;

import java.time.LocalDate;


/**
 * Project: lab3
 * @author Nathan de Souza - A01164474
 */
public class Customer {

	public static final int COUNTER_ELEMENTS = 9;
	
	private String id;
	private String firstName;
	private String lastName;
	private String streetName;
	private String city;
	private String postalCode;
	private String phoneNumber;
	private String email;
	private LocalDate joinDate;
	
	public static class Builder {
		//required parameters
		private String id;
		private String phoneNumber;
		
		//optional parameters
		private String firstName;
		private String lastName;
		private String streetName;
		private String city;
		private String postalCode;
		private String email;
		private LocalDate joinDate;
		
		public Builder(String id, String phoneNumber) {
			this.id = id;
			this.phoneNumber = phoneNumber;
		}
		
		public Builder firstName(String data) {
			firstName = data;
			return this;
		}
		
		public Builder lastName(String data) {
			lastName = data;
			return this;
		}
		
		public Builder streetName(String data) {
			streetName = data;
			return this;
		}
		
		public Builder city(String data) {
			city = data;
			return this;
		}
		
		public Builder postalCode(String data) {
			postalCode = data;
			return this;
		}
		
		public Builder email(String data) {
			email = data;
			return this;
		}
		
		public Builder joinDate(int year, int month, int day) {
			joinDate = LocalDate.of(year, month, day);
			return this;
		}
		
		public Builder setJoinDate(LocalDate date) {
			joinDate = date;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
		
	}

	/**
	 * @param builder
	 */
	private Customer(Builder builder) {
		id = builder.id;		
		firstName = builder.firstName;
		lastName = builder.lastName;
		streetName = builder.streetName;
		city = builder.city;
		postalCode = builder.postalCode;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
		joinDate = builder.joinDate;
	}
		
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.isEmpty()) {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if(lastName != null && !lastName.isEmpty()) {
			this.lastName = lastName;
		}
	}

	public void setStreetName(String streetName) {
		if(streetName != null && !streetName.isEmpty()) {
			this.streetName = streetName;
		}
	}

	public void setCity(String city) {
		if(city != null && !city.isEmpty()) {
			this.city = city;
		}
	}

	public void setPostalCode(String postalCode) {
		if(postalCode != null && !postalCode.isEmpty()) {
			this.postalCode = postalCode;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber != null && !phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
	}

	public void setEmail(String email) {
		if(email != null && !email.isEmpty()) {
			this.email = email;
		}
	}
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetName="
				+ streetName + ", city=" + city + ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", joinDate=" + joinDate + "]";
	}
	
}
