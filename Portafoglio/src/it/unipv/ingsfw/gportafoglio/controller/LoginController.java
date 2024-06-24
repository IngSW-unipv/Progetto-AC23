package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.dao.PortafoglioDAOImpl;
import it.unipv.ingsfw.gportafoglio.service.DbController;
import it.unipv.ingsfw.gportafoglio.service.GestionePortafoglio;
import it.unipv.ingsfw.gportafoglio.view.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LoginController {

	private LogInView view;
	private GestionePortafoglio model;
	
	public LogInView getView() {
		return view;
	}

	public GestionePortafoglio getModel() {
		return model;
	}

	public LoginController(LogInView view) {
		this.view = view;
		addListeners();
	}
 
	private void addListeners() {
		
		ActionListener loginListener = new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username = view.getUsr().getText();								//TODO replace with db queries
				int password = view.getPsw().getText().hashCode();
				System.out.println(""+password);
				
				DbController connection = new DbController();
				PortafoglioDAOImpl daoI = PortafoglioDAOImpl.getInstance(connection.getConnection());
				
				model = new GestionePortafoglio(username, "" + password, daoI);
				System.out.println(model.getUsername());
				if(model.getPortafoglio() != null) {
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
