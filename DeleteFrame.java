import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteFrame extends JFrame
{
	JPanel jp1,jp2;
	JButton delete,back;
	JTextField t1;
	JLabel l1;


	public DeleteFrame()
	{
		super("Delete Employee");
		setSize(500,150);
		setResizable(false);

		jp1=new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		delete=new JButton("Delete");
		back=new JButton("Back");
		
		l1=new JLabel("id:");
		t1=new JTextField(5);
		jp1.add(l1);
		jp1.add(t1);
		add(jp1);

		jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		jp2.add(delete);
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

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				HomeFrame h=new HomeFrame();
				dispose();
			}
		});

	

		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String id=t1.getText();

				if(id.length()==0)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Id cannot be Empty");
					return;
				}

				DatabaseHandler q=new DatabaseHandler();
				q.delete(Integer.parseInt(id));
				t1.setText("");
			}
		});

	}
}