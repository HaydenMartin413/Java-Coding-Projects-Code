import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Window extends JFrame implements KeyListener{

	private JPanel contentPane;
	private int clicksLeft;
	private char key;
	private JLabel lblClicksLeft;
	private JLabel lblKey;
	private double time;
	private JLabel lblTime;
	private int keysPressed;
	private Timer timer;
	private JLabel lblKeysPressed;
	
	public Window() 
	{
		keysPressed = 0;
		time = 20;
		System.out.println("A Final Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClicksLeft = new JLabel(clicksLeft + "");
		lblClicksLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblClicksLeft.setBounds(0, 10, 430, 104);
		lblClicksLeft.setFont(new Font("Tahoma", Font.PLAIN, 60));
		contentPane.add(lblClicksLeft);
		
		lblKey = new JLabel(key + "");
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblKey.setBounds(0, 125, 430, 100);
		contentPane.add(lblKey);
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(0, 240, 435, 20);
		contentPane.add(lblTime);
		
		lblKeysPressed = new JLabel("0");
		lblKeysPressed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKeysPressed.setBounds(0, 240, 430, 20);
		contentPane.add(lblKeysPressed);
		newScreen();
		
		addKeyListener(this);
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    
	    timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	time-=0.1;
            	lblTime.setText((int)(time*10)/10.0 + "");
            	if (time <= 0)
            	{
            		timer.stop();
            		endGame();
            	}
            }
        });
	    timer.start();
	}
	
	public int generateRandomClicks()
	{
		return (int)(Math.random() * 5 + 1);
	}
	public char generateRandomKey()
	{
		return (char)(Math.random() * 26 + 65);//65 to 90
	}
	public void newScreen()
	{
		clicksLeft = generateRandomClicks();
		key = generateRandomKey();
		contentPane.setBackground(new Color((int)(Math.random()*155)+100, (int)(Math.random()*155)+100, (int)(Math.random()*155)+100));
		lblClicksLeft.setText(clicksLeft + "");
		lblKey.setText(key + "");
	}
	
	public void endGame()
	{
		lblClicksLeft.setText("Game Over");
		lblKey.setText("You Pressed " + keysPressed + " Keys");
		lblKeysPressed.setText("\"Space\" to try again");
		lblKeysPressed.setText("");
		key = 255;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
	    if(e.getKeyChar() == key + 32)
	    {
	    	clicksLeft--;
	    	lblClicksLeft.setText(clicksLeft + "");
	    	keysPressed++;
	    	lblKeysPressed.setText(keysPressed + "");
	    	if (clicksLeft <= 0)
	    	{
	    		newScreen();
	    	}
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_SPACE)
	    {
	    	restart();
	    }
	}
	
	public void restart()
	{
		time = 20;
		keysPressed = 0;
		newScreen();
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
