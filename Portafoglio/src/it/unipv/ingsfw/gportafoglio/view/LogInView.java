package it.unipv.ingsfw.gportafoglio.view;

import java.awt.HeadlessException;

import javax.swing.*;
import java.awt.*;

public class LogInView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean unlocked;
	private JTextField usr;
	private JPasswordField psw;
	private JButton loginButton;
    private JButton resetButton;
	
	public LogInView() throws HeadlessException {
		super();
		this.unlocked = false;
		initComponents();
	}

	public LogInView(String title) throws HeadlessException {
		super(title);
		this.unlocked = false;
		initComponents();
	}

	private void initComponents() {
		
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		//JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("\"C:\\Users\\migue\\OneDrive\\Desktop\\SecShield.png\"")));
		loginButton=new JButton("Login");
	    resetButton=new JButton("Svuota");
		
		Container mainPane = getContentPane();
		mainPane.setLayout(null);
//		mainPane.setBorder(BorderFactory.createLineBorder(Color.decode("#4f4f4f"), ABORT));
		usr = new JTextField();
		usr.setBounds(170,180,150,30);
		psw = new JPasswordField();
		psw.setBounds(170,250,150,30);
		userLabel.setBounds(70,180,100,30);
	    passwordLabel.setBounds(70,250,100,30);
	  //  iconLabel.setBounds(0,0, 402, 170);
	  //  iconLabel.setBorder(BorderFactory.createBevelBorder(2));
	    loginButton.setBounds(220,300,100,30);
	    resetButton.setBounds(70,300,100,30);
	    loginButton.setSelected(true);
	    
	   // mainPane.add(iconLabel);
	    mainPane.add(usr);
	    mainPane.add(psw);
	    mainPane.add(userLabel);
	    mainPane.add(passwordLabel);
	    mainPane.add(loginButton);
	    mainPane.add(resetButton);
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width; 
		setSize(screenWidth/4,2*screenHeight/5); 
		this.setBounds(10,10,402,400);
		setLocation(screenWidth/2-185,screenHeight/2-220);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public JTextField getUsr() {
		return usr;
	}

	public JPasswordField getPsw() {
		return psw;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	
	
}
