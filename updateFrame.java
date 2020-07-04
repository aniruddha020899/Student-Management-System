import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class updateFrame extends JFrame
{
Container c;
JLabel rnoLabel,nameLabel,sub1Label,sub2Label,sub3Label;
JTextField rnoText,nameText,sub1Text,sub2Text,sub3Text;
JButton btnSave,btnBack;

updateFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());

rnoLabel=new JLabel("Enter Roll Number:");
nameLabel=new JLabel("Enter Student Name:");
sub1Label=new JLabel("Enter subject marks 1:");
sub2Label=new JLabel("Enter subject marks 2:");
sub3Label=new JLabel("Enter subject marks 3:");
rnoText=new JTextField(15);
nameText=new JTextField(15);
sub1Text=new JTextField(15);
sub2Text=new JTextField(15);
sub3Text=new JTextField(15);
btnSave=new JButton("Save");
btnBack=new JButton("back");
c.add(rnoLabel);
c.add(rnoText);
c.add(nameLabel);
c.add(nameText);
c.add(sub1Label);
c.add(sub1Text);
c.add(sub2Label);
c.add(sub2Text);
c.add(sub3Label);
c.add(sub3Text);
c.add(btnSave);
c.add(btnBack);
ActionListener e1=(abc)->{homepage a=new homepage();dispose();};
btnBack.addActionListener(e1);

ActionListener e2=(a)->{
if(rnoText.getText().equals(""))
	JOptionPane.showMessageDialog(new JDialog(),"rno cannot be empty","WARNING",JOptionPane.WARNING_MESSAGE);
else if(nameText.getText().equals(""))
	JOptionPane.showMessageDialog(new JDialog(),"Name cannot be empty","WARNING",JOptionPane.WARNING_MESSAGE);
else if(sub1Text.getText().equals("") || sub2Text.getText().equals("") || sub3Text.getText().equals(""))
	JOptionPane.showMessageDialog(new JDialog(),"Subject marks cannot be empty","WARNING",JOptionPane.WARNING_MESSAGE);
else
{
int rno=Integer.parseInt(rnoText.getText());
String name=nameText.getText();
int sub1=Integer.parseInt(sub1Text.getText());
int sub2=Integer.parseInt(sub2Text.getText());
int sub3=Integer.parseInt(sub3Text.getText());
if(rno<0)
	JOptionPane.showMessageDialog(new JDialog(),"rno cannot be negative","WARNING",JOptionPane.WARNING_MESSAGE);
else if(rno==0)
	JOptionPane.showMessageDialog(new JDialog(),"rno cannot be zero","WARNING",JOptionPane.WARNING_MESSAGE);
else if(name.length()<2)
	JOptionPane.showMessageDialog(new JDialog(),"Name should be of minimum 2 letters","WARNING",JOptionPane.WARNING_MESSAGE);	
else if(0>sub1 || sub1>100 || 0>sub2 || sub2>100 || 0>sub3 || sub3>100)
	JOptionPane.showMessageDialog(new JDialog(),"Marks should be range of 0 and 100","WARNING",JOptionPane.WARNING_MESSAGE);	
else
{
hibernate_handler hh=new hibernate_handler();
hh.updateStudent(rno,name,sub1,sub2,sub3);
}}
};
btnSave.addActionListener(e2);


setTitle("Update Student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}