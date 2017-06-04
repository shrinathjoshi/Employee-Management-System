import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.regex.*;
import mu.Sound;
public class AddFrame extends JFrame
{

	JPanel jp1,jp2;
	JButton add,back;
	JLabel l1,l2;
	JTextField t1,t2;

	public AddFrame()
	{

		super("Add employee");
		setSize(500,150);
		setResizable(false);
		

		jp1=new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		add=new JButton("Add");
		back=new JButton("Back");
		l1=new JLabel("id:");
		l2=new JLabel("Name:");
		t1=new JTextField(5);
		t2=new JTextField(10);

		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(t2);
		add(jp1);

		jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		jp2.add(add);
		jp2.add(back);
		add(jp2,BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				HomeFrame h=new HomeFrame();
				dispose();
			}
		});

		back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			HomeFrame a=new HomeFrame();
			dispose();
		}

		});

		add.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			String id=t1.getText();
			String name=t2.getText();

			if(id.length()==0)
			{
				Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"Id cannot be Empty");
				return;
			}

			if(name.length()==0)
			{
				Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"Name cannot be Empty");
				return;
			}

			if(!Pattern.matches("[0-9][0-9]*",id))
			{
				Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"Please Enter a valid Id");
				return;

			}

			if(!Pattern.matches("[a-zA-Z][a-zA-Z]*",name))
			{
				Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"Please Enter a valid Name");
				return;
			}

			DatabaseHandler q=new DatabaseHandler();
			q.insert(Integer.parseInt(id),name);
			t1.setText("");
			t2.setText("");
		}
		});

	}
}