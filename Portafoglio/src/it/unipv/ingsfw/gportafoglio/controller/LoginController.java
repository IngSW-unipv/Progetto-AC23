package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.view.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LoginController {

	private LogInView view;
	
	public LoginController(LogInView view) {
		this.view = view;
		addListeners();
	}
 
	private void addListeners() {
		
		ActionListener loginListener = new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usr = "";								//TODO replace with db queries
				String psw = "";
				
			
				try (InputStream input = new FileInputStream(".properties/psw.properties")) {

		            Properties prop = new Properties();

		            prop.load(input);

		            usr = prop.getProperty("usr");
					psw = prop.getProperty("psw");

		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
				
				if( (view.getUsr().getText().hashCode()==Integer.parseInt(usr)) && (view.getPsw().getText().hashCode() == Integer.parseInt(psw))) {
					view.setUnlocked(true);
					view.dispose();
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"password o nome utente errato/i", null, JOptionPane.ERROR_MESSAGE);
				} 
			}
		};
		view.getLoginButton().addActionListener(loginListener);
		
		
		
		ActionListener clearListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getUsr().setText("");
				view.getPsw().setText("");
			}
		};
		view.getResetButton().addActionListener(clearListener);
		
		KeyListener enterLoginListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					view.getLoginButton().doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		view.getLoginButton().addKeyListener(enterLoginListener);
		view.getPsw().addKeyListener(enterLoginListener);
		
		KeyListener enterUserListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					view.getUsr().setEnabled(false);
					view.getUsr().setEnabled(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		view.getUsr().addKeyListener(enterUserListener);
	}
}
