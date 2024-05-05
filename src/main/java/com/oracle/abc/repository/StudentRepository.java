package com.oracle.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.abc.dto.StudentDto;

public interface StudentRepository extends JpaRepository<StudentDto, Integer>{

}
