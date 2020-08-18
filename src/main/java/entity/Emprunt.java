/**
 * 
 */
package entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author perse
 *
 */
@Entity
@Table(name = "emprunt")

public class Emprunt {
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "DATE_DEBUT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date_debut;

	@Column(name = "DATE_FIN", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date_fin;

	@Column(name = "DELAI", length = 10, nullable = false)
	private String delai;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_Emp"), inverseJoinColumns = @JoinColumn(name = "ID_LIV"))
	private Set<Livre> livres;

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai
				+ ", id_client=" + client + ", livres=" + livres + "]";
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
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the delai
	 */
	public String getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(String delai) {
		this.delai = delai;
	}

	/**
	 * @return the id_client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param id_client the id_client to set
	 */
	public void setClient( Client id_client) {
		this.client = id_client;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public Emprunt() {
		super();
	}

}
