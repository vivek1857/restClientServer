package com.vmtech.demo.hello.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue="Amit") String name) {
		return "hello dear: "+name;
	}

}
