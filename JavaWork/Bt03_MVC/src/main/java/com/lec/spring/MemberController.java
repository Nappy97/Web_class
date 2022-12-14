package com.lec.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")	// 	/member 로 시작하는 request 를
public class MemberController {	// 처리하는 컨트롤러 클래스

	@RequestMapping("/save")	// URL -> /member + /save
	public String saveMemeber() {//		= /member/save	
		return "member/save";
	}
	
	// @RequestMapping <- GET, POST ... 어떠한 request 도 처리
	
	@GetMapping("/load")	// GET 방식 request. /member/load
	public void loadMember() {
		// handler 가 리턴값이 없으면 
		// request url 을 view name 으로 간주함 -> /member/load.jsp
		//			해당하는 view 로 forwarding 수정
	}
}
