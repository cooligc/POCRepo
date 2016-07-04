package com.skc.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skc.common.Commons;
import com.skc.model.Student;
import com.skc.repo.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentServices {
	
	
	
	@Resource(name="studentRepo")
	StudentRepo studentRepo;
	
	
	@RequestMapping(method=RequestMethod.GET,produces={Commons.APPLICATION_JSON})
	public List<Student> getAllStudent(){
		return studentRepo.getStudentsDetails();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={Commons.APPLICATION_JSON})
	public Student getStudent(@PathVariable("id") int index){
		return studentRepo.getStudentDetail(index);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces={Commons.APPLICATION_JSON})
	public Student createStudent(Student student){
		return studentRepo.createStudent(student);
	}

}
