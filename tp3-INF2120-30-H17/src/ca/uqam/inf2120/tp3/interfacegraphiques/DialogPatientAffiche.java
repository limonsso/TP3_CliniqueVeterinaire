package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DialogPatientAffiche extends DialogPatient {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
			
			DialogPatient frame = new DialogPatientAffiche();
			frame.setModal(true);
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
	
		
	}
	
	public DialogPatientAffiche() {
		super();
		setTitle("SPT- Affichage d'un patient");
		this.setBounds(100, 100, PANEL_WIDTH+30, 510);
		//this.initPanelTop();
		initPanelInfoPatiant();
		this.initPanelInfoProprietaire();
		initPanelBottom();
	}

	@Override
	public void initPanelInfoPatiant() {
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations générale du patient",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH,240));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0,2, 5, 5));
		
		JLabel lblId = new JLabel("Identifiant :");
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
		tFNom.setEditable(false);
		
		JLabel lblAge = new JLabel("Âge :");
		panelCenter.add(lblAge);
		
		tFAge = new JTextField();
		tFAge.setText("");
		panelCenter.add(tFAge);
		tFAge.setColumns(10);
		tFAge.setEditable(false);
		
		
		JLabel lblNbCours = new JLabel("Raison d'urgence :");
		panelCenter.add(lblNbCours);
		
		tFRaison = new JTextArea();
		panelCenter.add(tFRaison);
		tFRaison.setRows(20);
		tFRaison.setColumns(10);
		tFRaison.setEditable(false);
		
		JLabel lblPriorite = new JLabel("Priorité :");
		panelCenter.add(lblPriorite);
		
		tFPriorite = new JTextField();
		panelCenter.add(tFPriorite);
		tFPriorite.setColumns(10);	
		tFPriorite.setEditable(false);
		tFPriorite.setEditable(false);
		
		JLabel lblDate = new JLabel("Date / Heure d'arrivée :");
		panelCenter.add(lblDate);
		
		tFDate = new JTextField();
		panelCenter.add(tFDate);
		tFDate.setColumns(10);	
		tFDate.setEditable(false);
	}

	@Override
	public void initPanelBottom() {
		super.initPanelBottom();
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelBas.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		contentPane.add(panelBas);
		
		JButton btnFermer = new JButton("Fermer");
		panelBas.add(btnFermer);
	}


}
