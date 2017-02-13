package com.home.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ValidatingField {

	@NotNull
	@Pattern(regexp="^[1-3]{1}$")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static void main(String[] args) {
		ValidatingField vf = new ValidatingField();
		vf.setStatus("5");
		System.out.println( vf.getStatus() );

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ValidatingField>> violations = validator.validate(vf);
		violations.stream().map(violation -> violation.getMessage()).forEach(System.out::println);
	}
}
