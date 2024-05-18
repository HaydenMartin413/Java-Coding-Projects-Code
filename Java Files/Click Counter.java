import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private int counter;
	private boolean ended;
	private boolean started;
	private Timer timer;
	private Timer timerS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Main frame = new Main();
			frame.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Main() 
	{
		
		
		counter = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestart = new JLabel("New label");
		lblRestart.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestart.setBounds(0, 228, 344, 33);
		contentPane.add(lblRestart);
		
		JButton btnCounter = new JButton("Click to Start");
		btnCounter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (ended)
					return;
				if (!started)
				{
					lblRestart.setText("");
					timer.start();
				}
				counter++;
				btnCounter.setText(Integer.toString(counter));
				
			}
		});
		
		timer = new Timer(1000, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ended = true;
				btnCounter.setFont(new Font("Tahoma", Font.BOLD, 24));
				btnCounter.setText(counter +" Clicks in 1 Second");
				
				timerS.start();
				timer.stop();
				
			}
		});
		
		timerS = new Timer(2000, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				counter = 0;
				ended = false;
				started = false;
				lblRestart.setText("Click to Start Again");
				timerS.stop();
			}
		});
		
		btnCounter.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnCounter.setBounds(0, 0, 344, 261);
		contentPane.add(btnCounter);
		
	}

}
