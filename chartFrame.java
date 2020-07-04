import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


class C1 extends JFrame{
C1()
{
DefaultCategoryDataset d1=new DefaultCategoryDataset();
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
try
{
	session=sfact.openSession();
	List<Student> stu=new ArrayList<>();
	stu=session.createQuery("from Student").list();		
	for(Student s:stu)
	{
		String a=String.valueOf(s.getRno());
		String name=s.getName();
		int s1=s.getsub1();
		int s2=s.getsub2();
		int s3=s.getsub3();
		d1.addValue(s1,name,"sub1");
		d1.addValue(s2,name,"sub2");
		d1.addValue(s3,name,"sub3");
	}
	
}
catch(Exception e){System.out.println("issue"+e);}
finally{session.close();}

JFreeChart chart=ChartFactory.createBarChart("Student Marks","Subjects","Marks",d1,PlotOrientation.VERTICAL,true,false,false);

ChartPanel cp=new ChartPanel(chart);
setContentPane(cp);


setTitle("Mark sheet Graph");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}
