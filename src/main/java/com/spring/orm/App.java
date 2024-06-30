package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentdao = (StudentDao) context.getBean("studentDao");
//       Student student = new Student(710, "Rashi Dashore", "Indore");
//       int r = studentdao.insert(student);
//       System.out.println("done: " +r);
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       boolean go = true;
       while(go) 
       {
       System.out.println("PRESS 1 to new student");
       System.out.println("PRESS 2 to display all students");
       System.out.println("PRESS 3 to get single data of student");
       System.out.println("PRESS 4 to delete students");
       System.out.println("PRESS 5 to update student");
       System.out.println("PRESS 6 to exit");

       try
       {
    	 int input = Integer.parseInt(br.readLine());
    	 
    	 switch (input) {
		case 1:
			//add new student
			System.out.println("Enter student id : ");
			int sId = Integer.parseInt(br.readLine());
			System.out.println("Enter student name: ");
			String sName = br.readLine();
			System.out.println("Enter student city : ");
			String sCity = br.readLine();
			Student studentData = new Student(sId, sName, sCity);
			studentdao.insert(studentData);
			System.out.println("Student with id "+sId+" added successfully.");
			System.out.println("********************************************");
			
			break;
		case 2:
			//display all students
			System.out.println("********************************************");
			System.out.println("Sure! Here is the complete student data : ");
			List<Student> allStudents = studentdao.getAllStudents();
			for(Student s: allStudents)
			{
				System.out.println("Id : " +s.getStudentId());
				System.out.println("Name : "+s.getStudentName());
				System.out.println("City : "+s.getStudentCity());
				System.out.println("______________________________________-");
			}
			System.out.println("********************************************");
			break;
		case 3:
			//get single data of student
			System.out.println("Id of Student whose data you need: ");
			int stud_id = Integer.parseInt(br.readLine());
			Student stud = studentdao.getStudent(stud_id);
			System.out.println("Id : " +stud.getStudentId());
			System.out.println("Name : "+stud.getStudentName());
			System.out.println("City : "+stud.getStudentCity());
			System.out.println("********************************************");
			break;
		case 4: 
			//delete data 
			System.out.println("Id of Student whose data you want to delete: ");
			int stud_delete = Integer.parseInt(br.readLine());
			studentdao.deleteStudent(stud_delete);
			System.out.println("Deleted the data of given id.");
			System.out.println("********************************************");
			break;
		case 5:
			//update the data 
			System.out.println("student id to update data: ");
			int updateId = Integer.parseInt(br.readLine());
			System.out.println("Give updated name: ");
			String updateName = br.readLine();
			System.out.println("Give updated city: ");
			String updateCity = br.readLine();
			Student stud_update = new Student(updateId, updateName, updateCity);
			studentdao.updateStudent(stud_update);
			System.out.println("Data of student with id "+updateId+" updated successfully");
			System.out.println("********************************************");
			break;
		case 6:
			go = false;
			break;
		
		}
       }
       catch(Exception e)
       {
    	   System.out.println("Invalid input. Try again");
    	   System.out.println(e.getMessage());
       }
    }
       System.out.println("Thank you for using my application");
       System.out.println("********************************************");
		
    }
}
