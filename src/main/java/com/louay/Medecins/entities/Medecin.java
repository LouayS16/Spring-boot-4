package com.louay.Medecins.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomMedecin;
	@NotNull
	@Size (min = 4,max = 15)
	private String prenomMedecin;
	@Min(value = 1000)
	@Max(value = 100000)
	private Double salaire;
	@Size (min = 8,max = 8)
	private int tel;
	
	@ManyToOne
	private Specialite Specialite;
	

	public Medecin() {
		super();
	}

	public Medecin(String nomMedecin, String prenomMedecin  ,  Double salaire , int tel ) {
		super();
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.salaire = salaire;
		this.tel = tel;
	}

	public Long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}
	
	

	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}
	

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	

	
	public Specialite getSpecialite() {
		return Specialite;
	}

	public void setSpecialite(Specialite specialite) {
		Specialite = specialite;
	}

	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", prenomMedecin=" + prenomMedecin
				+ ", tel=" + tel + ", salaire=" + salaire + "]";
	}

	
}