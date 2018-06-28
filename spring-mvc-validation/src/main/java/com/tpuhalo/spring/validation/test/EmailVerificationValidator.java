package com.tpuhalo.spring.validation.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.EmailValidator;

@SuppressWarnings("deprecation")
public class EmailVerificationValidator implements ConstraintValidator<EmailValidation, String> {

	private String message;

	@Override
	public void initialize(EmailValidation constraintAnnotation) {
		this.message = constraintAnnotation.message();

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		EmailValidator emailValidator = EmailValidator.getInstance();
		if (email == null)
			return false;
		if (!emailValidator.isValid(email))
			return false;
		return true;
	}

}
