package com.vmtech.demo.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RestClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public  String sayHello(@RequestParam String name) {
		 UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/hello")
				                                              .queryParam("name", name);
		 UriComponents build = UriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/hello")
         .queryParam("name", name).build();
		String greeting = restTemplate.getForObject(build.encode().toUri(), String.class);
		return "Greeting from Client: "+greeting;
	}
}
