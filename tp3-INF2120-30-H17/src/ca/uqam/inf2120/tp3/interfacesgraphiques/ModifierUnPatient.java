package ca.uqam.inf2120.tp3.interfacesgraphiques;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ModifierUnPatient extends JDialog {

	private static final long serialVersionUID = 1L;
	private  JPanel fenetreModification;
	private JTextField nomPatient;
	private JTextField agePatient;
	private JTextField raisonUrgence;
	private JTextField nomProprietiare;
	private JTextField prenomProprietaire;
	private JTextField telephoneProprietaire;
	private JTextField adresse;
	private JTextField identifiant;
	private JTextField dateHeureArrivee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ModifierUnPatient modifiePatient = new ModifierUnPatient();
		modifiePatient.setVisible(true);
	}

	public ModifierUnPatient() {

		// Titre de la fenetre
		setTitle("SPT - Modifcation d'un patient ");

		// Taille de la fenetre
		setBounds(100, 100, 550, 300);
		fenetreModification = new JPanel();
		fenetreModification.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fenetreModification);

		// creation du gestion de disposition
		BorderLayout disposition = new BorderLayout();
		setLayout(disposition);
		fenetreModification.setLayout(disposition);

		// Panneau du haut
		JPanel espece = new JPanel();
		espece.setBorder(
				new TitledBorder(null, "Espèce", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		fenetreModification.add(espece, BorderLayout.NORTH);

		// creation des bouttons de l'espece
		JRadioButton rdbtnFelin = new JRadioButton("Félin");
		rdbtnFelin.setSelected(true);
		espece.add(rdbtnFelin);

		JRadioButton rdbtnCanin = new JRadioButton("Canin");
		rdbtnCanin.setSelected(false);
		espece.add(rdbtnCanin);

		JRadioButton rdbtnAutre = new JRadioButton("Autre");
		rdbtnAutre.setSelected(false);
		espece.add(rdbtnAutre);

		// creation du Groupe de boutons
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFelin);
		buttonGroup.add(rdbtnCanin);
		buttonGroup.add(rdbtnAutre);

		// Panneau du milieu
		JPanel informations = new JPanel();
		informations.setLayout(new GridLayout(2, 1));

		// creation du panneau des informations generales
		// JPanel infoGenerales = new JPanel();
		fenetreModification.add(informations, BorderLayout.CENTER);

		// Cree le cadre 'Informations générales du Patient'
		JPanel infoPatient = new JPanel();
		infoPatient.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Informations générales du patient", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		// Placer infoPatient dans la position CENTER du panneau information
		informations.add(infoPatient, BorderLayout.NORTH);

		// Gestionnaire de disposition en grille avec 0 espace horizontal et 5
		// pi vertical
		infoPatient.setLayout(new GridLayout(6, 2, 0, 5));

		// Premier ligne
		JLabel lblIdentifiant = new JLabel("Identifiant: ");
		infoPatient.add(lblIdentifiant);

		identifiant = new JTextField();
		// active l'edition des champs JTextField
		identifiant.setEditable(true);
		infoPatient.add(identifiant);
		identifiant.setColumns(10);

		// Deuxieme ligne
		JLabel lblnomPatient = new JLabel("Nom - Patient : ");
		infoPatient.add(lblnomPatient);

		nomPatient = new JTextField();
		// active l'edition des champs JTextField
		nomPatient.setEditable(true);
		// initailise le contenu textuel du champs
		nomPatient.setText("");
		// Ajoute le champ au infoPatient suivant le GridLyaout
		infoPatient.add(nomPatient);
		nomPatient.setColumns(10);

		// troisieme ligne
		JLabel lblAge = new JLabel("Age :");
		infoPatient.add(lblAge);

		agePatient = new JTextField();
		agePatient.setEditable(true);
		agePatient.setText("");
		infoPatient.add(agePatient);
		agePatient.setColumns(10);

		// quatrieme ligne
		JLabel lblRaisonUrgence = new JLabel("Raison de l'urgence :");
		infoPatient.add(lblRaisonUrgence);

		raisonUrgence = new JTextField();
		raisonUrgence.setEditable(false);
		raisonUrgence.setText("");
		infoPatient.add(raisonUrgence);
		raisonUrgence.setColumns(10);

		// cinquieme ligne
		JLabel lblPriorite = new JLabel("Code / Titre Programme :");
		infoPatient.add(lblPriorite);

		// Creer le conteneur JComboBox qui contiendra des elements de type int
		JComboBox<String> comboBox = new JComboBox<String>();
		// Creer le contenu de la liste deroulante de type String
		String[] listeDeroulante = new String[] { "1 ", "2 ", "3 ", "4 ", "5 " };
		// Creer le model (type de deroulement) ComboBoxModel qui va contenir la
		// liste deroulante
		DefaultComboBoxModel<String> comboDeroulant = new DefaultComboBoxModel<String>(listeDeroulante);
		// Ou les ajouter grace a la methode addElment(String s)
		// Lier note comboBox avec le model qu'on a creer
		comboBox.setModel(comboDeroulant);
		// Ajoute le combo au panelHaut suivant le GridLyaout
		infoPatient.add(comboBox);

		// sixieme ligne
		JLabel lblDateHeureArrivee = new JLabel("Date / Heure arrivée :");
		infoPatient.add(lblDateHeureArrivee);

		dateHeureArrivee = new JTextField();
		dateHeureArrivee.setEditable(false);
		dateHeureArrivee.setText("");
		infoPatient.add(dateHeureArrivee);
		dateHeureArrivee.setColumns(10);
		
		
		

		// Cree le cadre 'Informationsdu propriétaire'
		JPanel infoPropio = new JPanel();
		infoPropio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations du propiétaire",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		// Placer infoPropio dans la position CENTER du panneau informations
		informations.add(infoPropio, BorderLayout.SOUTH);
		// Gestionnaire de disposition en grille avec 0 espace horizontal et 5
		// pi vertical
		infoPropio.setLayout(new GridLayout(5, 2, 0, 5));

		// Premier ligne
		JLabel lblnomProprio = new JLabel("Nom : ");
		infoPropio.add(lblnomProprio);

		nomProprietiare = new JTextField();
		// active l'edition des champs JTextField
		nomProprietiare.setEditable(true);
		// initailise le contenu textuel du champs
		nomProprietiare.setText("");
		// Ajoute le champ au infoPatient suivant le GridLyaout
		infoPropio.add(nomProprietiare);
		nomProprietiare.setColumns(10);

		// Deuxieme ligne
		JLabel lblPrenom = new JLabel("Prénom :");
		infoPropio.add(lblPrenom);

		prenomProprietaire = new JTextField();
		prenomProprietaire.setEditable(true);
		prenomProprietaire.setText("");
		infoPropio.add(prenomProprietaire);
		prenomProprietaire.setColumns(10);

		// Troisieme ligne
		JLabel lblTelephone = new JLabel("Téléphone :");
		infoPropio.add(lblTelephone);

		telephoneProprietaire = new JTextField();
		telephoneProprietaire.setEditable(true);
		telephoneProprietaire.setText("");
		infoPropio.add(telephoneProprietaire);
		telephoneProprietaire.setColumns(10);

		// Quatrieme ligne
		JLabel lblAdresse = new JLabel("Adresse :");
		infoPropio.add(lblAdresse);

		adresse = new JTextField();
		adresse.setEditable(false);
		adresse.setText("");
		infoPropio.add(adresse);
		adresse.setColumns(10);

		// ----------------creation du panneau du bas-----
		JPanel panelBoutons = new JPanel();
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		fl_panelBoutons.setVgap(20);
		fl_panelBoutons.setAlignment(FlowLayout.RIGHT);
		fenetreModification.add(panelBoutons, BorderLayout.SOUTH);
		// fenetreModification.add(panelBoutons);

		JButton btnAjouter = new JButton("Ajouter");
		panelBoutons.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		panelBoutons.add(btnAnnuler);
		pack();
	}

}
