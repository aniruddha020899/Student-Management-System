import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class deleteFrame extends JFrame
{
Container c;
JLabel rnoLabel;
JTextField rnoText;
JButton btnSave,btnBack;
deleteFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());

rnoLabel=new JLabel("Enter Roll Number:");
rnoText=new JTextField(15);
btnSave=new JButton("Save");
btnBack=new JButton("back");

c.add(rnoLabel);
c.add(rnoText);
c.add(btnSave);
c.add(btnBack);
ActionListener e1=(abc)->{homepage a=new homepage();dispose();};
btnBack.addActionListener(e1);

ActionListener e2=(abcd)->{
if(rnoText.getText().equals(""))
	JOptionPane.showMessageDialog(new JDialog(),"Roll no cannot be empty","Warning",JOptionPane.WARNING_MESSAGE);
else
{
int rno=Integer.parseInt(rnoText.getText());
hibernate_handler h=new hibernate_handler();
h.deleteStudent(rno);
}
};
btnSave.addActionListener(e2);

setTitle("Delete Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(320,300);
setVisible(true);
}

}