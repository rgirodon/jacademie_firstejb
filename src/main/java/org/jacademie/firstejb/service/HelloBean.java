package org.jacademie.firstejb.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jacademie.firstejb.dao.StudentDaoBeanLocal;
import org.jacademie.firstejb.entity.Student;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HelloBean implements HelloBeanLocal {

	@EJB
	private StudentDaoBeanLocal studentDaoBean;
	
    /**
     * Default constructor. 
     */
    public HelloBean() {
        
    }

    public String sayHello(String name) {
    	
    	return "Hello " + name + " !";
    }
    
    public String sayHello() {
    	
    	return "Hello World !";
    }
    
    @Schedule(minute="*/1", hour="*", persistent=false)
    public void listStudents() {
	    
    	Collection<Student> students = this.findAllStudents();
    	
    	System.out.println("Students found in DB : " + students);
    }
    
    public Collection<Student> findAllStudents() {
    	
    	return studentDaoBean.findAllStudent();
    }
    
    public Student findStudentByNum(Integer num) {
    	
    	return studentDaoBean.findStudentByNum(num);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer createStudent(Student student) {
    	
    	return studentDaoBean.createStudent(student);
    }
}
