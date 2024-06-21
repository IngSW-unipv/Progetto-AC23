package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.view.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetLoginController {

	private PswSettingView view;
	
	public SetLoginController(PswSettingView view) {
		this.view = view;
		addListeners();
	}
	
	private void addListeners() {
		
		ActionListener confirmListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usr = view.getUsr().getText();
				String psw = view.getPsw().getText();
				
				if(usr.equals("") || psw.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),"La password e il nome utente non possono essere vuoti", null, JOptionPane.ERROR_MESSAGE);
				}
				else if(!view.getPsw2().getText().equals(psw)) {
					JOptionPane.showMessageDialog(new JFrame(),"Le password non corrispondono", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					try (OutputStream output = new FileOutputStream(".properties/psw.properties")) {

			            Properties prop = new Properties();

			            prop.setProperty("usr", ((Integer)usr.hashCode()).toString());
			            prop.setProperty("psw", ((Integer)psw.hashCode()).toString());

			            prop.store(output, null);

			            System.out.println(prop);

			        } catch (IOException io) {
			            io.printStackTrace();
			        }
					view.dispose();
				}
			}
		};
		view.getConfirmButton().addActionListener(confirmListener);
		
		KeyListener enterLoginListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					view.getConfirmButton().doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		view.getPsw2().addKeyListener(enterLoginListener);
		
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
		
		KeyListener enterPsw1Listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					view.getPsw().setEnabled(false);
					view.getPsw().setEnabled(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		view.getPsw().addKeyListener(enterPsw1Listener);
	}
}
