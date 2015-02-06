package org.jacademie.firstejb.dao;
import java.util.Collection;

import javax.ejb.Local;

import org.jacademie.firstejb.entity.Student;

@Local
public interface StudentDaoBeanLocal {

	public Collection<Student> findAllStudent();
	
	public Integer createStudent(Student student);

	public Student findStudentByNum(Integer num);
}
