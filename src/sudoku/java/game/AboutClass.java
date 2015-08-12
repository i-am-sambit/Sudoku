
package sudoku.java.game;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AboutClass extends JFrame
{
	JLabel label,label1;
	public AboutClass()
	{
		initComp();
	}
	
	private void initComp()
	{
		setVisible(true);
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,100);
		setResizable(false);
		
		getContentPane().setLayout(new GridLayout(2, 1));
		
		label = new JLabel();
		label1 = new JLabel();
		
		label.setText("This is created by Sambit Prakash Dash");
		label1.setText("Version 2.0.1");
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(label);
		getContentPane().add(label1);
	}
}
