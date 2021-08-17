package aws.boot.user.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserModel implements Serializable{
	private static final long serialVersionUID = -4145144685209541082L;
	private Long userId;
	private String userName;
	/** givenName means firstName followed by MiddleName
	private String givenName;
	
	private String firstName;
	private String middleName;
	
	private String surName;
	private LocalDate dateOfBirth;
	
	// private AddressModel placeOfBirth;
	
	private String gender;
	private String maritalStatus;
	
	private String panNumber; // if applicable
	private String voterId;
	
	private String employmentType;
	
	// private AddressModel present;
	// private boolean isPresentPermanentSame;
	
	private Long pinNumber;
	private Long mobileNumber;
	private String emailId;
	
	// private UserModel emergencyContact;
	// private PassportModel heldPassport;
	**/
	
	
}
