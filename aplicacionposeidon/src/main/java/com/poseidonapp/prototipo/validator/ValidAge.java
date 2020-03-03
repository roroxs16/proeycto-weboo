package com.poseidonapp.prototipo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD,ElementType.FIELD}) //es un campo pasado por post
@Retention(RetentionPolicy.RUNTIME) //sera retenido en tiempo de ejecucion
@Constraint(validatedBy=ValidUserAge.class)
public @interface ValidAge {
	
	String message() default "Edad no válida";
	Class<? extends Payload>[] payload() default{}; //para cargar los datos
	Class<?>[] groups() default {};

}
