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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exercise extends JFrame{
	private JPanel panel;
	private JPanel bigPanel;
	private Calculate cal;
	
	
	public Exercise(double overCalories){
		cal = new Calculate();
		bigPanel = new JPanel(new BorderLayout());
		
		panel = new JPanel(new GridLayout(3, 0));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.DARK_GRAY);
	
		//Title
		JLabel titleApp = new JLabel("RECKON CALORIES",JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri",Font.BOLD,18);
		Font font = new Font("Calibri",Font.PLAIN,18);
		titleApp.setFont(title);
		
		//font
		Font font2 = new Font("MAX PINJOHNV2",Font.BOLD,27);
		Font font3 = new Font("MAX PINJOHNV2",Font.BOLD,25);
		
		//วิธีเผาผลาญแคลอรี่ส่วนเกิน
		JPanel howToPanel = new JPanel();
		howToPanel.setBackground(Color.DARK_GRAY);
		JLabel howTo = new JLabel("วิธีเผาผลาญแคลอรี่ส่วนเกิน : "+(int)overCalories);
		howTo.setFont(font3);
		howTo.setForeground(Color.WHITE);
		howToPanel.add(howTo);
		bigPanel.add(howToPanel,BorderLayout.NORTH);
		
		//walk
		JPanel walkPanel = new JPanel(new FlowLayout());
		walkPanel.setBackground(Color.DARK_GRAY);
		ImageIcon walkIcon = new ImageIcon("pic/walking-icon-hi.png");
		walkIcon.setImage(walkIcon.getImage().getScaledInstance(walkIcon.getIconWidth()/9, walkIcon.getIconHeight()/9, Image.SCALE_DEFAULT));
		JLabel walkLB = new JLabel(walkIcon);
		JLabel walkText = new JLabel("    เดิน : "+cal.getWalkMinutes(overCalories)+" นาที");
		walkText.setFont(font2);
		walkText.setForeground(Color.WHITE);
		walkPanel.add(walkLB);
		walkPanel.add(walkText);
		panel.add(walkPanel);
		
		//run
		JPanel runPanel = new JPanel(new FlowLayout());
		runPanel.setBackground(Color.DARK_GRAY);
		ImageIcon runIcon = new ImageIcon("pic/running-icon-26711.png");
		runIcon.setImage(runIcon.getImage().getScaledInstance(runIcon.getIconWidth()/4-5, runIcon.getIconHeight()/4-5, Image.SCALE_DEFAULT));
		JLabel runLB = new JLabel(runIcon);
		JLabel runText = new JLabel("    วิ่ง : "+ cal.getRunMinutes(overCalories)+" นาที");
		runText.setFont(font2);
		runText.setForeground(Color.WHITE);
		runPanel.add(runLB);
		runPanel.add(runText);
		panel.add(runPanel);
		
		//ride a bicycle
		JPanel rideBPanel = new JPanel(new FlowLayout());
		rideBPanel.setBackground(Color.DARK_GRAY);
		ImageIcon rideBIcon = new ImageIcon("pic/09-512.png");
		rideBIcon.setImage(rideBIcon.getImage().getScaledInstance(rideBIcon.getIconWidth()/7, rideBIcon.getIconHeight()/7, Image.SCALE_DEFAULT));
		JLabel rideBLB = new JLabel(rideBIcon);
		JLabel rideBText = new JLabel("ปั่นจักรยาน : "+ cal.getSwimMinutes(overCalories)+" นาที");
		rideBText.setFont(font2);
		rideBText.setForeground(Color.WHITE);
		rideBPanel.add(rideBLB);
		rideBPanel.add(rideBText);
		panel.add(rideBPanel);
		
		
		ImageIcon resetImage = new ImageIcon("pic/Reset.png");
		ImageIcon profileImage = new ImageIcon("pic/Profile.png");	
		JButton reset = new JButton(resetImage);
		reset.setBorder(null);
		reset.setContentAreaFilled(false);
		ImageIcon rShadow = new ImageIcon("pic/Reset2.png");
		reset.setRolloverIcon(rShadow);
		resetImage.setImage(resetImage.getImage().getScaledInstance(80,28, Image.SCALE_DEFAULT));
		rShadow.setImage(rShadow.getImage().getScaledInstance(80,28, Image.SCALE_DEFAULT));
		
		//button
		JPanel okPanel = new JPanel(new FlowLayout());
		okPanel.setBackground(Color.DARK_GRAY);
		ImageIcon okImage = new ImageIcon("pic/Ok.png");
		ImageIcon okDarkImage = new ImageIcon("pic/Ok2.png");
		JButton okBT = new JButton(okImage);
		okBT.setBorder(null);
		okBT.setContentAreaFilled(false);
		okBT.setRolloverIcon(okDarkImage);
		okPanel.add(okBT);
		okBT.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		bigPanel.add(okPanel , BorderLayout.SOUTH);
		
		bigPanel.add(panel,BorderLayout.CENTER);
		
		add(titleApp,BorderLayout.NORTH);
		add(bigPanel,BorderLayout.CENTER);
		setTitle("Reckon Calories");
		setSize(300,370);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
}

	public static void main(String[] args) {
		new Exercise(250.0);
	}
}