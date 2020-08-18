/**
 * 
 */
package entity;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author perse
 */

@Entity
@Table(name = "livre")

public class Livre {
	@Id
	@Column (name ="ID")
	private int id;
	
	@Embedded
	private Auteur  auteurEmbedded;

	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;

	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt>emprunts;

	public Livre() {
		super();
	}
	
	

	/**
	 * @return the auteurEmbedded
	 */
	public Auteur getAuteurEmbedded() {
		return auteurEmbedded;
	}



	/**
	 * @param auteurEmbedded the auteurEmbedded to set
	 */
	public void setAuteurEmbedded(Auteur auteurEmbedded) {
		this.auteurEmbedded = auteurEmbedded;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
	
	@Override
	public String toString() {
		return "Livre[id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
