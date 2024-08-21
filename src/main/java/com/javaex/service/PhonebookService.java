package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//exe면 service를 뜻한다
	
	/*전화번호 등록*/
	public int exeWriteperson(PersonVo personVo) {
		System.out.println("phonebookService.exeWriteperson");
		
		int count =phonebookDao.insertPerson(personVo);
		
		return count;
	}
	
	/*전화번호 전체 가져오기*/
	public List<PersonVo>exeGetPerson(){
		System.out.println("phonebookService.exeGetperson()");
		List<PersonVo> personList = phonebookDao.getPersonList();
		
		return personList;
	}
	
	/*삭제*/
	public int exePersonDelete(int no) {
		System.out.println("PhonebookService.exePersonDelete()");
		System.out.println(no);
	int count = phonebookDao.deletePerson(no);
	return count;
	
	}

	/*수정 폼*/
	public PersonVo exeEditForm(int no) {
		System.out.println("PhonebookService.exeEditForm()");
		
		PersonVo personVo = phonebookDao.getPersonOne(no);
		
		return personVo;
	}
	
	/*수정*/
	public int exeEditPerson(PersonVo personVo) {
		System.out.println("PhonebookService.exeEdit()");
		
		int count = phonebookDao.updatePerson(personVo);
		
		return count;
	}
}