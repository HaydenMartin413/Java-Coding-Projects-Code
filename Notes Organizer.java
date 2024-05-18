import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	private JPanel contentPane;
	private DefaultMutableTreeNode top;
	private JTextField textField;

	public static void main(String[] args)
	{
		Window window = new Window("List.txt");
		window.setVisible(true);
	}
	
	public Window(String fileName) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loadReminders("Language Arts.txt");
		JTree tree = new JTree(top/*new DefaultMutableTreeNode("Reminders")loadReminders(fileName)*/);
		JScrollPane scroll = new JScrollPane (tree);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(680, 53, 18, 408);
		contentPane.add(scroll);
		tree.setBounds(10, 53, 684, 408);
		contentPane.add(tree);
		
		JLabel lblNewLabel = new JLabel("Notes Organizer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 200, 38);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
	
	public DefaultMutableTreeNode loadReminders(String fileName)
	{
		top = new DefaultMutableTreeNode("Notes");
		ArrayList<DefaultMutableTreeNode> nodeList = new ArrayList<DefaultMutableTreeNode>();
		nodeList.add(top);
		try
		{
			Scanner infile = new Scanner(new File (fileName));
			while (infile.hasNextLine())
			{
				String text = infile.nextLine();
				int index = 0;
				while (text.contains("\t"))
				{
					index++;
					text = text.substring(1);
				}
				DefaultMutableTreeNode temp = new DefaultMutableTreeNode(text);
				DefaultMutableTreeNode node = top;
					for (int i = 0; i < index; i++)
					{
						node = (DefaultMutableTreeNode)node.getLastChild();
					}
					node.add(temp);
			}
			return top;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}