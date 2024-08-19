package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller /* 1번 */
public class phonebookController {

	// 필드
	// 생성자
	// 메소드gs
	// 메소드 일반
	// 등록폼
	// 등록
	// 리스트
	@RequestMapping(value = "/writeform" , method= {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "/WEB-INF/views/writeForm.jsp";
	}
}