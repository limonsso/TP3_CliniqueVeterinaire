package ca.uqam.inf2120.tp3.interfacegraphiques;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * DialogEtudiantAjout : Fenêtre (JDialog) d'ajout d'un étudiant.
 * 
 * @author Ismael Doukoure
 * @version Avril 2014 
 * 
 */
public abstract class DialogPatient extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JTextField tFId;
	protected JTextField tFNom;
	protected JTextArea tFRaison;
	protected JTextField tFAge;
	protected JTextField tFDate;
	protected JTextField tFPriorite;
	protected JComboBox<Integer> cboPriorite;
	
	protected JTextField tFNomP;
	protected JTextField tFPrenom;
	protected JTextField tFTel;
	protected JTextArea  tFAdresse;
	

	protected static final int PANEL_WIDTH = 350;  
	/**
	 * mode permettant d'initialiser les controls nécéssaire
	 * @author Ezechiel Gnepa
	 *
	 */
	public enum Mode {
	    AJOUT, 
	    MODIFIE, 
	    CONSULTATION
	}
	
	

	/**
	 * 
	 * @param mode Le mode sous lequel les composante la fenêtre seront initialisé 
	 */
	public DialogPatient() {
		setTitle("SPT- ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, PANEL_WIDTH+30, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		
		
	}
	/**
	 * initisalise le panel du haut et ses controls
	 */
	public void initPanelTop(){
		JPanel panelHaut = new JPanel();
		
		panelHaut.setBorder(new TitledBorder(null, "Espèce",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panelHaut.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		panelHaut.setOpaque(true);
		contentPane.add(panelHaut);
		panelHaut.setLayout(new GridLayout(1, 3, 5, 5));
		
		
		JRadioButton rdbtnFelin = new JRadioButton("Félin");
		rdbtnFelin.setSelected(true);
		panelHaut.add(rdbtnFelin);
		
		JRadioButton rdbtnCanin = new JRadioButton("Canin");		
		panelHaut.add(rdbtnCanin);
		
		JRadioButton rdbtnAutre = new JRadioButton("Autre");		
		panelHaut.add(rdbtnAutre);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFelin);
		buttonGroup.add(rdbtnCanin);
		buttonGroup.add(rdbtnAutre);
	}
	
	/**
	 * initisalise le panel et ses controls pour les info du patient
	 */
	public void initPanelInfoPatiant(){
		
	}
	
	/**
	 * initisalise le panel et ses controls pour les info du propriotaire
	 */
	public void initPanelInfoProprietaire(){
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations du propriétaire",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH,170));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0,2, 5, 5));
		
		JLabel lblNomP = new JLabel("Nom  :");
		panelCenter.add(lblNomP);
		
		tFNomP = new JTextField();
		panelCenter.add(tFNomP);
		tFNomP.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom:");
		panelCenter.add(lblPrenom);
		
		tFPrenom = new JTextField();
		panelCenter.add(tFPrenom);
		tFPrenom.setColumns(10);
		
		JLabel lblTel = new JLabel("Téléphone :");
		panelCenter.add(lblTel);
		
		tFTel = new JTextField();
		panelCenter.add(tFTel);
		tFTel.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		panelCenter.add(lblAdresse);
		
		tFAdresse = new JTextArea();
		panelCenter.add(tFAdresse);
		tFAdresse.setRows(2);
		tFAdresse.setColumns(10);
		
		
	}
	/**
	 * initialise le panel du bas et ses controls
	 */
	public void initPanelBottom(){
		
	}
	
	
}
