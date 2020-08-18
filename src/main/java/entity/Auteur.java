/**
 * 
 */
package entity;

import javax.persistence.Embeddable;

/**
 * @author perse
 *Respecter le nom et le type des colonnes
 *il faut que ce soit en cohérance avec la bdd physique
 */

@Embeddable
public class Auteur {
	
	@Override
	public String toString() {
		return "Auteur [titre=" + titre + ", auteur=" + auteur + "]";
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	private String titre;
	private String auteur;
	private String getTitre() {
		return titre;
	}

}
