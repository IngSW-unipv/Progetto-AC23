package it.unipv.ingsfw.gportafoglio.view;

import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton accreditaButton;
	private JButton spesaButton;
	private JButton stampaTransazioniButton;
	private JButton esciButton;
	
	private JTextArea logArea;
	private JLabel title;
	
	
	public MainFrame() throws HeadlessException {
		super();
		initComponents();
	}
 

	public void initComponents() {
		
						////////////////////
						//// LEFT PANE ////
						////////////////////
		
		JPanel rightPane = new JPanel();
		
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(BorderFactory.createMatteBorder(13, 5, 5, 5, new Color(70,130,180)));
		accreditaButton = new JButton("Accredita");
		spesaButton = new JButton("Aggiungi spesa");
		stampaTransazioniButton = new JButton("Stampa transazioni");
		logArea = new JTextArea();
		logArea.setEditable(false);
		esciButton = new JButton("Esci");

		
		accreditaButton.setFont(new java.awt.Font("Arial", 0, 20));
		accreditaButton.setPreferredSize(new Dimension(200,45));
		accreditaButton.setForeground(Color.decode("#4f4f4f"));
		
		spesaButton.setFont(new java.awt.Font("Arial", 0, 20));
		spesaButton.setPreferredSize(new Dimension(200,45));
		spesaButton.setForeground(Color.decode("#4f4f4f"));
		
		stampaTransazioniButton.setFont(new java.awt.Font("Arial", 0, 20));
		stampaTransazioniButton.setPreferredSize(new Dimension(200,45));
		stampaTransazioniButton.setForeground(Color.decode("#4f4f4f"));
		
		title = new JLabel("SALDO: ");
		title.setFont(new java.awt.Font("Dialog", 1, 21));
		title.setForeground(Color.WHITE);
		title.setBorder(BorderFactory.createLineBorder(new Color(70,130,180),7));
		JPanel topPane = new JPanel();
		topPane.setLayout(new BorderLayout());
		topPane.add(title, BorderLayout.WEST);
		topPane.add(esciButton, BorderLayout.EAST);
		topPane.setBackground(new Color(70,130,180));
		rightPane.add(topPane, BorderLayout.NORTH);
		
		JPanel middlePane1 = new JPanel();
		middlePane1.setLayout(new BorderLayout());
		
		rightPane.add(middlePane1, BorderLayout.CENTER);
		rightPane.setBackground(new Color(70,130,180));
		
		JPanel buttonPane = new JPanel(new BorderLayout());
		buttonPane.add(accreditaButton, BorderLayout.WEST);
		buttonPane.add(spesaButton, BorderLayout.EAST);
		buttonPane.add(stampaTransazioniButton, BorderLayout.CENTER);
		buttonPane.setBackground(new Color(70,130,180));
		middlePane1.add(buttonPane, BorderLayout.SOUTH);
		middlePane1.add(logArea, BorderLayout.CENTER);	

		///////////////////////
		//// FRAME OPTIONS ////
		///////////////////////
		
		this.setLayout(new GridLayout(1, 1));
		this.add(rightPane);
//		this.add(leftPane);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width; 
		setSize(2*screenWidth/5,2*screenHeight/3); 
		setLocation(screenWidth/8,screenHeight/8); 
		setTitle("Bentornato IL TUO NOME");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public JLabel getSaldoTitle() {
		return title;
	}
	
	public JButton getSpesaButton() {
		return spesaButton;
	}

	public JButton getAccreditaButton() {
		return accreditaButton;
	}

	public JTextArea getLogArea() {
		return logArea;
	}

	public JButton getStampaTransazioniButton() {
		return stampaTransazioniButton;
	}

	public JButton getEsciButton() {
		return esciButton;
	}
	
	
}
