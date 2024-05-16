package com.louay.Medecins.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMed", types = { Medecin.class })
public interface MedecinProjection {
	public String getNomMedecin();
}