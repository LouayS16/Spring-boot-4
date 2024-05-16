package com.louay.Medecins.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.louay.Medecins.entities.Medecin;
import com.louay.Medecins.entities.Specialite;
import com.louay.Medecins.repos.MedecinRepository;
import com.louay.Medecins.repos.SpecialiteRepository;

@Service

public class MedecinServiceImpl implements MedecinService {
	@Autowired
	MedecinRepository medecinRepository;

	@Autowired
	SpecialiteRepository specialiteRepository;

	@Override
	public Medecin saveMedecin(Medecin a) {
		return medecinRepository.save(a);
	}

	@Override
	public Medecin updateMedecin(Medecin a) {
		return medecinRepository.save(a);

	}

	@Override
	public void deleteMedecin(Medecin a) {
		medecinRepository.delete(a);
	}

	@Override
	public void deleteMedecinById(Long id) {
		medecinRepository.deleteById(id);

	}

	@Override
	public Medecin getMedecin(Long id) {
		return medecinRepository.findById(id).get();

	}

	@Override
	public List<Medecin> getAllMedecins() {
		return medecinRepository.findAll();
	}

	@Override
	public Page<Medecin> getAllMedecinsParPage(int page, int size) {
		return medecinRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Medecin> findByNomMedecin(String nomMedecin) {

		return medecinRepository.findByNomMedecin(nomMedecin);
	}

	@Override
	public List<Medecin> findByNomMedecinContains(String nomMedecin) {

		return medecinRepository.findByNomMedecinContains(nomMedecin);
	}

	@Override
	public List<Medecin> findByfindByNomSalaire(String nom, int salaire) {
		return medecinRepository.findByNomSalaire(nom, salaire);
	}

	@Override
	public List<Medecin> findBySpecialite(Specialite specialite) {
		return medecinRepository.findBySpecialite(specialite);
	}

	@Override
	public List<Medecin> findBySpecialiteIdA(Long id) {

		return medecinRepository.findBySpecialiteIdA(id);
	}

	@Override
	public List<Medecin> findByOrderByNomAsc() {

		return medecinRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Medecin> trierNomSalaire() {
		return medecinRepository.trierNomSalaire();
	}

	@Override
	public List<Specialite> getAllSpecialites() {
		return specialiteRepository.findAll();

	}

}
