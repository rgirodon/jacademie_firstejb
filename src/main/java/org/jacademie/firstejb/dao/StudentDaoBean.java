package org.jacademie.firstejb.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jacademie.firstejb.entity.Student;

/**
 * Session Bean implementation class StudentDaoBean
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class StudentDaoBean implements StudentDaoBeanLocal {

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public StudentDaoBean() {

    }

    public Collection<Student> findAllStudent() {
    	
    	return entityManager.createQuery("SELECT s FROM Student s ORDER BY s.name").getResultList();
    }
    
    public Integer createStudent(Student student) {
    	
    	entityManager.persist(student);
    	
    	entityManager.flush();
    	
    	return student.getNum();
    }
    
    public Student findStudentByNum(Integer num) {
    	
    	return entityManager.find(Student.class, num);
    }
}
