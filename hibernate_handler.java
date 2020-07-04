import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

class hibernate_handler{
public static void addStudent(int rno,String name,int sub1,int sub2,int sub3){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;
try{
	session=sfact.openSession();
	t=session.beginTransaction();
	Student s=new Student(rno,name,sub1,sub2,sub3);
	session.save(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Record Inserted");
}
	catch(Exception e){
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(),"Error while inserting record","Error",JOptionPane.ERROR_MESSAGE);
	System.out.println("issue "+e);
}
finally{
	session.close();
}}

public static String getStudent(){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
String data="";
Session session=null;
try{
	session=sfact.openSession();
	List<Student> stu=new ArrayList<>();
	stu=session.createQuery("from Student").list();		//HQL-->Hibernate query Language-->Student is object name 
								//	not table name
	for(Student s:stu)
	{
	data=data+("rno:"+s.getRno() +" name:"+s.getName()+" sub1:"+s.getsub1()+" sub2:"+s.getsub2()+" sub3:"+s.getsub3()+"\n");
	}
}
catch(Exception e){
	System.out.println("issue "+e);
}
finally{
	session.close();
}
return data;
}

public static void updateStudent(int rno,String name,int sub1,int sub2,int sub3){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;
try{
	session=sfact.openSession();
	t=session.beginTransaction();
	Student s=(Student)session.get(Student.class,rno);
	if(s!=null)
	{
		session.delete(s);
		Student stu=new Student(rno,name,sub1,sub2,sub3);
		session.save(stu);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(),"Record Updated");
	}
	else
	{
		JOptionPane.showMessageDialog(new JDialog(),"Roll No doesnot exists");
	}
}
catch(Exception e){
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),"Cannot update Student Record","error",JOptionPane.ERROR_MESSAGE);
System.out.println("issue "+e);
}
finally{
	session.close();
}}

public static void deleteStudent(int rno)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();

Session session=null;
Transaction t=null;
try{
	session=sfact.openSession();
	t=session.beginTransaction();
	Student s=(Student)session.get(Student.class,rno);
	if(s!=null)
	{
		session.delete(s);
		t.commit();	
		JOptionPane.showMessageDialog(new JDialog(),"Record Deleted");
	}
	else
		JOptionPane.showMessageDialog(new JDialog(),"Roll No does not exist");
}
catch(Exception e){
	t.rollback();
	System.out.println("issue "+e);
}
finally{
	session.close();
}
}
}