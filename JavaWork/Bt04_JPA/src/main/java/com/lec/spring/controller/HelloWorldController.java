package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	
	@GetMapping("/helloworld")
	@ResponseBody    // 리턴하는 값 자체를 response 함 ('뷰' 를 리턴하는게 아니라)
	public String helloWorld() {
		return "hello-world";
	}
	
}
