package ca.uqam.inf2120.tp3.controleurs;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ca.uqam.inf2120.tp3.interfacegraphiques.DialogPatient;
import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;
import ca.uqam.inf2120.tp3.modele.Patient;
import ca.uqam.inf2120.tp3.modele.Proprietaire;

public class ControleurDialogPatient extends ControleurPatient {

	private DialogPatient uneVue;
	public ControleurDialogPatient(DialogPatient _dialogPatient) {
		super();
		this.uneVue=_dialogPatient;
	}
	public ControleurDialogPatient(DialogPatient _dialogPatient, GestionUrgenceCliniqueVeterinaire model) {
		super(model);
		this.uneVue=_dialogPatient;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// Obtenir la source de l'événement.
		Object source = event.getSource();
		
		// event Bouton Ajouter
		if(source == uneVue.getBtnAjouter())
		{
			Patient patient ;
			boolean bValide =true;
			String espesce="";
			if(uneVue.getRdbtnFelin().isSelected()){
				espesce="Felin";
			}
			if(uneVue.getRdbtnCanin().isSelected()){
				espesce="Canin";
			}
			if(uneVue.getRdbtnAutre().isSelected()){
				espesce="Autre";
			}
				
			if(uneVue.gettFNom().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFAge().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFRaison().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFNomP().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFPrenomP().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFAdresse().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFTel().getText().isEmpty()){
				bValide =false;
			}
			
			if(bValide)
			{
				Proprietaire proprio = new Proprietaire(uneVue.gettFNomP().getText(),uneVue.gettFPrenomP().getText(),
						uneVue.gettFAdresse().getText(),uneVue.gettFTel().getText());
				
				patient = new Patient(uneVue.gettFNom().getText(),uneVue.gettFAge().getText(),uneVue.gettFRaison().getText()
						,espesce,(int)uneVue.getCboPriorite().getSelectedItem(),proprio);
				Model.placerPatient(patient);
				// Message d'information avec le bouton OK
				JOptionPane.showMessageDialog(this.uneVue,
								"Le patient a été ajouté",
								"SPT- Information",
								JOptionPane.INFORMATION_MESSAGE);
				uneVue.dispose();
			}
			else
				// Message d'erreur avec le bouton OK
				JOptionPane.showMessageDialog(null,
					    		"Tous les champs sont obligatoires !!!",
					    		"SPT- Erreur",
					    		JOptionPane.ERROR_MESSAGE);
		}
		if(source == uneVue.getBtnModifier()){
			Patient patient ;
			boolean bValide =true;
			String espesce="";
			if(uneVue.getRdbtnFelin().isSelected()){
				espesce="Felin";
			}
			if(uneVue.getRdbtnCanin().isSelected()){
				espesce="Canin";
			}
			if(uneVue.getRdbtnAutre().isSelected()){
				espesce="Autre";
			}
			if(uneVue.gettFAge().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFRaison().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFNomP().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFPrenomP().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFAdresse().getText().isEmpty()){
				bValide =false;
			}
			if(uneVue.gettFTel().getText().isEmpty()){
				bValide =false;
			}
			if(bValide){
				patient = this.Model.rechercherParIndentifiant(uneVue.gettFId().getText());
				patient.setAge(uneVue.gettFAge().getText());
				patient.setEspece(espesce);
				patient.setRaisonUrgence(uneVue.gettFAge().getText());
				patient.getProprietaire().setNom(uneVue.gettFNomP().getText());
				patient.getProprietaire().setPrenom(uneVue.gettFPrenomP().getText());
				patient.getProprietaire().setAdresse(uneVue.gettFAdresse().getText());
				patient.getProprietaire().setTelephone(uneVue.gettFTel().getText());
				this.Model.modifierPatient(patient);
				JOptionPane.showMessageDialog(this.uneVue,
						"Le patient a été modifié",
						"SPT- Information",
						JOptionPane.INFORMATION_MESSAGE);
				this.uneVue.dispose();
			}
			else
				// Message d'erreur avec le bouton OK
				JOptionPane.showMessageDialog(null,
					    		"Tous les champs sont obligatoires !!!",
					    		"SPT- Erreur",
					    		JOptionPane.ERROR_MESSAGE);
		}
		if(source == uneVue.getBtnFermer())
		{
			this.uneVue.dispose();
		}
		if(source == uneVue.getBtnAnnuler())
		{
			uneVue.dispose();
		}
	}
}
