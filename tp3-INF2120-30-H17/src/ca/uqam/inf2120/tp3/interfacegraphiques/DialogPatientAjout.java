package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ca.uqam.inf2120.tp3.controleurs.ControleurDialogPatient;



public class DialogPatientAjout extends DialogPatient {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *Cr�er un dialogue et le rendre visible.
	 */
	public static void main(String[] args) {
			
			DialogPatient frame = new DialogPatientAjout();
			frame.setModal(true);
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
	
		
	}
	public DialogPatientAjout(JFrame Parent) {
		super(Parent);
		setTitle("SPT- Ajout d'un patient");
		this.setBounds(100, 100, PANEL_WIDTH+30, 475);
		this.initPanelTop();
		initPanelInfoPatiant();
		this.initPanelInfoProprietaire();
		initPanelBottom();
		//btnAjouter.addActionListener(controleurDialogPatient);
		//btnAnnuler.addActionListener(controleurDialogPatient);
	}
	
	public DialogPatientAjout() {
		super();
		setTitle("SPT- Ajout d'un patient");
		this.setBounds(100, 100, PANEL_WIDTH+30, 475);
		this.initPanelTop();
		initPanelInfoPatiant();
		this.initPanelInfoProprietaire();
		initPanelBottom();
	}
	@Override
	public void initPanelInfoPatiant() {
		super.initPanelInfoPatiant();
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Informations g�n�rale du patient",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter.setPreferredSize(new Dimension(PANEL_WIDTH,150));
		contentPane.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0,2, 5, 5));
			
		JLabel lblNom = new JLabel("Nom - Patient:");
		panelCenter.add(lblNom);
		
		tFNom = new JTextField();
		panelCenter.add(tFNom);
		tFNom.setColumns(10);
		
		JLabel lblAge = new JLabel("�ge :");
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
		
		JLabel lblPriorite = new JLabel("Priorit� :");
		panelCenter.add(lblPriorite);
		
		cboPriorite = new JComboBox<Integer>();
		cboPriorite.setEditable(true);
		cboPriorite.setModel(new DefaultComboBoxModel<Integer>(new Integer[]{1,2,3,4,5}));
		panelCenter.add(cboPriorite);
		cboPriorite.setEditable(false);
	}
	
	@Override
	public void initPanelBottom() {
		super.initPanelBottom();
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelBas.setPreferredSize(new Dimension(PANEL_WIDTH, 50));
		contentPane.add(panelBas);
		
		btnAjouter = new JButton("Ajouter");
		panelBas.add(btnAjouter);
		
		btnAnnuler = new JButton("Annuler");
		panelBas.add(btnAnnuler);
	}
	@Override
	public void Refresh() {
		this.tFNom.setText("");
		this.tFAge.setText("");
		this.tFRaison.setText("");
		this.tFNomP.setText("");
		this.tFPrenomP.setText("");
		this.tFAdresse.setText("");
		this.tFTel.setText("");
		this.cboPriorite.setSelectedIndex(0);
	}
	
	public void setControleurDialogPatient(ControleurDialogPatient controleurDialogPatient) {
		super.setControleurDialogPatient(controleurDialogPatient);
		btnAjouter.addActionListener(super.getControleurDialogPatient());
		btnAnnuler.addActionListener(super.getControleurDialogPatient());
	}

}
