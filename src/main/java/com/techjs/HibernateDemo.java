package com.techjs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.techjs.pojo.Student;

public class HibernateDemo 
{

	public static void main(String[] args)
	{
	
		Student student = new Student();
		student.setId(1004);
		student.setFirstName("Kalyan");
		student.setLastName("Kumar");
		
       Configuration cfg = new Configuration().configure();
       
       SessionFactory sf = cfg.buildSessionFactory();
       Session session = sf.openSession();
       
       Transaction ts = session.beginTransaction();
       //session.save(student);
       
      // session.delete(student);
       
//       Student std = (Student) session.get(Student.class,1001);
//       std.setFirstName("Ambu");
//       session.update(std);
       
       List<Student> studentList  = session.createQuery("FROM Student").list();    		   
       for (Student st : studentList) 
       {   
		   System.out.println(st.getFirstName());
	   }
       ts.commit();
       session.close();
       sf.close();
	}

}
