package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;


public class ControleurPatient implements ActionListener {


	protected GestionUrgenceCliniqueVeterinaire Model;
	public ControleurPatient() {
		Model = new GestionUrgenceCliniqueVeterinaire();
	}
	public ControleurPatient(GestionUrgenceCliniqueVeterinaire model) {
		Model =model;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

	public GestionUrgenceCliniqueVeterinaire getModel() {
		return Model;
	}

	public void setModel(GestionUrgenceCliniqueVeterinaire model) {
		Model = model;
	}

}
