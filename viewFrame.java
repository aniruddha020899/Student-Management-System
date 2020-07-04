import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class viewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

viewFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

taData=new TextArea(10,30);
btnBack=new JButton("Back");

c.add(taData);
c.add(btnBack);
ActionListener e1=(abc)->{homepage a=new homepage();dispose();};
btnBack.addActionListener(e1);
hibernate_handler hh=new hibernate_handler();
String data=hh.getStudent();
taData.setText(data);

setTitle("View Student");
setSize(500,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}