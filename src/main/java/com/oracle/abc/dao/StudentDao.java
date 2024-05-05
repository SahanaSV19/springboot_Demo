package com.oracle.abc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.abc.dto.StudentDto;
import com.oracle.abc.repository.StudentRepository;

@Component
public class StudentDao {
	@Autowired
	StudentRepository repository;

	public String save(List<StudentDto> dtos) {
		for(StudentDto a:dtos)
		repository.save(a);
		return "saved";
	}

	public List<StudentDto> fetchAll() {
		return repository.findAll();
	}

	public StudentDto fetchid(int id) {
		// TODO Auto-generated method stub
		Optional<StudentDto> dt = repository.findById(id);
		return dt.get();
	}

	public String deleteBYId(int id) {
		// TODO Auto-generated method stub
		Optional<StudentDto> dt = repository.findById(id);
		StudentDto dto = dt.get();
		repository.delete(dto);
		return "deleted";
	}

	public String Update(StudentDto dto) {
		// TODO Auto-generated method stub
		Optional<StudentDto> dt = repository.findById(dto.getId());
		StudentDto d2 = dt.get();
		if (d2 != null) {
			d2.setName(dto.getName());
			repository.flush();
//			repository.save(d2);
			return "UPDATED";
		} else {
			return "Data not found";
		}
	}

	public String deleteALLL() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		return "Data deleted";
	}

}
