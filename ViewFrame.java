import java.awt.event.*;
import javax.swing.*;

public class ViewFrame extends JFrame
{
	JTextArea ta;
	JScrollPane sp1;

	public ViewFrame()
	{
		super("View All Employee");
		setSize(500,150);
		setResizable(false);

		ta=new JTextArea(10,10);
		ta.setEditable(false);

		sp1=new JScrollPane(ta);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(sp1);

		DatabaseHandler q=new DatabaseHandler();
		String s=q.query();
		ta.setText(s);

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
	}
}
