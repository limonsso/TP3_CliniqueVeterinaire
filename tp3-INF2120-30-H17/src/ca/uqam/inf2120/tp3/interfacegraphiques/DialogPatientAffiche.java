package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ca.uqam.inf2120.tp3.controleurs.ControleurDialogPatient;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3
 * 
 * Classe DialogPatientAffiche : permet d'afficher les informations d'un patient
 * (nom, age,etc...)
 * 
 * 
 * @author Doumo Doumo Serges=Michel - DOUS20078401 et Ezeckiel Gnepa -
 * @version 5 avril 2017
 */
public class DialogPatientAffiche extends DialogPatient {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		DialogPatient frame = new DialogPatientAffiche();
		frame.setModal(true);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 * permet de generer la fenetre d'affichage du patient en gerant les
	 * informations situees dans le pannel du haut
	 * 
	 * @param Parent
	 */
	public DialogPatientAffiche(JFrame Parent) {

		super(Parent);
		setTitle("SPT- Affichage d'un patient");
		this.setBounds(100, 100, PANEL_WIDTH + 30, 510);

		// this.initPanelTop();
		initPanelInfoPatiant();
		this.initPanelInfoProprietaire();
		initPanelBottom();
	}

	/**
	 * permet de generer la fenetre d'affichage des informations du patient
	 */
	public DialogPatientAffiche() {

		super();
		setTitle("SPT- Affichage d'un patient");
		this.setBounds(100, 100, PANEL_WIDTH + 30, 510);
		// this.initPanelTop();
		initPanelInfoPatiant();
		this.initPanelInfoProprietaire();
		initPanelBottom();
	}

	/**
	 * initialise le pannel d'affichage du patient et ses composantes
	 */
	@Override
	public void initPanelInfoPatiant() {

		// creation du panel du centre
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations g�n�rale du patient", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH, 240));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0, 2, 5, 5));

		// creation du label de l'identifiant
		JLabel lblId = new JLabel("Identifiant :");
		panelCenter.add(lblId);

		// creation de champ de texte de l'identifiant
		tFId = new JTextField();
		panelCenter.add(tFId);
		tFId.setColumns(10);
		tFId.setEditable(false);

		// creation du label du Nom du patient
		JLabel lblNom = new JLabel("Nom - Patient:");
		panelCenter.add(lblNom);

		// creation du champ de texte du Nom du patient
		tFNom = new JTextField();
		panelCenter.add(tFNom);
		tFNom.setColumns(10);
		tFNom.setEditable(false);

		// creation du label de l'age du patient
		JLabel lblAge = new JLabel("�ge :");
		panelCenter.add(lblAge);

		// creation du champ de texte d l'age du patient
		tFAge = new JTextField();
		tFAge.setText("");
		panelCenter.add(tFAge);
		tFAge.setColumns(10);
		tFAge.setEditable(false);

		// creation du label de la raison d'urgence du patient
		JLabel lblNbCours = new JLabel("Raison d'urgence :");
		panelCenter.add(lblNbCours);

		// creation du champ de texte de la raison d'urgence du patient
		tFRaison = new JTextArea();
		panelCenter.add(tFRaison);
		tFRaison.setRows(20);
		tFRaison.setColumns(10);
		tFRaison.setEditable(false);

		// creation du label de la priorite du patient
		JLabel lblPriorite = new JLabel("Priorit� :");
		panelCenter.add(lblPriorite);

		// creation du champ de texte de la prorite du patient
		tFPriorite = new JTextField();
		panelCenter.add(tFPriorite);
		tFPriorite.setColumns(10);
		tFPriorite.setEditable(false);
		tFPriorite.setEditable(false);

		// creation du label de la date du creation du patient
		JLabel lblDate = new JLabel("Date / Heure d'arriv�e :");
		panelCenter.add(lblDate);

		// creation du champ de texte de la date d'arrivee du patient
		tFDate = new JTextField();
		panelCenter.add(tFDate);
		tFDate.setColumns(10);
		tFDate.setEditable(false);
	}

	/**
	 * initialise le panel du bas et ses composantes
	 */
	@Override
	public void initPanelBottom() {

		super.initPanelBottom();
		//creation du pannel du bas
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelBas.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		contentPane.add(panelBas);
		
		//creation du bouton fermer
		btnFermer = new JButton("Fermer");
		panelBas.add(btnFermer);
	}

	/**
	 * gestion du controlleur
	 */
	public void setControleurDialogPatient(ControleurDialogPatient controleurDialogPatient) {
		super.setControleurDialogPatient(controleurDialogPatient);
		this.Refresh();
		btnFermer.addActionListener(super.getControleurDialogPatient());
	}
}
