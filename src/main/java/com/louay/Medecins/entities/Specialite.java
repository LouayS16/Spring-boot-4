package com.louay.Medecins.entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSpc;
	private String nomSpc;
	private String descriptionSpc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "Specialite")
	private List<Medecin> Medecins;

	public  Specialite() {
	}

	public Specialite(String nomSpc, String descriptionSpc, List<Medecin> Medecins) {
		super();
		this.nomSpc = nomSpc;
		this.descriptionSpc = descriptionSpc;
		this.Medecins = Medecins;
	}

	public Long getIdSpc() {
		return idSpc;
	}

	public void setIdSpc(Long idSpc) {
		this.idSpc = idSpc;
	}

	public String getNomSpc() {
		return nomSpc;
	}

	public void setNomSpc(String nomSpc) {
		this.nomSpc = nomSpc;
	}

	public String getDescriptionSpc() {
		return descriptionSpc;
	}

	public void setDescriptionSpc(String descriptionSpc) {
		this.descriptionSpc = descriptionSpc;
	}

	public List<Medecin> getMedecins() {
		return Medecins;
	}

	public void setMedecins(List<Medecin> Medecins) {
		this.Medecins = Medecins;
	}
}