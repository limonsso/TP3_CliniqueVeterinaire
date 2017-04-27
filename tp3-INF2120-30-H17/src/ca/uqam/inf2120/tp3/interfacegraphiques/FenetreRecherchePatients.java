package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ca.uqam.inf2120.tp3.controleurs.ControleurPatient;
import ca.uqam.inf2120.tp3.controleurs.ControleurRecherchePatient;

/**
 * FenetreRechercheEtudiants : Fenetre (JFrame) de recherche d��tudiant avec des
 * etudiants dans la liste .
 * 
 * @author Ismael Doukoure
 * @version Avril 2014
 * 
 */
public class FenetreRecherchePatients extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControleurPatient controleurPatient;
	private JPanel contentPane;
	private JTextField tfRecherche;
	private JTable tablePatients;
	private JPanel panelTable;
	private JRadioButton rdbtnIdentifiant;
	private JRadioButton rdbtnInfpiorite;
	private JRadioButton rdbtnEgalepiorite;
	private JRadioButton rdbtnSuppiorite;
	private JRadioButton rdbtnTous;
	private JButton btnRechercher;
	private JButton btnModifier ;
	private JButton btnAfficher ;
	private JButton btnSupprimer ;
	private JButton btnFermer ;
	private JButton btnAjouter ;
	public DefaultTableModel Value;
	
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		FenetreRecherchePatients fenetreRecherche = new FenetreRecherchePatients();
		fenetreRecherche.setVisible(true);

	}

	/**
	 * Constructeur.
	 */
	public FenetreRecherchePatients() {

		setTitle("CLinique v�t�rinaire - Soins Pour Tous (SPT)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		Value = creerModeleAvecColonnesNonEditables();
		
		initPanelTop();
		initPanelCenter();
		initTableResulat();
		initPanelBouton();
		controleurPatient = new ControleurRecherchePatient(this);
		
		btnRechercher.addActionListener(controleurPatient);
		btnAjouter.addActionListener(controleurPatient);
		btnAfficher.addActionListener(controleurPatient);
		btnModifier.addActionListener(controleurPatient);
		btnSupprimer.addActionListener(controleurPatient);
		btnFermer.addActionListener(controleurPatient);
		rdbtnIdentifiant.addActionListener(controleurPatient);
		rdbtnInfpiorite.addActionListener(controleurPatient);
		rdbtnEgalepiorite.addActionListener(controleurPatient);
		rdbtnSuppiorite.addActionListener(controleurPatient);
		rdbtnTous.addActionListener(controleurPatient);
	}
	/**
	 * Initialisation du panel du haut et de ses composantes
	 */
	public void initPanelTop(){
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder(null, "Type de recherche ",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelHaut);
		panelHaut.setLayout(new GridLayout(0, 2, 5, 5));
		
		rdbtnIdentifiant = new JRadioButton("Identifiant");
		rdbtnIdentifiant.setSelected(true);
		panelHaut.add(rdbtnIdentifiant);
		
		rdbtnInfpiorite = new JRadioButton("< � la priorit�");		
		panelHaut.add(rdbtnInfpiorite);
		
		rdbtnEgalepiorite = new JRadioButton("= � la priorit� donn�e");		
		panelHaut.add(rdbtnEgalepiorite);
		
		rdbtnSuppiorite = new JRadioButton("> � la priorit�");		
		panelHaut.add(rdbtnSuppiorite);

		rdbtnTous = new JRadioButton("Tous les patients");
		panelHaut.add(rdbtnTous);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnIdentifiant);
		buttonGroup.add(rdbtnInfpiorite);
		buttonGroup.add(rdbtnEgalepiorite);
		buttonGroup.add(rdbtnSuppiorite);
		buttonGroup.add(rdbtnTous);
	}
	/**
	 * Initialisation du panel du centre et de ses composantes
	 */
	public void initPanelCenter(){
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder(""));
		FlowLayout flowLayout_1 = (FlowLayout) panelCenter.getLayout();
		flowLayout_1.setVgap(15);
		contentPane.add(panelCenter);

		tfRecherche = new JTextField();
		panelCenter.add(tfRecherche);
		tfRecherche.setColumns(25);

		btnRechercher = new JButton("Rechercher");
		panelCenter.add(btnRechercher);

		 
	}
	
	/**
	 * Initialisation du panel de la table de Resulats de recherche et de ses composantes
	 */
	public void initTableResulat(){
		panelTable = new JPanel();
		panelTable.setPreferredSize(new Dimension(10, 15));
		panelTable.setOpaque(true);
		contentPane.add(panelTable);
		
		tablePatients = new JTable();
		tablePatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePatients.setFillsViewportHeight(true);
		tablePatients.setPreferredScrollableViewportSize(new Dimension(600, 70));
		tablePatients.setModel(Value);

		tablePatients.setRowSelectionInterval(0, 0);
		tablePatients.getColumnModel().getColumn(0).setPreferredWidth(5);
		tablePatients.getColumnModel().getColumn(1).setResizable(false);
		tablePatients.getColumnModel().getColumn(1).setPreferredWidth(8);
		tablePatients.getColumnModel().getColumn(2).setResizable(false);
		tablePatients.getColumnModel().getColumn(2).setPreferredWidth(10);
		tablePatients.getColumnModel().getColumn(3).setResizable(false);
		tablePatients.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		JTableHeader header = tablePatients.getTableHeader();
		header.setFont(new Font("Dialog", Font.BOLD, 12));
		
		scrollPane = new JScrollPane(tablePatients);
		scrollPane.setPreferredSize(new Dimension(580, 70));
		panelTable.add(scrollPane);
		scrollPane.setVisible(false);
	}
	@SuppressWarnings("serial")
	/**
	 * Cr�er le mod�le avec les colonnes non �ditables pour initialiser le model du Jtable tablePatients.
	 * 
	 * @return LE mod�le de la table.
	 */
	private DefaultTableModel creerModeleAvecColonnesNonEditables() {
		
		return new DefaultTableModel(
				new Object[][] {
						{ "", "", "","","" }
						},
				new String[] { "Identifiant", "Nom",
						"Priorit�", "Date / Heure d'arriv�e","Nom et pr�nom du propriotaire"  }) {
			
			boolean[] columnEditables = new boolean[] { false, false, false, false,false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}
	/**
	 * 
	 * Initialisation du panel des boutons et de ses composantes
	 */
	public void initPanelBouton(){
		JPanel panelBoutons = new JPanel();
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		fl_panelBoutons.setVgap(20);
		fl_panelBoutons.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBoutons);

		btnAjouter = new JButton("Ajouter");
		panelBoutons.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		panelBoutons.add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		panelBoutons.add(btnSupprimer);

		btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		panelBoutons.add(btnAfficher);

		btnFermer = new JButton("Fermer");
		panelBoutons.add(btnFermer);
	}
	
	// Rafraichir la vue
	public void refresh() {
		if(Value!=null){
		this.tablePatients.setModel(Value);
		tablePatients.setRowSelectionInterval(0, 0);
		tablePatients.getColumnModel().getColumn(0).setPreferredWidth(5);
		tablePatients.getColumnModel().getColumn(1).setResizable(false);
		tablePatients.getColumnModel().getColumn(1).setPreferredWidth(8);
		tablePatients.getColumnModel().getColumn(2).setResizable(false);
		tablePatients.getColumnModel().getColumn(2).setPreferredWidth(10);
		tablePatients.getColumnModel().getColumn(3).setResizable(false);
		tablePatients.getColumnModel().getColumn(3).setPreferredWidth(50);
		btnModifier.setEnabled(true);
		btnSupprimer.setEnabled(true);
		btnAfficher.setEnabled(true);
		scrollPane.setVisible(true);
		panelTable.validate();
		panelTable.repaint();
		
		}else{
			Value = creerModeleAvecColonnesNonEditables();
			scrollPane.setVisible(false);
			btnModifier.setEnabled(false);
			btnSupprimer.setEnabled(false);
			btnAfficher.setEnabled(false);
			scrollPane.setVisible(false);
			panelTable.validate();
			panelTable.repaint();
			panelTable.repaint();
		}
	}


	public JRadioButton getRdbtnIdentifiant() {
		return rdbtnIdentifiant;
	}

	public JRadioButton getRdbtnInfpiorite() {
		return rdbtnInfpiorite;
	}

	public JRadioButton getRdbtnEgalepiorite() {
		return rdbtnEgalepiorite;
	}
	
	public JRadioButton getRdbtnSuppiorite() {
		return rdbtnSuppiorite;
	}

	public JRadioButton getRdbtnTous() {
		return rdbtnTous;
	}
	
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	
	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnFermer() {
		return btnFermer;
	}

	public JTextField getTfRecherche() {
		return tfRecherche;
	}

	public JTable getTablePatients() {
		return tablePatients;
	}


}
