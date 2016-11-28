package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFood extends JFrame{
	private JPanel panel;
	private JTextField foodText;
	private ArrayList<JButton> foodlist;
	
	public SearchFood(){
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.DARK_GRAY);
		setResizable(false);
		//Title
		JLabel titleApp = new JLabel("RECKON CALORIES",JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri",Font.BOLD,18);
		Font font = new Font("Calibri",Font.PLAIN,18);
		titleApp.setFont(title);
		
		//search
		JPanel search = new JPanel(new FlowLayout());
		search.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		search.setBackground(Color.DARK_GRAY);
		foodText = new JTextField(20);
		ImageIcon searchImage = new ImageIcon("pic/Search.png");
		searchImage.setImage(searchImage.getImage().getScaledInstance(50, 20, Image.SCALE_DEFAULT));
		ImageIcon search2Image = new ImageIcon("pic/Search2.png");
		search2Image.setImage(search2Image.getImage().getScaledInstance(50, 20, Image.SCALE_DEFAULT));
		JButton searchBT = new JButton(searchImage);
		searchBT.setRolloverIcon(search2Image);
		searchBT.setBorder(null);
		searchBT.setContentAreaFilled(false);
		search.add(foodText,BorderLayout.WEST);
		search.add(searchBT,BorderLayout.EAST);
		panel.add(search, BorderLayout.NORTH);
		
		
		
		add(titleApp,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setTitle("Reckon Calories");
		setSize(317,520);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SearchFood();
	}
}
