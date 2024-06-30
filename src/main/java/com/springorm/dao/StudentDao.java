package com.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student)
	{
		//insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single data(object)
	public Student getStudent(int studentId)
	{
		Student student= this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//get all the data(all rows)
	public List<Student> getAllStudents()
	{
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete the data
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student1 = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student1);
		//this delete method does not returns anything 
	}
	
	//update the data 
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
