package ca.uqam.inf2120.tp3.interfacegraphiques;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
public class DialogPatient extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblId;
	private JTextField tFId;
	private JTextField tFNom;
	private JTextArea tFRaison;
	private JTextField tFAge;
	private JTextField tFDate;
	private JLabel lblDate;
	JComboBox<Integer> cboPriorite;
	
	private JTextField tFNomP;
	private JTextField tFPrenom;
	private JTextField tFTel;
	private JTextArea  tFAdresse;
	
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private JButton btnFermer;
	
	private JPanel panelHaut;
	private static final int PANEL_WIDTH = 350;  
	
	public enum Mode {
	    AJOUT, 
	    MODIFIE, 
	    CONSULTATION
	}
	
	/**
	 *Créer un dialogue et le rendre visible.
	 */
	public static void main(String[] args) {
		
			DialogPatient frame = new DialogPatient(Mode.CONSULTATION);
			frame.setModal(true);
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
	
		
	}

	/**
	 * 
	 * @param mode Le mode sous lequel les composante la fenêtre seront initialisé 
	 */
	public DialogPatient(Mode mode) {
		setTitle("Clinique vétérinaire - Soins Pour Tous (SPT)");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, PANEL_WIDTH+30, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		
		initPanelTop();
		
		initPanelInfoPatiant();
		initPanelInfoProprietaire();
		initPanelBottom();
		switch(mode){
			case AJOUT:
				initControlsModeAjout();
				break;
			case MODIFIE:
				initControlsModeModifie();
				break;
			case CONSULTATION:
				initControlsModeConsult();
				break;
		}
		
	}
	
	public void initPanelTop(){
		panelHaut = new JPanel();
		
		panelHaut.setBorder(new TitledBorder(null, "Espèce",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panelHaut.setPreferredSize(new Dimension(PANEL_WIDTH, 45));
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
	
	public void initPanelInfoPatiant(){
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations générale du patient",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH,240));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0,2, 5, 5));
		
		lblId = new JLabel("Identifiant :");
		panelCenter.add(lblId);
		
		tFId = new JTextField();
		panelCenter.add(tFId);
		tFId.setColumns(10);
		tFId.setEditable(false);
		
		JLabel lblNom = new JLabel("Nom - Patient:");
		panelCenter.add(lblNom);
		
		tFNom = new JTextField();
		panelCenter.add(tFNom);
		tFNom.setColumns(10);
		
		JLabel lblAge = new JLabel("Age :");
		panelCenter.add(lblAge);
		tFAge = new JTextField();
		tFAge.setText("");
		panelCenter.add(tFAge);
		tFAge.setColumns(10);
		
		
		JLabel lblNbCours = new JLabel("Raison d'urgence :");
		panelCenter.add(lblNbCours);
		
		tFRaison = new JTextArea();
		panelCenter.add(tFRaison);
		tFRaison.setRows(20);
		tFRaison.setColumns(10);
		
		JLabel lblPriorite = new JLabel("Priorité :");
		panelCenter.add(lblPriorite);
		
		cboPriorite = new JComboBox<Integer>();
		cboPriorite.setEditable(true);
		cboPriorite.setModel(new DefaultComboBoxModel<Integer>(new Integer[]{1,2,3,4,5,6,7,8,9,10}));
		panelCenter.add(cboPriorite);
		cboPriorite.setEditable(false);
		
		lblDate = new JLabel("Date / Heure d'arrivée :");
		panelCenter.add(lblDate);
		
		tFDate = new JTextField();
		panelCenter.add(tFDate);
		tFDate.setColumns(10);	
		tFDate.setEditable(false);
	}
	
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
	
	public void initPanelBottom(){
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelBas.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		contentPane.add(panelBas);
		
		btnAjouter = new JButton("Ajouter");
		panelBas.add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		panelBas.add(btnModifier);
		
		btnAnnuler = new JButton("Annuler");
		panelBas.add(btnAnnuler);
		
		btnFermer = new JButton("Fermer");
		panelBas.add(btnFermer);
	}
	
	/**
	 * initialise les controls en mode ajout
	 */
	public void initControlsModeAjout(){
		
		lblId.setVisible(false);
		tFId.setVisible(false);
		lblDate.setVisible(false);
		tFDate.setVisible(false);
		btnModifier.setVisible(false);
		btnFermer.setVisible(false);
	}
	/**
	 * initialise les controls en mode modification
	 */
	public void initControlsModeModifie(){
		
		tFNom.setEditable(false);
		btnAjouter.setVisible(false);
		btnFermer.setVisible(false);
	}
	/**
	 * initialise les controls en mode consultation
	 */
	public void initControlsModeConsult(){
		panelHaut.setVisible(false);
		tFNom.setEditable(false);
		tFAge.setEditable(false);
		tFRaison.setEditable(false);
		cboPriorite.setEnabled(false);
		tFNomP.setEditable(false);
		tFPrenom.setEditable(false);
		tFTel.setEditable(false);
		tFAdresse.setEditable(false);
		btnModifier.setVisible(false);
		btnAjouter.setVisible(false);
		btnAnnuler.setVisible(false);
	}
}
