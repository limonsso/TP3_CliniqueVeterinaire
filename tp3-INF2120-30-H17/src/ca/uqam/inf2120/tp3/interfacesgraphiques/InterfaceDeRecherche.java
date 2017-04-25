package ca.uqam.inf2120.tp3.interfacesgraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
 * FenetreRechercheEtudiants : FenÍtre (JFrame) de recherche díÈtudiant avec des
 * Ètudiants dans la liste .
 * 
 * @author Ismael Doukoure
 * @version Avril 2014
 * 
 */
public class InterfaceDeRecherche  extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable tablePatients;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		InterfaceDeRecherche fenetreRecherche = new InterfaceDeRecherche();
		fenetreRecherche.setVisible(true);

	}


	/**
	 * Constructeur.
	 */
	public InterfaceDeRecherche() {

		//caracteristiques de la fenetre de recherche
		setTitle("Clinique vétérinaire - Soins Pour Tous (SPT)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 320 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		//------------------------------creation du panneau haut
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder(null, "Type de recherche", TitledBorder.LEFT, TitledBorder.TOP, null, new Color (0, 0, 0)));
		contentPane.add(panelHaut);
		panelHaut.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		//creation du bouton identifiant
		JRadioButton rdbtnIdentifiant = new JRadioButton("Identifiant");
		rdbtnIdentifiant.setSelected(true);
		panelHaut.add(rdbtnIdentifiant);
		
		//creation du bouton de priorite inferieure
		JRadioButton rdbtnInfAPrioriteDonee = new JRadioButton("< à la priorité donnée");
		panelHaut.add(rdbtnInfAPrioriteDonee);

		//creation du bouton de priorite egale
		JRadioButton rdbtnEgaleAPrioriteDonnee = new JRadioButton("= à la priorité donnée");
		panelHaut.add(rdbtnEgaleAPrioriteDonnee);
		
		//creation du bouton de priorite superieure
		JRadioButton rdbtnSupAPrioriteDonee = new JRadioButton("> à la priorité donnée");
		panelHaut.add(rdbtnSupAPrioriteDonee);
		 
		//creation du bouton tous les patients 
		JRadioButton rdbtnTousPatients = new JRadioButton("Tous les patients");
		panelHaut.add(rdbtnTousPatients);


		// creation du Groupe de boutons  
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnIdentifiant);
		buttonGroup.add(rdbtnInfAPrioriteDonee);
		buttonGroup.add(rdbtnEgaleAPrioriteDonnee);
		buttonGroup.add(rdbtnSupAPrioriteDonee);
		buttonGroup.add(rdbtnTousPatients);


		//-------------------------------creation du panneau du milieu
		// caracteristques du panneau
		JPanel panelCenter = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelCenter.getLayout();
		flowLayout_1.setVgap(15);
		contentPane.add(panelCenter);

		//creation du chamop de texte
		textField = new JTextField();
		panelCenter.add(textField);
		textField.setColumns(20);

		//cretion du bouton de recherche
		JButton btnRechercher = new JButton("Rechercher");
		panelCenter.add(btnRechercher);

		//----------------creation du panneau de table-----
		//caracteristques du paneeau de table
		JPanel panelTable = new JPanel();
		panelTable.setPreferredSize(new Dimension(10, 15));
		panelTable.setOpaque(true);
		contentPane.add(panelTable);

		tablePatients = new JTable();
		tablePatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePatients.setFillsViewportHeight(true);
		tablePatients.setPreferredScrollableViewportSize(new Dimension(479, 70));
		tablePatients.setModel(creerModeleAvecColonnesNonEditables());
		tablePatients.setRowSelectionInterval(0, 0);
		tablePatients.setFocusable(false);
		

		tablePatients.getColumnModel().getColumn(0).setResizable(false);
		tablePatients.getColumnModel().getColumn(1).setResizable(false);
		tablePatients.getColumnModel().getColumn(1).setPreferredWidth(65);
		tablePatients.getColumnModel().getColumn(2).setResizable(false);
		tablePatients.getColumnModel().getColumn(2).setPreferredWidth(92);
		tablePatients.getColumnModel().getColumn(3).setResizable(false);

		//ceration du paneau deroulant
		JScrollPane scrollPane = new JScrollPane(tablePatients);
		scrollPane.setPreferredSize(new Dimension(481, 60));
		panelTable.add(scrollPane);
//		tablePatients.setVisible(false);

		//----------------creation du panneau du bas-----
		JPanel panelBoutons = new JPanel();
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		fl_panelBoutons.setVgap(20);
		fl_panelBoutons.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBoutons);

		JButton btnAjouter = new JButton("Ajouter");
		panelBoutons.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		panelBoutons.add(btnModifier);
		btnModifier.setEnabled(false);
		
		JButton btnSupprimer = new JButton("Supprimer");
		panelBoutons.add(btnSupprimer);
		btnSupprimer.setEnabled(false);

		JButton btnAfficher = new JButton("Afficher");
		panelBoutons.add(btnAfficher);
		btnAfficher.setEnabled(false);

		JButton btnFermer = new JButton("Fermer");
		panelBoutons.add(btnFermer);



	}

	@SuppressWarnings("serial")
	/**
	 * CrÈer le modËle avec les colonnes non Èditables.
	 * 
	 * @return LE modËle de la table.
	 */
	private DefaultTableModel creerModeleAvecColonnesNonEditables() {
		return new DefaultTableModel(
				new Object[][] {
					{"AKI1", "Akita", "1", "05-04-2017 10:24:00" ,"Propescu Daniel"},
					{"ALS3", "Alsa", "2", "05-04-2017 11:40:45" , "Touré Alain"},
					{"BAL2", "Baloo", "3", "05-04-2017 09:20:25" , "Cadenas Alex"},
					{"DOU5", "Maloo", "4", "06-04-2017 10:20:30" , "Michel Tremblay"},
				}, new String[] {
						"identifiant", "Nom", "Priorité", "Date / Heure d'arrivée", "Nom et Prénom du propriétaire"
				}) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
				
				
			}
		};


	}		

}
