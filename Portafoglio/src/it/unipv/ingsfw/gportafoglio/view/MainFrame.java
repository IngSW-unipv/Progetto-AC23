package it.unipv.ingsfw.gportafoglio.view;

import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton selectFileButtonLeft;
	private JButton selectFileButtonRight;
	
	private JTextArea textLeft;
	private JTextArea textRight;
	
	private JTextField leftPath;
	private JTextField rightPath;
	
	private JButton startLeft;
	private JButton startRight;
	
	public MainFrame() throws HeadlessException {
		super();
		initComponents();
	}
 
	public MainFrame(String title) throws HeadlessException {
		super(title);
		initComponents();		
	}

	public void initComponents() {
		
		////////////////////
		//// LEFT PANE ////
		////////////////////
		
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(BorderFactory.createMatteBorder(13, 5, 5, 5, new Color(70,130,180)));
		
		
		selectFileButtonLeft = new JButton("Seleziona immagine");
//		selectFileButtonLeft.setOpaque(true);
//		selectFileButtonLeft.getBorder().);
//		selectFileButtonLeft.setBorderPainted(true);
//		System.out.println(selectFileButtonLeft.getBorder().isBorderOpaque());
//		System.out.println(selectFileButtonLeft.isOpaque());
		selectFileButtonLeft.setFont(new java.awt.Font("Arial", 0, 20));
		selectFileButtonLeft.setPreferredSize(new Dimension(200,45));
		selectFileButtonLeft.setForeground(Color.decode("#4f4f4f"));
		
		JLabel title = new JLabel(" SELEZIONE OPERAZIONE DA SVOLGERE ");
		title.setFont(new java.awt.Font("Dialog", 1, 21));
		title.setForeground(Color.WHITE);
		title.setBorder(BorderFactory.createLineBorder(new Color(70,130,180),7));
		
		rightPane.add(title, BorderLayout.NORTH);
		
		JPanel middlePane1 = new JPanel();
		middlePane1.setLayout(new BorderLayout());
		JPanel buttonPane = new JPanel(new BorderLayout());
		buttonPane.add(selectFileButtonLeft, BorderLayout.WEST);
		buttonPane.setBackground(new Color(70,130,180));
		middlePane1.add(buttonPane, BorderLayout.SOUTH);
		rightPane.add(middlePane1, BorderLayout.CENTER);
		rightPane.setBackground(new Color(70,130,180));
		
		leftPath = new JTextField("                              Nessuna selezione");
		leftPath.setPreferredSize(new Dimension(350,40));
		leftPath.setEditable(false);
		leftPath.setBackground(new Color(70,130,180));
		leftPath.setForeground(Color.WHITE);
		leftPath.setBorder(null);
		buttonPane.add(leftPath, BorderLayout.EAST);
		
		startLeft = new JButton("Avvia");
//		startLeft.setOpaque(true);
		startLeft.setFont(new java.awt.Font("Arial", 0, 20));
		startLeft.setForeground(Color.decode("#198625"));
		buttonPane.add(startLeft, BorderLayout.CENTER);
		
		///////////////////
		//// RIGHT PANE ////
		///////////////////
		
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.setBorder(BorderFactory.createMatteBorder(13, 5, 5, 5, new Color(70,130,180)));
		
		selectFileButtonRight = new JButton("Seleziona immagine");
		selectFileButtonRight.setFont(new java.awt.Font("Arial", 0, 20));
//		selectFileButtonRight.setOpaque(true);
		selectFileButtonRight.setPreferredSize(new Dimension(200,45));
		selectFileButtonRight.setForeground(Color.decode("#4f4f4f"));
		
		textRight = new JTextArea();
		textRight.setEditable(false);
		textRight.setFont(new java.awt.Font("Arial", 0, 16));
		textRight.setToolTipText("qui verrà mostrato il testo nascosto nell'immagine");
		
		JLabel title2 = new JLabel(" INSERISCI IMMAGINE DA LEGGERE ");
		title2.setFont(new java.awt.Font("Dialog", 1, 21));
		title2.setForeground(Color.WHITE);
		title2.setBorder(BorderFactory.createLineBorder(new Color(70,130,180),7));
		
		leftPane.add(title2, BorderLayout.NORTH);
		
		JPanel middlePane2 = new JPanel();
		middlePane2.setLayout(new BorderLayout());
		middlePane2.add(textRight, BorderLayout.CENTER);
		JPanel buttonPane2 = new JPanel(new BorderLayout());
		buttonPane2.add(selectFileButtonRight, BorderLayout.WEST);
		buttonPane2.setBackground(new Color(70,130,180));
		middlePane2.add(buttonPane2, BorderLayout.SOUTH);
		leftPane.add(middlePane2, BorderLayout.CENTER);
		leftPane.setBackground(new Color(70,130,180));
		
		rightPath = new JTextField("                              Nessuna selezione");
		rightPath.setPreferredSize(new Dimension(350,40));
		rightPath.setEditable(false);
		rightPath.setBackground(new Color(70,130,180));
		rightPath.setForeground(Color.WHITE);
		rightPath.setBorder(null);
		buttonPane2.add(rightPath, BorderLayout.EAST);
		
		startRight = new JButton("Avvia");
//		startRight.setOpaque(true);
		startRight.setFont(new java.awt.Font("Arial", 0, 20));
		startRight.setForeground(Color.decode("#198625"));
		buttonPane2.add(startRight, BorderLayout.CENTER);
		
		///////////////////////
		//// FRAME OPTIONS ////
		///////////////////////
		
		this.setLayout(new GridLayout(1, 2));
		this.add(rightPane);
		this.add(leftPane);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width; 
		setSize(3*screenWidth/4,2*screenHeight/3); 
		setLocation(screenWidth/8,screenHeight/8); 
		setTitle("Steganography");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public JButton getSelectFileButtonRight() {
		return selectFileButtonRight;
	}

	public JButton getSelectFileButtonLeft() {
		return selectFileButtonLeft;
	}

	public JTextArea getTextRight() {
		return textRight;
	}

	public JTextArea getTextLeft() {
		return textLeft;
	}

	public JTextField getRightPath() {
		return rightPath;
	}

	public JTextField getLeftPath() {
		return leftPath;
	}

	public JButton getStartLeft() {
		return startLeft;
	}

	public JButton getStartRight() {
		return startRight;
	}
	
	
}
