package com.lumen.dssh.orchestrator.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FormData {
	String firstName;
	String middleName;
	String lastName;
	String ebbpApplicationNumber;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String zipcode;
	String accountNumber;
	String userName;
	String ssn;
	String dob;
	String emailAddress;
	String telephoneNumber;
	boolean dependentField;
	boolean tribal;
	String depFirstName;
	String depMiddleName;
	String depLastName;
	String depssn;
	String depdob;
	boolean consent1;
	boolean continueService;
	boolean consent2;
	boolean ebbpEligibilityFlag;
	boolean NoEnrollSuccess;
	boolean NoEnrollFail;
	String eatToken;
	String sac;
	

}
