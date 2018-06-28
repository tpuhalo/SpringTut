package com.tpuhalo.spring.domain.test;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tpuhalo.spring.validation.test.AgeConstraint;
import com.tpuhalo.spring.validation.test.FieldsVerification;
import com.tpuhalo.spring.validation.test.EmailValidation;

@FieldsVerification.List({
		@FieldsVerification(field = "email", fieldMatch = "verifyEmail", message = "* Emails don't match"),
		@FieldsVerification(field = "password", fieldMatch = "verifyPassword", message = "* Passwords don't match"), })
public class OrganizationRepresentative {

	@NotBlank(message = "* First Name: cannot be blank")
	private String firstName;

	@NotEmpty(message = "* Cannot be empty")
	@Size(min = 3, max = 10, message = "Min 3 and max 10.")
	private String lastName;

	@AgeConstraint(lower = 13, message = "Age is lower then previously.")
	private Integer age;

	@NotBlank(message = "* Cannot be empty")
	@Pattern(regexp = "^[a-zA-z-0-9]{6}", message = "* Zipcode: 6 characters only")
	private String zipCode;

	@EmailValidation(message = "* Email: is invalid")
	@NotBlank(message = "* Email cannot be blank")
	private String email;
	@NotBlank(message = "* Verify email cannot be blank")
	private String verifyEmail;
	@NotBlank(message = "* Password cannot be blank")
	private String password;
	@NotBlank(message = "* Verify password cannot be blank")
	private String verifyPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

}
