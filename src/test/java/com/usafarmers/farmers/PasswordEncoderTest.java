package com.usafarmers.farmers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
	
	  @Test
	  public void encrypt_password () {
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    String encodedPassword = passwordEncoder.encode("123");
	    
	    System.out.println(encodedPassword);
	  }

}
