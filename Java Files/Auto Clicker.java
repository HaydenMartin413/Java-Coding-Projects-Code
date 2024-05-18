import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Robot;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SpinnerNumberModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private boolean on;
	private Timer timer;
	private JButton btnOn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
  		Main frame = new Main();
		 frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Main() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		
		SpaceBarListener checker = new SpaceBarListener();
		contentPane.addKeyListener(checker);
		
		
		on = false;
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delay between clicks (Miliseconds)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 160, 214, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Auto Clicker");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 0, 434, 76);
		contentPane.add(lblNewLabel_1);
		
		try
		{
			Robot robot = new Robot();
		
		
		
		/*
		JButton btnStart = new JButton("Auto Clicker Off");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnStart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if (checker.getOn())
					{
						btnStart.setBackground(new Color(0,200,0));
						btnStart.setText("Auto Clicker\nOn");
					}
					else
					{
						btnStart.setBackground(new Color(200,0,0));
						btnStart.setText("Auto Clicker\nOff");
					}
				}
				catch (Exception er)
				{
					er.printStackTrace();
				}
				
			}
		});
		btnStart.setBounds(10, 11, 414, 189);
		contentPane.add(btnStart);*/
		
		timer = new Timer (100, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (on)
				{
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
			}
		});
		timer.start();
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(1), null, Integer.valueOf(50)));
		spinner.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e) 
			{
				timer.setDelay((int)spinner.getValue());
			}
		});
		spinner.setBounds(10, 180, 92, 20);
		contentPane.add(spinner);
		
		btnOn = new JButton("Off");
		btnOn.setBackground(new Color (200,0,0));
		btnOn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				if (!on)
				{
					try
					{
						Thread.sleep(1000);
					}
					catch (Exception er)
					{
						er.printStackTrace();
					}
				}
				
				on = !on;
				if (on)
				{
					btnOn.setBackground(new Color (0,200,0));
					btnOn.setText("On");
				}
				else
				{
					btnOn.setBackground(new Color(200,0,0));
					btnOn.setText("Off");
				}
			}
		});
		btnOn.setBounds(230, 110, 190, 90);
		contentPane.add(btnOn);
	}
}

class SpaceBarListener extends KeyAdapter
{
	private boolean on = false;
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			//on = true;
			//System.out.println("Test");
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		//if (e.getKeyCode() == KeyEvent.VK_SPACE)
		//{
		//	on = false;
		//}
	}
	public boolean getOn()
	{
		return on;
	}
	public void setOn(boolean tempOn)
	{
		on = tempOn;
	}
}
