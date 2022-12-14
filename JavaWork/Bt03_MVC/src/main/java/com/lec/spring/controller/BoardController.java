package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.spring.domain.Write;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list") // /board/list
//	public void list(HttpServletRequest request, Model model) { // request 객체를 통해 매개변수 받기
//	public void list(Model model, HttpServletRequest request) { // HANDLER 의 매개변수 순서 무관!
	public void list(int page, Model model) { // 핸들러 매개변수의 이름과 같은 parameter 를 받아온다!
//		String p = request.getParameter("page");
		model.addAttribute("page", page);
	}

	@GetMapping("/info") // /board/info
	public void info(Integer a, Integer b, @RequestParam("nn") String name // nn 이라는 parameter 를 name 매개변수에 받아옴
			, Model model) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("name = " + name);

		if (a == null)
			a = 0;
		if (b == null)
			b = 0;
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("name", name);
		model.addAttribute("result", a + b);
	}

	@GetMapping("/write") // /board/write
	public void write() {
	}

	@PostMapping("/write")
//	public String writeOk(String name, String subject, String content) {

	// 여러개의 매개변수의 경우 아래와 같이 객체를 통해 한번에 받아올수 있다
	// name="subject" ==> Write.setSubject() 로 받아옴
	// name="name" ==> Write.setName() 로 받아옴
	// name="content" ==> Write.setContent() 로 받아옴.
	
	// 매개변수를 받아오는 객체를 커맨드 객체(Command object) 라고 함
	// 위 과정을 binding 이라 함 
	public String writeOk(Write w) {
		System.out.println("POST: writeOk() 호출");
//		System.out.println(name + " - " + subject + " - " + content);
		System.out.println(w);

		return "board/writeOk";
	}
}
