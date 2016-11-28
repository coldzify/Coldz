package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputFrame extends JFrame {
	private JPanel panel;
	private JLabel gender, age, weight, height,pass,user;
	private JRadioButton male, female;
	private JTextField ageText, weightText, heightText,userText;
	private ButtonGroup group;
	private JButton submitBtn,backBtn;
	private AuthenticationController con;
	private JPasswordField passText;
	private String username;
	public InputFrame(String username) {
		try{
			con = new AuthenticationController();
		}
		catch(SQLException e){
			showMessage(e.getMessage());
			System.exit(0);
		}
		this.username = username;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.DARK_GRAY);
		// Title
		JLabel titleApp = new JLabel("RECKON CALORIES", JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri", Font.BOLD, 18);
		Font font = new Font("Calibri", Font.PLAIN, 18);
		titleApp.setFont(title);
		// User
		JPanel userPanel = new JPanel();
		user = new JLabel("Username: ");
		userText = new JTextField(8);
		user.setForeground(Color.WHITE);
		user.setFont(font);
		userPanel.setBackground(Color.DARK_GRAY);
		userPanel.add(user);
		userPanel.add(userText);
		if(username == null)
		panel.add(userPanel);

		// Pass
		JPanel passPanel = new JPanel();
		pass = new JLabel("Password: ");
		JPasswordField passText = new JPasswordField(8);
		pass.setForeground(Color.WHITE);
		pass.setFont(font);
		passPanel.setBackground(Color.DARK_GRAY);
		passPanel.add(pass);
		passPanel.add(passText);
		if(username == null)
		panel.add(passPanel);

		// Gender
		JPanel gPanel = new JPanel();
		gender = new JLabel("Gender: ");
		gender.setForeground(Color.WHITE);
		gender.setFont(font);
		gPanel.setBackground(Color.DARK_GRAY);
		male = new JRadioButton("Male");
		male.setFont(font);
		female = new JRadioButton("Female");
		female.setFont(font);
		male.setForeground(Color.WHITE);
		female.setForeground(Color.WHITE);
		male.setBackground(Color.DARK_GRAY);
		female.setBackground(Color.DARK_GRAY);
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		male.setSelected(true);
		gPanel.add(gender);
		gPanel.add(male);
		gPanel.add(female);

		panel.add(gPanel);

		// age

		JPanel agePanel = new JPanel();
		JLabel agelabel = new JLabel("Age : ");
		agelabel.setFont(font);
		ageText = new JTextField(5);
		JLabel yearlabel = new JLabel("years");
		yearlabel.setFont(font);
		agelabel.setForeground(Color.WHITE);
		yearlabel.setForeground(Color.WHITE);
		agePanel.add(agelabel);
		agePanel.add(ageText);
		agePanel.add(yearlabel);
		agePanel.setBackground(Color.DARK_GRAY);
		panel.add(agePanel);

		// weight
		JPanel weightPanel = new JPanel();
		JLabel weightlabel = new JLabel("Weight : ");
		weightlabel.setFont(font);
		weightText = new JTextField(5);
		JLabel kglabel = new JLabel("kg.");
		kglabel.setFont(font);
		weightlabel.setForeground(Color.WHITE);
		kglabel.setForeground(Color.WHITE);
		weightPanel.add(weightlabel);
		weightPanel.add(weightText);
		weightPanel.add(kglabel);
		weightPanel.setBackground(Color.DARK_GRAY);
		panel.add(weightPanel);

		// height
		JPanel heightPanel = new JPanel();
		JLabel heightlabel = new JLabel("Height : ");
		heightlabel.setFont(font);
		heightText = new JTextField(5);
		JLabel cmlabel = new JLabel("cm.");
		cmlabel.setFont(font);
		heightlabel.setForeground(Color.WHITE);
		cmlabel.setForeground(Color.WHITE);
		heightPanel.add(heightlabel);
		heightPanel.add(heightText);
		heightPanel.add(cmlabel);
		heightPanel.setBackground(Color.DARK_GRAY);
		panel.add(heightPanel);

		JPanel btn = new JPanel();
		btn.setBackground(Color.DARK_GRAY);
		btn.setOpaque(true);
		backBtn = new JButton(new ImageIcon("pic/Back.png"));
		backBtn.setBorder(null);
		backBtn.setContentAreaFilled(false);
		backBtn.setRolloverIcon(new ImageIcon("pic/Back2.png"));
		backBtn.setRolloverEnabled(true);
		backBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				con.close();
				new LoginPage();
			}
			
		});
		
		ImageIcon submitPic = new ImageIcon("pic/Submit.png");
		submitBtn = new JButton();
		submitBtn.setIcon(submitPic);
		submitBtn.setBorder(null);
		submitBtn.setContentAreaFilled(false);
		submitBtn.setRolloverIcon(new ImageIcon("pic/Submit2.png"));
		submitBtn.setRolloverEnabled(true);
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(username != null)
					insert();
				else
					update();
			}

		});
		btn.add(backBtn);
		btn.add(submitBtn);
		panel.add(btn);

		add(titleApp, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setTitle("Reckon Calories");
		setSize(300, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void insert(){
		if(userText.getText().length() < 4)
			showMessage("Enter Username at least 4 !");
		else if(passText.getText().length() < 4) 
			showMessage("Enter Password at least 4 !");
		else if(ageText.getText().length() == 0) 
			showMessage("Enter Age !");
		else if(weightText.getText().length() == 0) 
			showMessage("Enter Weight !");
		else if(heightText.getText().length() == 0) 
			showMessage("Enter Height !");
		else{
			try{
				int age = Integer.valueOf(ageText.getText());
				int weight = Integer.valueOf(weightText.getText());
				int height = Integer.valueOf(heightText.getText());
				String gender;
				if(male.isSelected())
					gender = "MALE";
				else
					gender = "FEMALE";
				try{
					if(con.insert(userText.getText(), passText.getText(), gender, age, weight, height)){
						showMessage("Success");
						con.close();
						dispose();
						new LoginPage();
					}
					else{
						showMessage("Fail");
					}
				}
				catch(SQLException e){
					showMessage(e.getMessage());
				}
			}
			catch(NumberFormatException e){
				showMessage("Data Error !");
			}
		}
	}
	private void update(){
		if(ageText.getText().length() == 0) 
			showMessage("Enter Age !");
		else if(weightText.getText().length() == 0) 
			showMessage("Enter Weight !");
		else if(heightText.getText().length() == 0) 
			showMessage("Enter Height !");
		else{
			try{
				int age = Integer.valueOf(ageText.getText());
				int weight = Integer.valueOf(weightText.getText());
				int height = Integer.valueOf(heightText.getText());
				String gender;
				if(male.isSelected())
					gender = "MALE";
				else
					gender = "FEMALE";
				try{
					if(con.update(username,gender, age, weight, height)){
						showMessage("Success");
						con.close();
						dispose();
						new InfoCalories(username);
					}
					else{
						showMessage("Fail");
					}
				}
				catch(SQLException e){
					showMessage(e.getMessage());
				}
			}
			catch(NumberFormatException e){
				showMessage("Data Error !");
			}
		}
	}
	private void showMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	public static void main(String[] aa){
		new InputFrame("1111");
	}
}