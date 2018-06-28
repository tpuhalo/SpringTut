package com.tpuhalo.spring.validation.test;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=AgeConstraintValidator.class)
public @interface AgeConstraint {

	//message attribute
	String message() default "* Must be over 18";
	Class<?>[] groups() default { }; 
	Class<? extends Payload>[] payload() default { };
	
	int lower() default 18;
	
}
