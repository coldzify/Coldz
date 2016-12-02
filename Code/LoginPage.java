package Code;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.BorderStroke;



public class LoginPage extends JFrame implements ActionListener{
	private AuthenticationController con;
	private JPanel panel;
	private JLabel user;
	private JLabel pass;
	private JTextField userBox;
	private JPasswordField passBox;
	private JButton loginBtn;
	private JButton signUpBtn;
	private ImageIcon logo;
	public LoginPage() {
		try{
			con = new AuthenticationController();
		}
		catch(SQLException e){
			showMessage(e.getMessage());
			System.exit(0);
		}
		
		//Title
		
		JLabel titleApp = new JLabel("RECKON CALORIES",JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri",Font.BOLD,18);
		Font font = new Font("Calibri",Font.PLAIN,18);
		titleApp.setFont(title);
		//User
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JPanel uPanel = new JPanel();
		uPanel.setBackground(Color.DARK_GRAY);
		uPanel.setOpaque(true);
		user = new JLabel("User : ");
		user.setForeground(Color.WHITE);
		user.setFont(font);
		userBox = new JTextField(10);
		uPanel.add(user);
		uPanel.add(userBox);
		//Pass
		JPanel pPanel = new JPanel();
		pPanel.setBackground(Color.DARK_GRAY);
		pPanel.setOpaque(true);
		pass = new JLabel("Password : ");
		pass.setForeground(Color.WHITE);
		pass.setFont(font);
		passBox = new JPasswordField(10);
		pPanel.add(pass);
		pPanel.add(passBox);
		//Login & Signup
		JPanel btn = new JPanel();
		btn.setBackground(Color.DARK_GRAY);
		btn.setOpaque(true);
		ImageIcon loginPic = new ImageIcon("pic/LoginButton.png"); 
		ImageIcon signPic = new ImageIcon("pic/SignUpButton.png");
		loginBtn = new JButton();
		loginBtn.setIcon(loginPic);
		loginBtn.setBorder(null);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setRolloverIcon(new ImageIcon("pic/LoginButton2.png"));
		loginBtn.setRolloverEnabled(true);
		loginBtn.addActionListener(this);
		
		userBox.addActionListener(this);
		passBox.addActionListener(this);
		
		signUpBtn = new JButton();
		signUpBtn.setFont(font);
		signUpBtn.setBorder(null);
		signUpBtn.setIcon(signPic);
		signUpBtn.setContentAreaFilled(false);
		signUpBtn.setRolloverIcon(new ImageIcon("pic/SignUpButton2.png"));
		signUpBtn.setRolloverEnabled(true);
		signUpBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				con.close();
				dispose();
				new InputFrame(null);
			}
			
		});
		btn.add(loginBtn);
		btn.add(signUpBtn);
		//LogoApp
		logo = new ImageIcon("pic/Logo.png");
		JLabel logoLb = new JLabel();
		logoLb.setIcon(logo);
		logoLb.setAlignmentX(logoLb.CENTER_ALIGNMENT);
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setOpaque(true);
		panel.add(logoLb);
		panel.add(uPanel);
		panel.add(pPanel);
		panel.add(btn);
		
		
		setLocationRelativeTo(null);
		add(titleApp,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setResizable(false);
		setTitle("Reckon Calories");
		setSize(300,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void showMessage(String s){
		JOptionPane.showMessageDialog(this, s);
	}
	private void login(){
		try {
			if(con.login(userBox.getText(), passBox.getText())){
				showMessage("Login Success");
				dispose();
				new InfoCalories(userBox.getText());
			}
			else{
				showMessage("Username or password is incorrect.");
			}
			
		} catch (Exception e) {
			showMessage(e.getMessage());
		}
	}
	public static void main(String[] args) {
		new LoginPage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		login();
		
	}
	
}
