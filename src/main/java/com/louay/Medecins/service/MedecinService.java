package com.louay.Medecins.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.louay.Medecins.entities.Medecin;
import com.louay.Medecins.entities.Specialite;


public interface MedecinService {
Medecin saveMedecin(Medecin a);
Medecin updateMedecin(Medecin a);
void deleteMedecin(Medecin a);
void deleteMedecinById(Long id);
Medecin getMedecin(Long id);
List<Medecin> getAllMedecins();

List<Medecin> findByNomMedecin(String nomMedecin);
List<Medecin> findByNomMedecinContains(String nomMedecin);
List<Medecin> findByfindByNomSalaire (String nom, int salaire);
List<Medecin> findBySpecialite (Specialite specialite);
List<Medecin> findBySpecialiteIdA(Long id);
List<Medecin> findByOrderByNomAsc();
List<Medecin> trierNomSalaire();

Page<Medecin> getAllMedecinsParPage(int page, int size);

List<Specialite> getAllSpecialites();


}