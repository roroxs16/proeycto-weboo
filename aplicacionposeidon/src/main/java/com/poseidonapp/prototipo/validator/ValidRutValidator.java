package com.poseidonapp.prototipo.validator;

import static java.lang.Character.getNumericValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidRutValidator implements ConstraintValidator<ValidRut, String>{

	@Override
	public boolean isValid(String rut,ConstraintValidatorContext context) {
		if(!rut.matches("\\d{3,8}-[\\d|kK]{1}") )    return false;
		return rutAlgorithm(rut);
	}
	
	private boolean rutAlgorithm(String rut) {
		String [] rutDividido = rut.split("-");
		System.out.println(rutDividido[0]);
        char[] rutSinDigito =rutDividido[0].toCharArray();
        int factor=0;
        int suma =0;
        int largoRutSinDigito=rutSinDigito.length;
        for (int i = largoRutSinDigito-1; i >= 0 ; i--,factor++) {
        	suma+=getNumericValue(rutSinDigito[i]) * (factor%6 +2);
        		
        }
        String digVer = 11-suma%11+"";
        if(digVer.equals("11")) 
        	digVer="0";
        else if(digVer.equals("10"))
        	digVer="k";
        System.out.println("suma: "+suma +"\tDigVerificador: "+digVer);
        return digVer.equalsIgnoreCase(rutDividido[1]);  		
	}
}
