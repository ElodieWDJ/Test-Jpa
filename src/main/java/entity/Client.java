/**
 * 
 */
package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author perse
 *
 */

@Entity
@Table(name = "client")

public class Client {
@Id
private int id;

@Column(name = "NOM", length = 50, nullable = false)
private String nom;

@Column(name = "PRENOM", length = 50, nullable = false)
private String prenom;


@OneToMany(mappedBy="client")
private List<Emprunt>listEmprunt;

public Client () {
	super();
}

@Override
public String toString() {
	return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
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
 * @return the nom
 */
public String getNom() {
	return nom;
}

/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}

/**
 * @return the prenom
 */
public String getPrenom() {
	return prenom;
}

/**
 * @param prenom the prenom to set
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
}
