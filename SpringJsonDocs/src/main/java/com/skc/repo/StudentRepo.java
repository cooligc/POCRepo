package com.skc.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skc.model.Student;
import com.skc.model.Subject;

@Repository("studentRepo")
public class StudentRepo {
	
	private static List<Student> students = null;
	
	static{
		students = new ArrayList<Student>();
		for (int i=1;i<=10;++i) {
			Subject subject = new Subject();
			subject.setName("A"+i);
			Student student = new Student();
			student.setRollNo(i);
			student.setStudentName("B"+i);
			student.setSubjects(Arrays.asList(subject));
			students.add(student);
		}
	}
	
	
	public List<Student> getStudentsDetails(){
		return getStudents();
	}
	
	public Student getStudentDetail(int index){
		return getStudents().get(index);
	}
	
	
	public static List<Student> getStudents() {
		return students;
	}

	public Student createStudent(Student student) {
		student.setRollNo(students.size()+1);
		getStudents().add(student);
		return student;
	}

	
	
	
	
	

}
