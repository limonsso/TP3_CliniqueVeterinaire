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
 * DialogEtudiantAjout : Fen�tre (JDialog) d'ajout d'un �tudiant.
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
	protected JTextArea tFAdresse;

	protected JRadioButton rdbtnFelin;
	protected JRadioButton rdbtnCanin;
	protected JRadioButton rdbtnAutre;

	protected JButton btnFermer;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnAnnuler;
	public Object[] Value;

	protected static final int PANEL_WIDTH = 350;

	/**
	 * mode permettant d'initialiser les controls n�c�ssaire
	 * 
	 * @author Ezechiel Gnepa
	 *
	 */
	public enum Mode {
		AJOUT, MODIFIE, CONSULTATION
	}

	/**
	 * 
	 * @param mode
	 *            Le mode sous lequel les composante la fen�tre seront
	 *            initialis�
	 */
	public DialogPatient() {
		setTitle("SPT- ");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, PANEL_WIDTH + 30, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());

	}

	/**
	 * permet de generer la fenetre d'affichage generale d'un patient qui pourra
	 * etre modifier selon la selection effectuee( afficher, modifier..)
	 * 
	 * @param parent
	 */
	public DialogPatient(Frame parent) {

		super(parent);
		setTitle("SPT- ");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, PANEL_WIDTH + 30, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		controleurDialogPatient = new ControleurDialogPatient(this);

	}

	/**
	 * permet d'initialiser le panneau du haut et ses composantes (titre,
	 * gestionnaire de disposotion et bouttons radio)
	 * 
	 */
	public void initPanelTop() {

		// creation du panneau du haut
		JPanel panelHaut = new JPanel();

		// dispostion et titre
		panelHaut.setBorder(
				new TitledBorder(null, "Espèce", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHaut.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		panelHaut.setOpaque(true);
		contentPane.add(panelHaut);
		panelHaut.setLayout(new GridLayout(1, 3, 5, 5));

		// creation du boutton radio de l'espèce felin
		rdbtnFelin = new JRadioButton("Félin");

		// selection automatique du boutton de l'espèce félin
		rdbtnFelin.setSelected(true);
		panelHaut.add(rdbtnFelin);

		// creation du boutton radio de l'espèce Canin
		rdbtnCanin = new JRadioButton("Canin");
		panelHaut.add(rdbtnCanin);

		// creation du boutton radio d'une espèce Autre
		rdbtnAutre = new JRadioButton("Autre");
		panelHaut.add(rdbtnAutre);

		// creation du ButtonGroup regroupant tous les boutons
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFelin);
		buttonGroup.add(rdbtnCanin);
		buttonGroup.add(rdbtnAutre);
	}

	/**
	 * initisalise le panel et ses controls pour les info du patient
	 */
	public void initPanelInfoPatiant() {

	}

	/**
	 * initisalise le panel et ses composantes pour les info du proprietaire
	 */
	public void initPanelInfoProprietaire() {

		// creation du panel du milieu
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations du propri�taire", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH, 170));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0, 2, 5, 5));

		// creation du label du nom et ajout au panel du centre
		JLabel lblNomP = new JLabel("Nom  :");
		panelCenter.add(lblNomP);

		// creation du champ de texte du nom et ajout au panel du centre
		tFNomP = new JTextField();
		panelCenter.add(tFNomP);
		tFNomP.setColumns(10);

		// creation du label du prenom et ajout au panel du centre
		JLabel lblPrenom = new JLabel("Pr�nom:");
		panelCenter.add(lblPrenom);

		// creation champ de texte du nom et ajout au panel du centre
		tFPrenomP = new JTextField();
		panelCenter.add(tFPrenomP);
		tFPrenomP.setColumns(10);

		// creation du label du telephone et ajout au panel du centre
		JLabel lblTel = new JLabel("T�l�phone :");
		panelCenter.add(lblTel);

		// creation du champ de texte du telephone et ajout au panel du centre
		tFTel = new JTextField();
		panelCenter.add(tFTel);
		tFTel.setColumns(10);

		// creation de l'adresse et ajout au panel du centre
		JLabel lblAdresse = new JLabel("Adresse :");
		panelCenter.add(lblAdresse);

		// creation du champ de texte du prenom et ajout au panel du centre
		tFAdresse = new JTextArea();
		panelCenter.add(tFAdresse);
		tFAdresse.setRows(2);
		tFAdresse.setColumns(10);

	}

	/**
	 * initialise le panel du bas et ses composantes
	 */
	public void initPanelBottom() {
	}

	/**
	 * permet de creer l'effet refresh
	 */
	public void Refresh() {

	}

	/**
	 * 
	 * @return controleurDialogPatient
	 */
	public ControleurDialogPatient getControleurDialogPatient() {
		return controleurDialogPatient;
	}

	// gettters

	/**
	 * 
	 * @return cboPriorite
	 */
	public JComboBox<Integer> getCboPriorite() {
		return cboPriorite;
	}

	/**
	 * 
	 * @return rdbtnFelin
	 */
	public JRadioButton getRdbtnFelin() {
		return rdbtnFelin;
	}

	/**
	 * 
	 * @return rdbtnCanin
	 */
	public JRadioButton getRdbtnCanin() {
		return rdbtnCanin;
	}

	/**
	 * 
	 * @return rdbtnAutre
	 */
	public JRadioButton getRdbtnAutre() {

		return rdbtnAutre;
	}

	/**
	 * 
	 * @return btnFermer
	 */
	public JButton getBtnFermer() {

		return btnFermer;

	}

	/**
	 * 
	 * @return btnAjouter
	 */
	public JButton getBtnAjouter() {

		return btnAjouter;

	}

	/**
	 * 
	 * @return btnModifier
	 */
	public JButton getBtnModifier() {

		return btnModifier;

	}

	/**
	 * 
	 * @return btnAnnuler
	 */
	public JButton getBtnAnnuler() {

		return btnAnnuler;

	}

	/**
	 * 
	 * @return tFId
	 */
	public JTextField gettFId() {

		return tFId;

	}

	/**
	 * 
	 * @return tFNom
	 */
	public JTextField gettFNom() {

		return tFNom;

	}

	/**
	 * 
	 * @return tFRaison
	 */
	public JTextArea gettFRaison() {

		return tFRaison;

	}

	/**
	 * 
	 * @return tFAge
	 */
	public JTextField gettFAge() {

		return tFAge;

	}

	/**
	 * 
	 * @return tFDate
	 */
	public JTextField gettFDate() {

		return tFDate;

	}

	/**
	 * 
	 * @return tFPriorite
	 */
	public JTextField gettFPriorite() {
		return tFPriorite;
	}

	/**
	 * 
	 * @return tFNomP
	 */
	public JTextField gettFNomP() {
		return tFNomP;
	}

	/**
	 * 
	 * @return tFPrenomP
	 */
	public JTextField gettFPrenomP() {
		return tFPrenomP;
	}

	/**
	 * 
	 * @return tFTel
	 */
	public JTextField gettFTel() {
		return tFTel;
	}

	/**
	 * 
	 * @return tFTel
	 */
	public JTextArea gettFAdresse() {
		return tFAdresse;
	}

	// Setters

	/**
	 * 
	 * @param tFId
	 */
	public void settFId(JTextField tFId) {
		this.tFId = tFId;
	}

	/**
	 * 
	 * @param tFNom
	 */
	public void settFNom(JTextField tFNom) {
		this.tFNom = tFNom;
	}

	/**
	 * 
	 * @param tFRaison
	 */
	public void settFRaison(JTextArea tFRaison) {
		this.tFRaison = tFRaison;
	}

	/**
	 * 
	 * @param tFAge
	 */
	public void settFAge(JTextField tFAge) {
		this.tFAge = tFAge;
	}

	/**
	 * 
	 * @param tFDate
	 */
	public void settFDate(JTextField tFDate) {
		this.tFDate = tFDate;
	}

	/**
	 * 
	 * @param tFPriorite
	 */
	public void settFPriorite(JTextField tFPriorite) {
		this.tFPriorite = tFPriorite;
	}

	/**
	 * 
	 * @param tFNomP
	 */
	public void settFNomP(JTextField tFNomP) {
		this.tFNomP = tFNomP;
	}

	/**
	 * 
	 * @param tFPrenom
	 */
	public void settFPrenom(JTextField tFPrenom) {
		this.tFPrenomP = tFPrenom;
	}

	/**
	 * 
	 * @param tFTel
	 */
	public void settFTel(JTextField tFTel) {
		this.tFTel = tFTel;
	}

	/**
	 * 
	 * @param tFAdresse
	 */
	public void settFAdresse(JTextArea tFAdresse) {
		this.tFAdresse = tFAdresse;
	}

	/**
	 * 
	 * @param controleurDialogPatient
	 */
	public void setControleurDialogPatient(ControleurDialogPatient controleurDialogPatient) {
		this.controleurDialogPatient = controleurDialogPatient;
	}

}
