package ca.uqam.inf2120.tp1.adt;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP1
 * 
 * FileAttenteTda : Cette interface d�finit les services d'une file d'attente bas�e dans laquelle 
 * les �l�ments sont organis�s en ordre d�croissant selon leur priorit� et leur date / heure de cr�ation. 
 * Les priorit�s commencent � 1  jusqu'� n, d'o� 1 est la plus grande priorit�, tandis que n est la
 * plus petite. Les �l�ments de la plus grande priorit� sont ajout�s au d�but de la liste. Les �l�ments
 * de la m�me priorit� sont ordonn�s selon la date et l'heure de cr�ation 
 * 
 * @author Ismael Doukoure
 * @version 8 f�vrier 2017
 */
public interface FileAttenteTda<T extends OrdonnableParPrioriteEtDateHeure> {

	/**
	 * Place l'�l�ment "elt" dans la file selon sa priorit�. Les �l�ments de la
	 * plus grande priorit� sont plac�s au d�but de la file. Si "elt" a la m�me
	 * priorit� qu'un autre �l�ment qui existe d�j� dans la file, il doit �tre 
	 * plac� avant cet �l�ment si sa date / heure de cr�ation est plus ancienne 
	 * que ce dernier, sinon il est plac� apr�s. L'�l�ment ne doit pas �tre plac�
	 * dans la file  si une des conditions suivantes est vraie :
	 *   - L'�l�ment est null.
	 *   - L'�l�ment existe d�j� dans la file (�l�ments identiques sans tenir compte 
	 *     de leur priorit� et leur date / heure de cr�ation).
	 *   - La priorit� de l'�l�ment est inf�rieure � 1.
	 *
	 * @param elt L'�l�ment � ajouter
	 * @return true si "elt" est ajout�, sinon false
	 */
	public boolean placer(T elt);

	/**
	 * Place tous les �l�ments de la liste pass�e en param�tre dans la file.
	 * Tous les �l�ments sont placer dans la file selon leur priorit�. Les �l�ments de
	 * la plus grande priorit� sont plac�s au d�but de la file. Si un �l�ment de la liste
	 * a la m�me priorit� qu'un autre �l�ment qui existe d�j� dans la file, il doit �tre 
	 * plac� avant cet �l�ment si sa date / heure de cr�ation est plus ancienne que ce 
	 * dernier, sinon il est plac� apr�s. L'�l�ment de la liste pass�e en param�tre 
	 * ne doit pas �tre plac� dans la file si une des conditions suivantes est vraie :
	 *   - L'�l�ment � placer est null.
	 *   - L'�l�ment existe d�j� dans la file (�l�ments identiques sans tenir compte
	 *     de leur priorit� et leur date / heure de cr�ation).
	 *   - La priorit� de l'�l�ment est inf�rieure � 1.
	 * 
	 * La liste pass�e en param�tre peut �tre nulle ou vide.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les �l�ments doivent �tre plac�s dans la file
	 */
	public void placer(List<T> liste);

	/**
	 * Enl�ve l'�l�ment "elt" dans la file. Aucune action � faire si "elt" est nul ou s'il 
	 * n'existe pas dans la file. L'�l�ment � enlever doit �tre �gal � celui pass� en param�tre ("elt") 
	 * sans tenir compte de leur priorit� et leur date / heure de cr�ation.
	 * 
	 * @param elt L'�l�ment � enlever
	 * @return Vrai si l'�l�ment est enlev�
	 */
	public boolean enlever(T elt);

	/**
	 * Enl�ve tous les �l�ments de la liste pass�e en param�tre dans la file.
	 * Tous les �l�ments non enlev�s de la liste pass�e en param�tre sont retourn�s dans
	 * un tableau liste (ArrayList). La comparaison entre les �l�ments de la liste pass�e
	 * en param�tre et  de la file doit se faire sans tenir compte de leur priorit� et leur 
	 * date / heure de cr�ation. La liste pass�e en param�tre peut �tre nulle ou vide.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les �l�ments doivent �tre enlev�s
	 * @return Le tableau liste (ArrayList) des �l�ments non enlev�s, nul si tous les �l�ments
	 *         sont enlev�s.
	 */
	public List<T> enlever(List<T> liste);
	
	
	/**
	 * Enl�ve tous les �l�ments dont la priorit� est �gale � celle pass�e en
	 * param�tre. Les �l�ments enlev�s sont retourn�s dans un tableau liste.
	 * Une valeur nulle est retourn�e si aucun �l�ment n'est enlev�.
	 * 
	 * @param priorite La priorit� des �l�ments � enlever
	 * @return Le tableau liste des �l�ments enlev�s, null si aucun �l�ment n'a �t� enlev�
	 */
	public List<T> enlever(int priorite);

	
	/**
	 * Enl�ve les �l�ments de la file selon les conditions suivantes :
	 *   - Si le param�tre "plusPetit" est vrai, les �l�ments � enlever doivent
	 *     avoir la priorit� plus petite que celle pass�e en param�tre.
	 *   - Si le param�tre "plusPetit" est faux, les �l�ments � enlever doivent
	 *     avoir la priorit� plus grande que celle pass�e en param�tre.
	 *     
	 * Les �l�ments enlev�s sont retourn�s dans une matrice dynamique de type HashMap<K,T>.
	 * La cl� (K) de chaque emplacement dans la matrice est la priorit� de type Integer, tandis
	 * que la valeur (T) est un tableau liste (ArrayList) de tous les �l�ments enlev�s qui ont
	 * cette priorit�. Une valeur nulle est retourn�e si aucun �l�ment n'est enlev�.
	 * 
	 * @param priorite La priorit�
	 * @return la matrice dynamique de type HashMap<K,T> de tous les �l�ments enlev�s.
	 */
	public Map<Integer, List<T>> enlever(int priorite, boolean plusPetit);
	
     
	/**
     * Remplace la priorit� de tous les �l�ments de la file dont la priorit� est �gale � 
     * "anciennePriorite" par "nouvellePriorite". La priorit� "nouvellePriorite"
     * ne doit pas �tre inf�rieure � 1. Assurez-vous que la file est ordonn�e apr�s le 
     * remplacement.
     * 
	 * @param anciennePriorite L'ancienne priorit� 
	 * @param nouvellePriorite La nouvelle priorit�
	 * 
	 * @return Vrai si au moins un changement de priorit� a �t� effectu�
	 */
     public boolean remplacer(int anciennePriorite, int nouvellePriorite);


   /**
    * Retourne le nombre d'�l�ments dont la priorit� est �gale � celle pass�e en param�tre.
    * 
    * @param priorite La priorit� 
    * @return Le nombre d'�l�ments dont la priorit� = "priorite" 
    */
     public int ObtenirNbElments(int priorite);
      
	/**
	 * V�rifie si la file existante est vide.
	 * 
	 * @return Vrai si la file est vide, sinon faux
	 */
	 public boolean estVide();

	/**
	 * Retourne un it�rateur qui permet de parcourir la file.
	 * 
	 * @return It�rateur sur la file.
	 */
	 public Iterator<T> iterateur();

}
