package com.oracle.abc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.abc.dao.StudentDao;
import com.oracle.abc.dto.StudentDto;

@RestController
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@PostMapping("/students")
	public String insert(@RequestBody List<StudentDto> dtos) {
		 return dao.save(dtos);
//		return dtos;
	}
	
	@GetMapping("/abc")
	public String hello()
	{
		return "sample.html";
	}
	
//	@GetMapping("/fetchById")
//	public StudentDto fetchByid(@RequestBody StudentDto dto)
//	{
//		int id=dto.getId();
//		return dao.fetchid(id);
//	}
	@GetMapping("/studentsid{id}")
	public Object fetchByid(@RequestParam int id)
	{
		StudentDto dto= dao.fetchid(id);
		if(dto!=null)
		{
			return dto;
		}
		else
		{
			return "no data found";
		}
	}
	// while using request param use fetchByid?id=1 in postman
	@GetMapping("/students")
	 public List<StudentDto> fetchAll()
	 {
		return dao.fetchAll();
	 }
	@DeleteMapping("/students/{id}")
	public String delete(@PathVariable int id)
	{
		return dao.deleteBYId(id);
	}
	//in postman in url write deletebyid/1 for above delete by id
	
	@DeleteMapping("/students")
	public String deleteALL()
	{
		return dao.deleteALLL();
	}
	@PutMapping("/students")
	 public String updatee(@RequestBody StudentDto dto)
	 {
		 return dao.Update(dto);
	 }
}


//@RequestParam--directly  we can pass variable value in the url in postman ---?id=1
//@PathVariable----directly we can pass varibale value in the url in the postman ---/1