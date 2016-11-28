package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CaloriesAllDay extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel glassLB ,allCal;
	private int totalCal, calBreakfast, calLunch, calDinner;
	private String user;
	private double numBMR;
	private JButton breakfast,lunch,dinner;
	private AuthenticationController a;

	public CaloriesAllDay(String user, double numBMR) {
		try {
			a = new AuthenticationController();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// information
		totalCal = 0;
		this.numBMR = numBMR;
		this.user = user;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.DARK_GRAY);

		// Title
		JLabel titleApp = new JLabel("RACKON CALORIES :" + user, JLabel.CENTER);
		titleApp.setForeground(Color.WHITE);
		titleApp.setBackground(Color.BLACK);
		titleApp.setOpaque(true);
		Font title = new Font("Calibri", Font.BOLD, 18);
		Font font = new Font("Calibri", Font.PLAIN, 18);
		titleApp.setFont(title);

		// Total
		Font totalFont = new Font("Calibri", Font.PLAIN, 25);
		JPanel totalPanel = new JPanel(new BorderLayout());
		JPanel totalNumCal = new JPanel(new GridLayout(2, 0));
		totalPanel.setBackground(Color.DARK_GRAY);
		totalNumCal.setBackground(Color.DARK_GRAY);
		ImageIcon food = new ImageIcon("pic/FoodTotal.png");
		food.setImage(food.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel iconPic = new JLabel(food);
		JLabel totalLB = new JLabel("Total :");
		allCal = new JLabel("     " + totalCal + " KCal.");
		totalLB.setForeground(Color.white);
		allCal.setForeground(Color.WHITE);
		totalLB.setFont(totalFont);
		allCal.setFont(totalFont);
		totalNumCal.add(totalLB);
		totalNumCal.add(allCal);
		totalPanel.add(iconPic, BorderLayout.WEST);
		totalPanel.add(totalNumCal, BorderLayout.CENTER);
		panel.add(totalPanel, BorderLayout.NORTH);

		// breakfast
		calBreakfast = 0;
		ImageIcon tab = new ImageIcon("pic/MealTab.png");
		breakfast = new JButton("BREAKFAST         " + calBreakfast + " kcal.");
		breakfast.setActionCommand("breakfast");
		breakfast.setIcon(tab);
		breakfast.setVerticalTextPosition(SwingConstants.CENTER);
		breakfast.setHorizontalTextPosition(SwingConstants.CENTER);
		breakfast.setFont(totalFont);
		breakfast.setContentAreaFilled(false);
		breakfast.setBorder(null);
		breakfast.setForeground(Color.WHITE);
		breakfast.setRolloverIcon(new ImageIcon("pic/MealTab2.png"));
		breakfast.setRolloverEnabled(true);
		breakfast.addActionListener(this);

		// lunch
		calLunch = 0;
		lunch = new JButton("LUNCH                " + calLunch + " kcal.");
		lunch.setActionCommand("lunch");
		lunch.setIcon(tab);
		lunch.setVerticalTextPosition(SwingConstants.CENTER);
		lunch.setHorizontalTextPosition(SwingConstants.CENTER);
		lunch.setFont(totalFont);
		lunch.setContentAreaFilled(false);
		lunch.setBorder(null);
		lunch.setForeground(Color.WHITE);
		lunch.setRolloverIcon(new ImageIcon("pic/MealTab2.png"));
		lunch.setRolloverEnabled(true);
		lunch.addActionListener(this);

		// dinner
		calDinner = 0;
		dinner = new JButton("DINNER               " + calDinner + " kcal.");
		dinner.setActionCommand("dinner");
		dinner.setIcon(tab);
		dinner.setVerticalTextPosition(SwingConstants.CENTER);
		dinner.setHorizontalTextPosition(SwingConstants.CENTER);
		dinner.setFont(totalFont);
		dinner.setContentAreaFilled(false);
		dinner.setBorder(null);
		dinner.setForeground(Color.WHITE);
		dinner.setRolloverIcon(new ImageIcon("pic/MealTab2.png"));
		dinner.setRolloverEnabled(true);
		dinner.addActionListener(this);

		// allMeal
		JPanel meal = new JPanel(new GridLayout(3, 0));
		meal.setBackground(Color.DARK_GRAY);
		meal.add(breakfast);
		meal.add(lunch);
		meal.add(dinner);
		panel.add(meal, BorderLayout.CENTER);

		// button reset and profile
		JPanel button = new JPanel();
		button.setBackground(Color.DARK_GRAY);
		ImageIcon resetImage = new ImageIcon("pic/Reset.png");
		ImageIcon profileImage = new ImageIcon("pic/Profile.png");
		JButton reset = new JButton(resetImage);
		reset.setBorder(null);
		reset.setContentAreaFilled(false);
		ImageIcon rShadow = new ImageIcon("pic/Reset2.png");
		reset.setRolloverIcon(rShadow);
		resetImage.setImage(resetImage.getImage().getScaledInstance(80, 28, Image.SCALE_DEFAULT));
		rShadow.setImage(rShadow.getImage().getScaledInstance(80, 28, Image.SCALE_DEFAULT));
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				calBreakfast = 0;
				calLunch = 0;
				calDinner = 0;
				resetCal();
			}

		});

		JButton profile = new JButton(profileImage);
		ImageIcon pShadow = new ImageIcon("pic/Profile2.png");
		profile.setRolloverIcon(pShadow);
		profile.setBorder(null);
		profile.setContentAreaFilled(false);
		profileImage.setImage(profileImage.getImage().getScaledInstance(80, 28, Image.SCALE_DEFAULT));
		pShadow.setImage(pShadow.getImage().getScaledInstance(80, 28, Image.SCALE_DEFAULT));
		button.add(reset);
		button.add(profile);
		profile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new InfoCalories(user);
			}

		});

		// bmr and buttons
		Font bmrFont = new Font("Calibri", Font.PLAIN, 25);
		JLabel bmr = new JLabel("BMR : " + numBMR + " KCal.");
		bmr.setFont(bmrFont);
		bmr.setForeground(Color.WHITE);
		bmr.setBackground(Color.DARK_GRAY);
		JPanel bb = new JPanel(new GridLayout(2, 0));
		bb.setBackground(Color.DARK_GRAY);
		bb.add(bmr);
		bb.add(button);

		// glass

		JPanel glass = new JPanel(new BorderLayout());
		glassLB = new JLabel();
		glass.setBackground(Color.DARK_GRAY);
		setGlass(numBMR / 4);
		glass.add(glassLB, BorderLayout.WEST);
		glass.add(bb, BorderLayout.CENTER);
		panel.add(glass, BorderLayout.SOUTH);

		setResizable(false);
		add(titleApp, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setTitle("Reckon Calories");
		setSize(317, 520);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void resetCal(){
		totalCal = calBreakfast+calLunch+calDinner;
		breakfast.setText("BREAKFAST                " + calBreakfast + " kcal.");
		lunch.setText("LUNCH                " + calLunch + " kcal.");
		dinner.setText("DINNER                " + calDinner + " kcal.");
		allCal.setText("     " + totalCal + " KCal.");
		setGlass(numBMR / 4);
		if(totalCal > numBMR){
			showMessage("Over Calories!!!");
			new Exercise(totalCal-numBMR);
		}
	}

	private void setGlass(double oneOfBMR) {

		if (totalCal == 0) {
			ImageIcon g = new ImageIcon("pic/Glass.png");
			g.setImage(g.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g);
		} else if (totalCal > 0 && totalCal <= oneOfBMR) {
			ImageIcon g2 = new ImageIcon("pic/Glass2.png");
			g2.setImage(g2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g2);
		} else if (totalCal > oneOfBMR && totalCal <= (oneOfBMR * 2)) {
			ImageIcon g3 = new ImageIcon("pic/Glass3.png");
			g3.setImage(g3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g3);
		} else if (totalCal > (oneOfBMR * 2) && totalCal <= (oneOfBMR * 3)) {
			ImageIcon g4 = new ImageIcon("pic/Glass4.png");
			g4.setImage(g4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g4);
		} else if (totalCal > (oneOfBMR * 3) && totalCal <= (oneOfBMR * 4)) {
			ImageIcon g5 = new ImageIcon("pic/Glass5.png");
			g5.setImage(g5.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g5);
		} else if (totalCal > (oneOfBMR * 4)) {
			ImageIcon g6 = new ImageIcon("pic/Glass6.png");
			g6.setImage(g6.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			glassLB.setIcon(g6);
		}
	}

	public static void main(String[] args) {
		new CaloriesAllDay("coldzify", 1250);

	}

	// SearchFood Class
	public class SearchFood extends JFrame {
		private JPanel panel,listPanel;
		private JTextField foodText;
		public ArrayList<JCheckBox> foodlist;
		private int mode;
		private Font font2,font;
		public static final int BREAKFAST = 1;
		public static final int LUNCH = 2;
		public static final int DINNER = 3;

		public SearchFood(int mode) {
			foodlist = new ArrayList<>();
			this.mode = mode;
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBackground(Color.DARK_GRAY);
			setResizable(false);

			// Title
			JLabel titleApp = new JLabel("RACKON CALORIES", JLabel.CENTER);
			titleApp.setForeground(Color.WHITE);
			titleApp.setBackground(Color.BLACK);
			titleApp.setOpaque(true);
			Font title = new Font("Calibri", Font.BOLD, 18);
			font = new Font("Calibri", Font.PLAIN, 18);
			font2 = new Font("MAX PINJOHNV2", Font.PLAIN, 16);
			titleApp.setFont(title);

			// search
			JPanel search = new JPanel();
			search.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			search.setBackground(Color.DARK_GRAY);
			foodText = new JTextField(17);
			ImageIcon searchImage = new ImageIcon("pic/Search.png");
			searchImage.setImage(searchImage.getImage().getScaledInstance(50, 20, Image.SCALE_DEFAULT));
			ImageIcon search2Image = new ImageIcon("pic/Search2.png");
			search2Image.setImage(search2Image.getImage().getScaledInstance(50, 20, Image.SCALE_DEFAULT));
			JButton searchBT = new JButton(searchImage);
			searchBT.setRolloverIcon(search2Image);
			searchBT.setBorder(null);
			searchBT.setContentAreaFilled(false);
			search.add(foodText);
			search.add(searchBT);
			
			searchBT.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String name = foodText.getText();
					try {
						String[][] s = a.searchMenuList(name);
						if(s[0][0] != null)
							genMenu(s);
						else
							showMessage("no result of \""+foodText.getText()+"\"");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			});
			
			panel.add(search, BorderLayout.NORTH);
			
			// MenuLists
			listPanel = new JPanel();
			BoxLayout box = new BoxLayout(listPanel,BoxLayout.Y_AXIS);
			listPanel.setLayout(box);
			listPanel.setBackground(Color.DARK_GRAY);
			//listPanel.setPreferredSize(new Dimension(280,300));
			JScrollPane scroll = new JScrollPane(listPanel);
			scroll.setPreferredSize(new Dimension(280,300));
			try {
				String[][] menuList = a.getMenu();
				genMenu(menuList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			panel.add(scroll);

			// OK
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(Color.DARK_GRAY);
			JButton okBtn = new JButton();
			ImageIcon okIcon = new ImageIcon("pic/Ok.png");
			okBtn.setIcon(okIcon);
			okBtn.setBorder(null);
			okBtn.setContentAreaFilled(false);
			ImageIcon okOver = new ImageIcon("pic/Ok2.png");
			okBtn.setRolloverIcon(okOver);
			btnPanel.add(okBtn);
			//panel.add(btnPanel, BorderLayout.SOUTH);

			okBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int totalCal = 0;
					for (JCheckBox ch : foodlist) {
						if (ch.isSelected()) {
							int cal = Integer.valueOf(ch.getActionCommand());
							totalCal += cal;
						}
					}
					if (mode == SearchFood.BREAKFAST) {
						calBreakfast += totalCal;
					} else if (mode == SearchFood.LUNCH) {
						calLunch += totalCal;
					} else {
						calDinner += totalCal;
					}
					resetCal();
					dispose();
				}

			});
			//Event of foodText
			foodText.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					String[][] menuList;
					if(foodText.getText().equals("")){
						try {
							menuList = a.getMenu();
							genMenu(menuList);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
							menuList = a.searchMenuList(foodText.getText());
							genMenu(menuList);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			add(titleApp, BorderLayout.NORTH);
			add(panel, BorderLayout.CENTER);
			add(btnPanel,BorderLayout.SOUTH);
			setTitle("Reckon Calories");
			setSize(280, 400);
			//pack();
			setVisible(true);
			// setDefaultCloseOperation(EXIT_ON_CLOSE);

		}
		public void genMenu(String[][] menuList){
			listPanel.removeAll();
			for (int i = 0; i < menuList.length; i++) {
				String name = "", cal = "";
				if (menuList[i][0] != null) {
					name = menuList[i][0];
					cal = menuList[i][1];
					JCheckBox c = new JCheckBox(name + " 1 หน่วย");
					JLabel l = new JLabel(cal + " kcal", JLabel.LEFT);
					l.setBackground(Color.DARK_GRAY);
					l.setFont(font2);
					l.setForeground(Color.WHITE);
					c.setBackground(Color.DARK_GRAY);
					c.setFont(font2);
					c.setForeground(Color.WHITE);
					JPanel p = new JPanel();
					BoxLayout b = new BoxLayout(p,BoxLayout.LINE_AXIS);
					p.setAlignmentX(Component.LEFT_ALIGNMENT);
					p.setLayout(b);
					p.setBackground(Color.DARK_GRAY);
					p.add(c);
					p.add(l,BorderLayout.EAST);
					listPanel.add(p);
					//listPanel.add(l);
					c.setActionCommand(cal);
					foodlist.add(c);
				}

			}
			listPanel.repaint();
			validate();
		}
		private void showMessage(String mes){
			JOptionPane.showMessageDialog(this, mes);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton a = (JButton) e.getSource();
			if (a.getActionCommand().equals("breakfast")) {
				new SearchFood(SearchFood.BREAKFAST);
			} else if (a.getActionCommand().equals("lunch")) {
				new SearchFood(SearchFood.LUNCH);
			} else if (a.getActionCommand().equals("dinner")) {
				new SearchFood(SearchFood.DINNER);
			}
		}

	}
	private void showMessage(String mes){
		JOptionPane.showMessageDialog(this, mes);
	}
}
