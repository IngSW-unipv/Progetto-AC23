package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.view.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;
import it.unipv.ingsfw.gportafoglio.dao.*;
import it.unipv.ingsfw.gportafoglio.service.DbController;

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
				
				String username = view.getUsr().getText();
				String password = view.getPsw().getText();
				
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),"La password e il nome utente non possono essere vuoti", null, JOptionPane.ERROR_MESSAGE);
				}
				else if(!view.getPsw2().getText().equals(password)) {
					JOptionPane.showMessageDialog(new JFrame(),"Le password non corrispondono", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
						DbController connection = new DbController();
						PortafoglioDAOImpl daoI = PortafoglioDAOImpl.getInstance(connection.getConnection());
						daoI.createPortafoglio(username, password);
			        }
					view.setAlreadyLogged(true);
					view.dispose();
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
		
		ActionListener switchListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
//					JOptionPane.showInputDialog(new JFrame(), "inserisci importo", null, JOptionPane.QUESTION_MESSAGE);
					view.setAlreadyLogged(true);
					view.dispose();
			}
			
		};
		view.getSwitchViewButton().addActionListener(switchListener);
	}	
	
}
