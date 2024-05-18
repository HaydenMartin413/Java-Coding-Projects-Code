import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Main extends JFrame 
{
	private JPanel contentPane;
	private ButtonGroup diceTypes;
	private JSpinner spinner;
	private JLabel lblRoll;
	private JTextArea prevRolls;
	private JTextArea prevRollTypes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
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
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Dice Roller");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTitle.setBounds(10, 0, 273, 60);
		contentPane.add(lblTitle);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnRoll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rollDice();
			}
		});
		btnRoll.setBounds(10, 180, 166, 66);
		contentPane.add(btnRoll);
		
		spinner = new JSpinner();
		spinner.setBounds(224, 226, 73, 20);
		contentPane.add(spinner);
		
		diceTypes = new ButtonGroup();
		
		JRadioButton rdbtnRollCustom = new JRadioButton("Custom Value");
		rdbtnRollCustom.setBounds(303, 223, 109, 23);
		contentPane.add(rdbtnRollCustom);
		diceTypes.add(rdbtnRollCustom);
		
		JRadioButton rdbtnRoll20 = new JRadioButton("20");
		rdbtnRoll20.setBounds(303, 171, 109, 23);
		contentPane.add(rdbtnRoll20);
		diceTypes.add(rdbtnRoll20);
		
		JRadioButton rdbtnRoll12 = new JRadioButton("12");
		rdbtnRoll12.setBounds(303, 145, 109, 23);
		contentPane.add(rdbtnRoll12);
		diceTypes.add(rdbtnRoll12);
		
		JRadioButton rdbtnRoll10 = new JRadioButton("10");
		rdbtnRoll10.setBounds(303, 119, 109, 23);
		contentPane.add(rdbtnRoll10);
		diceTypes.add(rdbtnRoll10);
		
		JRadioButton rdbtnRoll8 = new JRadioButton("8");
		rdbtnRoll8.setBounds(303, 93, 109, 23);
		contentPane.add(rdbtnRoll8);
		diceTypes.add(rdbtnRoll8);
		
		JRadioButton rdbtnRoll6 = new JRadioButton("6");
		rdbtnRoll6.setBounds(303, 67, 109, 23);
		contentPane.add(rdbtnRoll6);
		diceTypes.add(rdbtnRoll6);
		
		JRadioButton rdbtnRoll4 = new JRadioButton("4");
		rdbtnRoll4.setBounds(303, 41, 109, 23);
		contentPane.add(rdbtnRoll4);
		diceTypes.add(rdbtnRoll4);
		
		JRadioButton rdbtnRoll100 = new JRadioButton("100");
		rdbtnRoll100.setBounds(303, 197, 109, 23);
		contentPane.add(rdbtnRoll100);
		diceTypes.add(rdbtnRoll100);
		
		JLabel lblTitleDiceType = new JLabel("Dice Type");
		lblTitleDiceType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleDiceType.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitleDiceType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitleDiceType.setBounds(298, 11, 94, 23);
		contentPane.add(lblTitleDiceType);
		
		lblRoll = new JLabel("0");
		lblRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoll.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblRoll.setBounds(20, 71, 156, 98);
		contentPane.add(lblRoll);
		
		prevRolls = new JTextArea();
		prevRolls.setBackground(SystemColor.menu);
		prevRolls.setBounds(589, 24, 45, 237);
		prevRolls.setEditable(false);
		contentPane.add(prevRolls);
		
		JLabel lblPrevRolls = new JLabel("Previous Rolls");
		lblPrevRolls.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrevRolls.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrevRolls.setBounds(458, 0, 166, 20);
		contentPane.add(lblPrevRolls);
		
		prevRollTypes = new JTextArea();
		prevRollTypes.setBackground(SystemColor.menu);
		prevRollTypes.setEditable(false);
		prevRollTypes.setBounds(550, 24, 36, 237);
		//prevRollTypes.setOpaque(false);
		contentPane.add(prevRollTypes);
		
	}
	public void rollDice()
	{
		String txt = "";
		for (Enumeration<AbstractButton> buttons = diceTypes.getElements(); buttons.hasMoreElements();)
		{
			 AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) 
	            {
	                txt =  button.getText();
	                break;
	            }
		}
	     		
		System.out.println(txt);
		if (txt.equals("Custom Value"))
		{
			txt = spinner.getValue().toString();
		}
		int diceType = Integer.parseInt(txt);
		
		int result = (int)(Math.random() * diceType + 1);
		
		lblRoll.setText(Integer.toString(result));
		
		String prevText = prevRolls.getText();
		prevText = result + "\n" + prevText;
		prevRolls.setText(prevText);
		
		String prevRollType = prevRollTypes.getText();
		prevRollType = "D" + diceType + "\n" + prevRollType;
		prevRollTypes.setText(prevRollType);
		
			
	}
}
