package com.tpuhalo.spring.validation.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint, Integer> {

	private int lower;

	@Override
	public void initialize(AgeConstraint age) {
		lower = age.lower();

	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if (age == null)
			return false;
		if (age < lower)
			return false;
		return true;
	}

}
