package ca.uqam.inf2120.tp3.adt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.uqam.inf2120.tp1.adt.*;

public class FileAttenteImpl<T extends OrdonnableParPrioriteEtDateHeure> implements FileAttenteTda<T> {

	private ArrayList<T> listeAttente = new ArrayList<>();

	@Override
	/**
	 * Place l'element "elt" dans la file selon sa priorite. Les elements de la
	 * plus grande priorite sont places au debut de la file. Si "elt" a la meme
	 * priorite qu'un autre element qui existe deja dans la file, il doit etre
	 * place avant cet element si sa date / heure de creation est plus ancienne
	 * que ce dernier, sinon il est place apres. L'element ne doit pas etre
	 * place dans la file si une des conditions suivantes est vraie : -
	 * L'element est null. - L'element existe deja dans la file (elements
	 * identiques sans tenir compte de leur priorite et leur date / heure de
	 * creation). - La priorite de l'element est inferieure a 1.
	 *
	 * @param elt
	 *            L'element a ajouter
	 * @return true si "elt" est ajoute, sinon false
	 */
	public boolean placer(T elt) {

		int i = 0;
		boolean ajouter = false;

		if (listeAttente != null && elt != null && listeAttente.indexOf(elt) == -1 && elt.obtenirPriorite() >= 1) {

			while (i < listeAttente.size() && ajouter == false) {

				if ((elt.obtenirPriorite() == listeAttente.get(i).obtenirPriorite()
						&& (elt.obtenirDateHeureCreation().before(listeAttente.get(i).obtenirDateHeureCreation()) || elt
								.obtenirDateHeureCreation().equals(listeAttente.get(i).obtenirDateHeureCreation())))) {

					listeAttente.add(i, elt);
					ajouter = true;

				} else if (elt.obtenirPriorite() < listeAttente.get(i).obtenirPriorite()) {

					listeAttente.add(i, elt);
					ajouter = true;
				}
				i++;
			}
			if (ajouter == false) {
				listeAttente.add(listeAttente.size(), elt);
				ajouter = true;
			}

		}

		return ajouter;
	}

	@Override
	/**
	 * Place tous les elements de la liste passee en paramatre dans la file.
	 * Tous les elements sont placer dans la file selon leur priorite. Les
	 * elements de la plus grande priorite sont places au debut de la file. Si
	 * un element de la liste a la meme priorite qu'un autre element qui existe
	 * deja dans la file, il doit etre place avant cet element si sa date /
	 * heure de creation est plus ancienne que ce dernier, sinon il est place
	 * apres. L'element de la liste passee en parametre ne doit pas etre place
	 * dans la file si une des conditions suivantes est vraie : - L'element a
	 * placer est null. - L'element existe deja dans la file (elements
	 * identiques sans tenir compte de leur priorite et leur date / heure de
	 * creation). - La priorite de l'element est inferieure a 1.
	 * 
	 * La liste passee en parametre peut etre nulle ou vide.
	 * 
	 * @param liste
	 *            Le tableau liste (ArrayList) dont les elements doivent etre
	 *            places dans la file
	 */
	public void placer(List<T> liste) {

		if (liste != null && !liste.isEmpty()) {
			for (int i = 0; i < liste.size(); i++) {
				placer(liste.get(i));
			}
		}

	}

	@Override
	/**
	 * Enleve l'element "elt" dans la file. Aucune action a faire si "elt" est
	 * nul ou s'il n'existe pas dans la file. L'element a enlever doit etre egal
	 * a celui passe en parametre ("elt") sans tenir compte de leur priorite et
	 * leur date / heure de creation.
	 * 
	 * @param elt
	 *            L'element a enlever
	 * @return Vrai si l'element est enleve
	 */
	public boolean enlever(T elt) {

		boolean enlever = false;
		if (listeAttente != null && elt != null && listeAttente.indexOf(elt) != -1) {
			listeAttente.remove(elt);
			enlever = true;
		}
		return enlever;
	}

	@Override
	/**
	 * Enleve tous les elements de la liste passee en parametre dans la file.
	 * Tous les elements non enleves de la liste passee en parametre sont
	 * retournes dans un tableau liste (ArrayList). La comparaison entre les
	 * elements de la liste passee en parametre et de la file doit se faire sans
	 * tenir compte de leur priorite et leur date / heure de creation. La liste
	 * passee en parametre peut etre nulle ou vide.
	 * 
	 * @param liste
	 *            Le tableau liste (ArrayList) dont les elements doivent etre
	 *            enleves
	 * @return Le tableau liste (ArrayList) des elements non enleves, nul si
	 *         tous les elements sont enleves.
	 */
	public List<T> enlever(List<T> liste) {

		List<T> listeRetournee = new ArrayList<>();

		if (liste != null && !liste.isEmpty()) {
			for (int i = 0; i < liste.size(); i++) {

				if (listeAttente.contains(liste.get(i))) {
					listeAttente.remove(liste.get(i));

				} else {
					listeRetournee.add(liste.get(i));
				}
			}
		} else {
			listeRetournee = null;
		}
		return listeRetournee;
	}

	@Override
	/**
	 * Enleve tous les elements dont la priorite est egale a celle passee en
	 * parametre. Les elements enleves sont retournes dans un tableau liste. Une
	 * valeur nulle est retournee si aucun element n'est enleve.
	 * 
	 * @param priorite
	 *            La priorite des elements a enlever
	 * @return Le tableau liste des elements enleves, null si aucun element n'a
	 *         ete enleve
	 */
	public List<T> enlever(int priorite) {

		List<T> listeRetournee = new ArrayList<>();
		int i = 0;
		boolean retire = false;

		if (listeAttente != null && !listeAttente.isEmpty()) {

			while (i < listeAttente.size() && !retire) {

				if (listeAttente.get(i).obtenirPriorite() == priorite) {

					listeRetournee.add(listeAttente.get(i));
					listeAttente.remove(listeAttente.get(i));
					i--;

				} else if (listeAttente.get(i).obtenirPriorite() > priorite) {
					retire = true;
				}
				i++;
			}

		}
		if (listeRetournee.isEmpty()) {
			listeRetournee = null;
		}

		return listeRetournee;
	}

	@Override
	/**
	 * Enleve les elements de la file selon les conditions suivantes : - Si le
	 * parametre "plusPetit" est vrai, les elements a enlever doivent avoir la
	 * priorite plus petite que celle passee en parametre. - Si le parametre
	 * "plusPetit" est faux, les elements a enlever doivent avoir la priorite
	 * plus grande que celle passee en parametre.
	 * 
	 * Les elements enleves sont retournes dans une matrice dynamique de type
	 * HashMap<K,T>. La cle (K) de chaque emplacement dans la matrice est la
	 * priorite de type Integer, tandis que la valeur (T) est un tableau liste
	 * (ArrayList) de tous les elements enleves qui ont cette priorite. Une
	 * valeur nulle est retournee si aucun element n'est enleve.
	 * 
	 * @param priorite
	 *            La priorite
	 * @return la matrice dynamique de type HashMap<K,T> de tous les elements
	 *         enleves.
	 */
	public Map<Integer, List<T>> enlever(int priorite, boolean plusPetit) {

		Map<Integer, List<T>> map = new HashMap<Integer, List<T>>();
		int indice = 1;
		List<T> listeRetournee = new ArrayList<>();
		if (plusPetit) {
			while (indice < priorite) {
				listeRetournee = enlever(indice);

				if (listeRetournee != null) {
					map.put(indice, listeRetournee);
				}
				indice++;
			}
		} else {
			int taille = listeAttente.size();

			for (int j = taille - 1; j >= 0; j--) {
				int x = listeAttente.get(j).obtenirPriorite();

				if (x > priorite) {

					map.put(x, enlever(x));
				}
			}
		}
		if (map.isEmpty()) {
			map = null;
		}
		return map;
	}

	@Override
	/**
	 * Remplace la priorite de tous les elements de la file dont la priorite est
	 * egale a "anciennePriorite" par "nouvellePriorite". La priorite
	 * "nouvellePriorite" ne doit pas etre inferieure a 1. Assurez-vous que la
	 * file est ordonnee apres le remplacement.
	 * 
	 * @param anciennePriorite
	 *            L'ancienne priorite
	 * @param nouvellePriorite
	 *            La nouvelle priorite
	 * 
	 * @return Vrai si au moins un changement de priorite a ete effectue
	 */
	public boolean remplacer(int anciennePriorite, int nouvellePriorite) {
		boolean remplace = false;

		List<T> listeTemp = new ArrayList<>();
		if (listeAttente != null && !listeAttente.isEmpty() && nouvellePriorite >= 1) {
			listeTemp = enlever(anciennePriorite);
			if (listeTemp != null && !listeTemp.isEmpty()) {

				for (int i = 0; i < listeTemp.size(); i++) {
					listeTemp.get(i).modifierPriorite(nouvellePriorite);
				}
				placer(listeTemp);
				remplace = true;
			} else
				remplace = false;
		}

		return remplace;
	}

	@Override
	/**
	 * Retourne le nombre d'elements dont la priorite est egale a celle passee
	 * en parametre.
	 * 
	 * @param priorite
	 *            La priorite
	 * @return Le nombre d'elements dont la priorite = "priorite"
	 */
	public int ObtenirNbElments(int priorite) {
		int nbElts = 0;
		if (listeAttente != null && !listeAttente.isEmpty()) {
			for (int i = 0; i < listeAttente.size(); i++) {
				if (listeAttente.get(i).obtenirPriorite() == priorite) {
					nbElts++;
				}
			}
		}
		return nbElts;
	}

	@Override
	/**
	 * Verifie si la file existante est vide.
	 * 
	 * @return Vrai si la file est vide, sinon faux
	 */
	public boolean estVide() {

		return listeAttente.isEmpty();
	}

	@Override
	/**
	 * Retourne un iterateur qui permet de parcourir la file.
	 * 
	 * @return Iterateur sur la file.
	 */
	public Iterator<T> iterateur() {
		Iterator<T> it = listeAttente.iterator();
		return it;
	}

}
