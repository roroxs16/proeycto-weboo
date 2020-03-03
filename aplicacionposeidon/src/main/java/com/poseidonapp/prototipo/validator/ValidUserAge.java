package com.poseidonapp.prototipo.validator;

import javax.validation.ConstraintValidator;
import java.util.Calendar;
import java.util.Date;


import javax.validation.ConstraintValidatorContext;

public class ValidUserAge implements ConstraintValidator<ValidAge, Date> {

	@Override
	public boolean isValid(Date fechaNacimientoSocio,ConstraintValidatorContext context) {
		if(fechaNacimientoSocio==null) return false;
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(fechaNacimientoSocio);
		if(calcularEdad(fechaNac)<3)    return false;
		return true;
	}

	private static int calcularEdad(Calendar fechaNac) {
	    Calendar today = Calendar.getInstance();
	    int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
	    int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
	    int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
	    // Si está en ese año pero todavía no los ha cumplido
	    if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
	        diffYear = diffYear - 1;
	    }
	    return diffYear;
	}  	
}
