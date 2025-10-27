package com.Spring_Sequirty01.cinfig;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;  // ✅ correct one


@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	
	//@Bean
	public  InMemoryUserDetailsManager setUser(){
		
		GrantedAuthority grand = new SimpleGrantedAuthority("visiter");
		
		ArrayList<GrantedAuthority> autherity =new ArrayList<>(); 
		autherity.add(new SimpleGrantedAuthority("admin"));
		autherity.add(new SimpleGrantedAuthority("user"));
		autherity.add(grand);
		UserDetails users= new User("ujjawal" ,"ujjawal",autherity);
		
		InMemoryUserDetailsManager imDetailsManager = new InMemoryUserDetailsManager();
		imDetailsManager.createUser(users);
		return imDetailsManager;
		
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

	    UserDetails user1 = User.withUsername("uks")
	            .password("uks")  
	            .roles("ADM", "IN")     
	            .build();
	    
	    UserDetails user2 = User.withUsername("kinu")
                .password("kinu")
                .roles("IN")
                .build();

        // ✅ Both users added to in-memory store
        return new InMemoryUserDetailsManager(user1, user2);
	}

	      @Bean
    public SecurityFilterChain OwnsecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		   httpSecurity.authorizeHttpRequests().requestMatchers("/hi").authenticated();
		   httpSecurity.authorizeHttpRequests().requestMatchers("/hii").permitAll();
		   httpSecurity.formLogin();
		   httpSecurity.httpBasic();
	        return httpSecurity.build();
	    }
	
		
	
	@Bean
	PasswordEncoder  passwordencoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
   
}
