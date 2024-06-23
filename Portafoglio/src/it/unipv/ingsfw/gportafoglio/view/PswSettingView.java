package it.unipv.ingsfw.gportafoglio.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PswSettingView extends JFrame{

	private static final long serialVersionUID = 1L;
	private boolean login;
	private JTextField usr;
	private JTextField psw;
	private JTextField psw2;
	private JButton confirmButton;
	private JButton switchViewButton;
	
	public PswSettingView() throws HeadlessException {
		super();
		this.login = false;
		initComponents();
	}

	public PswSettingView(String title) throws HeadlessException {
		super(title);
		this.login = false;
		initComponents();
	}

	private void initComponents() {
		
		
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		JLabel repeatPswLabel = new JLabel("Ripeti");
		confirmButton=new JButton("Conferma");
		switchViewButton = new JButton("Login");
		
		Container mainPane = getContentPane();
		mainPane.setLayout(null);
//		mainPane.setBorder(BorderFactory.createLineBorder(Color.decode("#4f4f4f"), ABORT));
		usr = new JTextField();
		usr.setBounds(150,80,150,30);
		psw = new JTextField();
		psw.setBounds(150,150,150,30);
		psw2 = new JTextField();
		psw2.setBounds(150, 220, 150, 30);
		userLabel.setBounds(50,80,100,30);
	    passwordLabel.setBounds(50,150,100,30);
	    repeatPswLabel.setBounds(50, 220, 100, 30);
	    confirmButton.setBounds(50,290,100,30);
	    switchViewButton.setBounds(50,360,100,30);
	    confirmButton.setSelected(true);
		
	    mainPane.add(usr);
	    mainPane.add(psw);
	    mainPane.add(psw2);
	    mainPane.add(userLabel);
	    mainPane.add(passwordLabel);
	    mainPane.add(repeatPswLabel);
	    mainPane.add(confirmButton);
	    mainPane.add(switchViewButton);
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width; 
//		setSize(screenWidth/4,2*screenHeight/5); 
		this.setBounds(10,10,370,440);
		setLocation(screenWidth/4,screenHeight/4);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}

	public boolean isAlreadyLogged() {
		return login;
	}

	public void setAlreadyLogged(boolean unlocked) {
		this.login = unlocked;
	}

	public JTextField getUsr() {
		return usr;
	}

	public JTextField getPsw() {
		return psw;
	}
	
	public JTextField getPsw2() {
		return psw2;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}
	public JButton getSwitchViewButton() {
		return switchViewButton;
	}
}
