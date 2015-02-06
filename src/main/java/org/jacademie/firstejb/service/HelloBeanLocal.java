package org.jacademie.firstejb.service;
import java.util.Collection;

import javax.ejb.Local;

import org.jacademie.firstejb.entity.Student;

@Local
public interface HelloBeanLocal {

	public String sayHello();
	
	public String sayHello(String name);
	
	public Integer createStudent(Student student);
	
	public Collection<Student> findAllStudents();

	public Student findStudentByNum(Integer num);
}
