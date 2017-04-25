package ca.uqam.inf2120.tp3.interfacegraphiques;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
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

import ca.uqam.inf2120.tp3.controleurs.ControleurDialogPatient;

/**
 * DialogEtudiantAjout : Fenêtre (JDialog) d'ajout d'un étudiant.
 * 
 * @author Ismael Doukoure
 * @version Avril 2014 
 * 
 */
public abstract class DialogPatient extends JDialog {

	
	private static final long serialVersionUID = 1L;
	protected ControleurDialogPatient controleurDialogPatient;
	protected JPanel contentPane;
	protected JTextField tFId;
	protected JTextField tFNom;
	protected JTextArea tFRaison;
	protected JTextField tFAge;
	protected JTextField tFDate;
	protected JTextField tFPriorite;
	protected JComboBox<Integer> cboPriorite;
	
	protected JTextField tFNomP;
	protected JTextField tFPrenomP;
	protected JTextField tFTel;
	protected JTextArea  tFAdresse;
	
	protected JRadioButton rdbtnFelin;
	protected JRadioButton rdbtnCanin;
	protected JRadioButton rdbtnAutre;
	
	protected JButton btnFermer;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnAnnuler;
	

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
	public DialogPatient(Frame parent) {
		super(parent);
		setTitle("SPT- ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, PANEL_WIDTH+30, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		controleurDialogPatient = new ControleurDialogPatient(this);
		
/*		btnFermer.addActionListener(controleurDialogPatient);
		btnAjouter.addActionListener(controleurDialogPatient);
		btnModifier.addActionListener(controleurDialogPatient);
		btnAnnuler.addActionListener(controleurDialogPatient);*/
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
		
		
		rdbtnFelin = new JRadioButton("Félin");
		rdbtnFelin.setSelected(true);
		panelHaut.add(rdbtnFelin);
		
		rdbtnCanin = new JRadioButton("Canin");		
		panelHaut.add(rdbtnCanin);
		
		rdbtnAutre = new JRadioButton("Autre");		
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
		
		tFPrenomP = new JTextField();
		panelCenter.add(tFPrenomP);
		tFPrenomP.setColumns(10);
		
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
	public void initPanelBottom(){}
	
	public void Refresh(){}
	
	public JComboBox<Integer> getCboPriorite() {
		return cboPriorite;
	}
	public JRadioButton getRdbtnFelin() {
		return rdbtnFelin;
	}
	public JRadioButton getRdbtnCanin() {
		return rdbtnCanin;
	}
	public JRadioButton getRdbtnAutre() {
		return rdbtnAutre;
	}
	public JButton getBtnFermer() {
		return btnFermer;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public JButton getBtnModifier() {
		return btnModifier;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	/*******************************************/
	public JTextField gettFId() {
		return tFId;
	}
	public JTextField gettFNom() {
		return tFNom;
	}
	public JTextArea gettFRaison() {
		return tFRaison;
	}
	public JTextField gettFAge() {
		return tFAge;
	}
	public JTextField gettFDate() {
		return tFDate;
	}
	public JTextField gettFPriorite() {
		return tFPriorite;
	}
	public JTextField gettFNomP() {
		return tFNomP;
	}
	public JTextField gettFPrenomP() {
		return tFPrenomP;
	}
	public JTextField gettFTel() {
		return tFTel;
	}
	public JTextArea gettFAdresse() {
		return tFAdresse;
	}
	public void settFId(JTextField tFId) {
		this.tFId = tFId;
	}
	public void settFNom(JTextField tFNom) {
		this.tFNom = tFNom;
	}
	public void settFRaison(JTextArea tFRaison) {
		this.tFRaison = tFRaison;
	}
	public void settFAge(JTextField tFAge) {
		this.tFAge = tFAge;
	}
	public void settFDate(JTextField tFDate) {
		this.tFDate = tFDate;
	}
	public void settFPriorite(JTextField tFPriorite) {
		this.tFPriorite = tFPriorite;
	}
	public void settFNomP(JTextField tFNomP) {
		this.tFNomP = tFNomP;
	}
	public void settFPrenom(JTextField tFPrenom) {
		this.tFPrenomP = tFPrenom;
	}
	public void settFTel(JTextField tFTel) {
		this.tFTel = tFTel;
	}
	public void settFAdresse(JTextArea tFAdresse) {
		this.tFAdresse = tFAdresse;
	}
	
	
}
