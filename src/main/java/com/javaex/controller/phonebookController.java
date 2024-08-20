package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller /* 1번 */
public class phonebookController {

	// 필드

	// dao를 메모리에 올린다
	@Autowired
	private PhonebookDao phonebookDao = new PhonebookDao();

	// 생성자
	// 메소드gs
	// 메소드 일반

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhonebookController.list()");

		List<PersonVo> personList = phonebookDao.getPersonList();
		System.out.println(personList);

		model.addAttribute("personList", personList);
		return "list";// 포워딩해줘 라고 모델한테 말함
	}

	/* 등록폼 */
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm";
	}

	/* 등록 */
	/* VO로 받을때 */
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {// 자동으로 묶어줌
		System.out.println(personVo);

		// phonebookDao의 메소드를 이용해서 저장한다
		int count = phonebookDao.insertPerson(personVo);
		System.out.println(count);

		// 리스트로 리다이렉트
		return "redirect:/list";/* redirect:http://localhost:8888/phonebook3/list */
	}

	/* 등록 */
	/* 파라미터로 받을때 */
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "name") String name, @RequestParam(value = "hp") String hp,
			@RequestParam(value = "company") String company) {
		System.out.println("PhonebookController.write2()");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);

		return "localhost:8888/phonebook3/write";
		// localhost:8888/phonebook/write?name=aaa&hp=123&company=02
	}

	/* 삭제 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {
		System.out.println("PhonebookController.delete");

		phonebookDao.deletePerson(no);
		return "redirect:http://localhost:8888/phonebook3/list";
	}
	/*수정 폼*/
	@RequestMapping(value = "/editform", method = { RequestMethod.GET, RequestMethod.POST })
	public String editform(@RequestParam(value = "no") int no, Model model) {
		System.out.println("phonebookController.edit()");

		PersonVo personVo = phonebookDao.getPersonOne(no);
		model.addAttribute("personVo", personVo);

		return "editForm";
	}
	/*수정*/
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	 public String update(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhonebookController.edit()");
		
		System.out.println(personVo);
		
		//phonebookDao의 메소드를 이용해서 저장한다
		int count = phonebookDao.updatePerson(personVo);
		System.out.println(count);
		
		//리스트로 리다이렉트(redirect:인터넷주소)
		return "redirect:/list";
		
	}

}