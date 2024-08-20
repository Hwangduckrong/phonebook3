package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.PersonVo;

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
/*등록 */
	@RequestMapping(value="/write",method={RequestMethod.GET,RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo){//자동으로 묶어줌
		System.out.println(personVo);
		return "";
	}

	@RequestMapping(value="/write2", method= {RequestMethod.GET,RequestMethod.POST})
	public String write2(@RequestParam(value="name")String name, 
						@RequestParam(value="hp") String hp ,
						@RequestParam(value="company") String company) {
		System.out.println("PhonebookController.write2()");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name,hp,company);
		System.out.println(personVo);
		
		return "";
	//localhost:8888/phonebook/write?name=aaa&hp=123&company=02	
	}
}
