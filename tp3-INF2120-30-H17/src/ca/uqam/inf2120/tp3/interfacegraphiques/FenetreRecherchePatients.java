package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

/**
 * FenetreRechercheEtudiants : Fenêtre (JFrame) de recherche d’étudiant avec des
 * étudiants dans la liste .
 * 
 * @author Ismael Doukoure
 * @version Avril 2014
 * 
 */
public class FenetreRecherchePatients extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfRecherche;
	private JTable tablePatients;

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

		setTitle("CLinique vétérinaire - Soins Pour Tous (SPT)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		initPanelTop();
		initPanelCenter();
		initTableResulat();
		initPanelBouton();
		
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
		
		JRadioButton rdbtnIdentifiant = new JRadioButton("Identifiant");
		rdbtnIdentifiant.setSelected(true);
		panelHaut.add(rdbtnIdentifiant);
		
		JRadioButton rdbtnInfpiorite = new JRadioButton("< à la priorité");		
		panelHaut.add(rdbtnInfpiorite);
		
		JRadioButton rdbtnEgalepiorite = new JRadioButton("= à la priorité");		
		panelHaut.add(rdbtnEgalepiorite);
		
		JRadioButton rdbtnSuppiorite = new JRadioButton("> à la priorité");		
		panelHaut.add(rdbtnSuppiorite);

		JRadioButton rdbtnTous = new JRadioButton("Tous les patients");
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

		JButton btnRechercher = new JButton("Rechercher");
		panelCenter.add(btnRechercher);

		
	}
	
	/**
	 * Initialisation du panel de la table de Resulats de recherche et de ses composantes
	 */
	public void initTableResulat(){
		JPanel panelTable = new JPanel();
		panelTable.setPreferredSize(new Dimension(10, 15));
		panelTable.setOpaque(true);
		contentPane.add(panelTable);
		
		tablePatients = new JTable();
		tablePatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePatients.setFillsViewportHeight(true);
		tablePatients.setPreferredScrollableViewportSize(new Dimension(600, 70));
		tablePatients.setModel(creerModeleAvecColonnesNonEditables());

		tablePatients.setRowSelectionInterval(0, 0);
		tablePatients.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablePatients.getColumnModel().getColumn(1).setResizable(false);
		tablePatients.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePatients.getColumnModel().getColumn(2).setResizable(false);
		tablePatients.getColumnModel().getColumn(2).setPreferredWidth(160);
		tablePatients.getColumnModel().getColumn(3).setResizable(false);
		tablePatients.getColumnModel().getColumn(3).setPreferredWidth(300);

		JScrollPane scrollPane = new JScrollPane(tablePatients);
		scrollPane.setPreferredSize(new Dimension(580, 60));
		//panelTable.add(scrollPane);

	}
	
	/**
	 * Initialisation du panel des boutons et de ses composantes
	 */
	public void initPanelBouton(){
		JPanel panelBoutons = new JPanel();
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		fl_panelBoutons.setVgap(20);
		fl_panelBoutons.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBoutons);

		JButton btnAjouter = new JButton("Ajouter");
		panelBoutons.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		panelBoutons.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		panelBoutons.add(btnSupprimer);

		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		panelBoutons.add(btnAfficher);

		JButton btnFermer = new JButton("Fermer");
		panelBoutons.add(btnFermer);
	}
	@SuppressWarnings("serial")
	/**
	 * Créer le modèle avec les colonnes non éditables.
	 * 
	 * @return LE modèle de la table.
	 */
	private DefaultTableModel creerModeleAvecColonnesNonEditables() {
		
		return new DefaultTableModel(
				new Object[][] {
						{ "", "", "","","" }
						},
				new String[] { "Identifiant", "Nom",
						"Priorité", "Date / Heure d'arrivée","Nom et prénom du propriotaire"  }) {
			
			boolean[] columnEditables = new boolean[] { false, false, false, false,false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}

}
