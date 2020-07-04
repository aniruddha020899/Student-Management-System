import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class homepage extends JFrame
{
Container c;
JButton addBtn,viewBtn,updateBtn,deleteBtn,chartsBtn;

homepage()
{
c=getContentPane();
c.setLayout(new FlowLayout());
addBtn=new JButton("Add");
viewBtn=new JButton("View");
updateBtn=new JButton("Update");
deleteBtn=new JButton("Delete");
chartsBtn=new JButton("Charts");

c.add(addBtn);
addBtn.setSize(200, 200);
c.add(viewBtn);
c.add(updateBtn);
c.add(deleteBtn);
c.add(chartsBtn);

ActionListener e1=(abc)->{addFrame a=new addFrame();dispose();};
addBtn.addActionListener(e1);
ActionListener e2=(abc)->{viewFrame a=new viewFrame();dispose();};
viewBtn.addActionListener(e2);
ActionListener e3=(abc)->{updateFrame a=new updateFrame();dispose();};
updateBtn.addActionListener(e3);
ActionListener e4=(abc)->{deleteFrame a=new deleteFrame();dispose();};
deleteBtn.addActionListener(e4);
ActionListener e5=(abc)->{C1 a=new C1();};
chartsBtn.addActionListener(e5);

setTitle("Home Page");
setSize(460,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}


