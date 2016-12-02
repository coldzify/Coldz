package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InfoCalories extends JFrame{

	private Calculate cal;
	private JPanel panel;
	private JLabel gender,age,weight,height,bmi;
	private String genderSt;
	private int numAge;
	private double numWeight,numHeight,numBMI; 
	private JButton edit,submit;
	private AuthenticationController con;
	private String user;
	public InfoCalories(String user) {
		try{
			con = new AuthenticationController();
		}
		catch(SQLException e){
			showMessage(e.getMessage());
			System.exit(0);
		}
		this.user = user;
		String[] info = null;
		try {
			info = con.getInfo(user);
		} catch (Exception e) {
			showMessage(e.getMessage());
		}
		
		//information
		genderSt = info[0];
		numAge = Integer.valueOf(info[1]);
		numWeight = Integer.valueOf(info[2]);
		numHeight = Integer.valueOf(info[3]);
		cal = new Calculate();
		numBMI = cal.getBMI(numHeight, numWeight);
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.DARK_GRAY);
		
		//Title
		JLabel titleApp = new JLabel("RECKON CALORIES :"+user,JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri",Font.BOLD,18);
		Font font = new Font("Calibri",Font.PLAIN,18);
		titleApp.setFont(title);
		
		//Edit
		JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		editPanel.setBackground(Color.DARK_GRAY);
		editPanel.setOpaque(true);
		ImageIcon editIcon = new ImageIcon("pic/Edit.png");
		editIcon.setImage(editIcon.getImage().getScaledInstance(50	, 20, Image.SCALE_DEFAULT));
		ImageIcon editDarkIcon = new ImageIcon("pic/Edit2.png");
		editDarkIcon.setImage(editDarkIcon.getImage().getScaledInstance(50	, 20, Image.SCALE_DEFAULT));
		edit = new JButton();
		edit.setIcon(editIcon);
		edit.setFont(font);
		edit.setBorder(null);
		edit.setContentAreaFilled(false);
		edit.setRolloverIcon(editDarkIcon);
		edit.setRolloverEnabled(true);
		editPanel.add(edit);
		panel.add(editPanel);
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showConfirmDialog("Edit ?");
				dispose();
				new InputFrame(user);
			}
			
		});
		
		//Gender
		JPanel gPanel = new JPanel();
		gender = new JLabel("        Gender:        "+ genderSt);
		gender.setFont(font);
		gender.setForeground(Color.WHITE);
		gPanel.setBackground(Color.DARK_GRAY);
		gPanel.add(gender);	
		panel.add(gPanel);
			
		//age
		JPanel agePanel = new JPanel();
		JLabel agelabel = new JLabel("        Age :              "+numAge+"                 years");
		agelabel.setFont(font);
		agelabel.setForeground(Color.WHITE);
		agePanel.add(agelabel);
		agePanel.setBackground(Color.DARK_GRAY);
		panel.add(agePanel);

		//weight
		JPanel weightPanel = new JPanel();
		JLabel weightlabel = new JLabel("        Weight :        "+numWeight+"              kg.");
		weightlabel.setFont(font);
		weightlabel.setForeground(Color.WHITE);
		weightPanel.add(weightlabel);
		weightPanel.setBackground(Color.DARK_GRAY);
		panel.add(weightPanel);

		//height
		JPanel heightPanel = new JPanel();
		JLabel heightlabel = new JLabel("        Height :         "+numHeight+"            cm.");
		heightlabel.setFont(font);
		heightlabel.setForeground(Color.WHITE);
		heightPanel.add(heightlabel);
		heightPanel.setBackground(Color.DARK_GRAY);
		panel.add(heightPanel);
		
		//bmi
		JPanel bmiPanel = new JPanel();
		DecimalFormat df = new DecimalFormat("0.00");
		bmi = new JLabel("        BMI :             "+df.format(numBMI));
		bmi.setFont(font);	
		bmi.setForeground(Color.WHITE);
		bmiPanel.add(bmi);
		bmiPanel.setBackground(Color.DARK_GRAY);
		panel.add(bmiPanel);
				
		//Status Text
		JPanel textStatus = new JPanel();
		textStatus.setBackground(Color.DARK_GRAY);
		ImageIcon thin = new ImageIcon("pic/I.png");
		ImageIcon med = new ImageIcon("pic/U.png");
		ImageIcon fat = new ImageIcon("pic/O.png");
		
		JLabel text = new JLabel();
		if(numBMI<18.50){
			text.setIcon(thin);
		}
		else if(numBMI>=18.50 && numBMI<=22.90){
			text.setIcon(med);
		}
		else if(numBMI>22.90){
			text.setIcon(fat);
		}
		//text.setIcon(thin);//ทำให้รับค่าคำนวน BMI มาแล้ว เลือกว่าจะแสดงว่า ผอม สมส่วน หรือ อ้วน
		textStatus.add(text);
		panel.add(textStatus);
				
				
				

		//Status Icon
		JPanel statusPn = new JPanel();
		statusPn.setLayout(new FlowLayout(FlowLayout.CENTER));
		statusPn.setBackground(Color.DARK_GRAY);
		statusPn.setAlignmentX(CENTER_ALIGNMENT);
		ImageIcon thinIcon = new ImageIcon("pic/Thin.png");
		ImageIcon medIcon = new ImageIcon("pic/Medium.png");
		ImageIcon fatIcon = new ImageIcon("pic/Fat.png");
		ImageIcon thinLightIcon = new ImageIcon("pic/ChooseThin.png");
		ImageIcon medLightIcon = new ImageIcon("pic/ChooseMedium.png");
		ImageIcon fatLightIcon = new ImageIcon("pic/ChooseFat.png");
		thinIcon.setImage(thinIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		medIcon.setImage(medIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		fatIcon.setImage(fatIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		thinLightIcon.setImage(thinLightIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		medLightIcon.setImage(medLightIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		fatLightIcon.setImage(fatLightIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel t = new JLabel();
		JLabel m = new JLabel();
		JLabel f = new JLabel();
		t.setIcon(thinIcon);
		m.setIcon(medIcon);
		f.setIcon(fatIcon);
		if(numBMI<18.50){
			t.setIcon(thinLightIcon);
		}
		else if(numBMI>=18.50 && numBMI<=22.90){	
			m.setIcon(medLightIcon);
		}
		else if(numBMI>22.90){
			f.setIcon(fatLightIcon);
		}
		statusPn.add(t);
		statusPn.add(m);
		statusPn.add(f);
		panel.add(statusPn,BorderLayout.CENTER);
		//submit
		JPanel btnP = new JPanel();
	    btnP.setBackground(Color.DARK_GRAY);
	    btnP.setOpaque(true);
	    
	    JButton logoutBtn = new JButton(new ImageIcon("pic/Logout.png"));
	    logoutBtn.setContentAreaFilled(false);
	    logoutBtn.setBorder(null);
	    logoutBtn.setRolloverIcon(new ImageIcon("pic/Logout2.png"));
	    logoutBtn.setRolloverEnabled(true);
	    logoutBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(showConfirmDialog("Logout ?") == JOptionPane.OK_OPTION){
				dispose();
				con.close();
				new LoginPage();
				}
			}
	    	
	    });
	    btnP.add(logoutBtn);
	    
	    ImageIcon menuPic = new ImageIcon("pic/MenuList.png");
	    JButton menuBtn = new JButton();
	    menuBtn.setBorder(null);
	    menuBtn.setIcon(menuPic);
	    menuBtn.setContentAreaFilled(false);
	    menuBtn.setRolloverIcon(new ImageIcon("pic/MenuList2.png"));
	    menuBtn.setRolloverEnabled(true);
	    btnP.add(menuBtn);
	    
	    menuBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double bmr = cal.getBMR(numAge, genderSt, numHeight, numWeight);
				dispose();
				new CaloriesAllDay(user,bmr);
			}
	    	
	    });
	    panel.add(btnP);
				
	    setLocationRelativeTo(null);
	    setResizable(false);
		add(titleApp,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setTitle("Reckon Calories");
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void showMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	private int showConfirmDialog(String s){
		return JOptionPane.showConfirmDialog(this, s, "Exit ?", JOptionPane.OK_CANCEL_OPTION);
	}
	
	public static void main(String[] aa){
		new InfoCalories("1111");
	}


}
