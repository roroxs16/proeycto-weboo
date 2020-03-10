package com.poseidonapp.prototipo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class AplicacionposeidonApplication implements CommandLineRunner{

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(AplicacionposeidonApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String password ="admin";
		
		for(int i=0; i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(password);
		//	System.out.println(bcryptPassword);
		}
	}

}

