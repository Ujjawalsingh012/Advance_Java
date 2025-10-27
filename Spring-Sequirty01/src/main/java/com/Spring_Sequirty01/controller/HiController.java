package com.Spring_Sequirty01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
 
	@GetMapping("/hi")
	public String sayhi() {
		return "index.html";
	}
	
	@GetMapping("/hii")
	public String sayheio() {
		return "hello word";
	}
	
}
