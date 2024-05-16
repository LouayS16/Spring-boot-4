package com.louay.Medecins.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.louay.Medecins.entities.Medecin;
import com.louay.Medecins.entities.Specialite;




@RepositoryRestResource(path="rest")
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	List<Medecin> findByNomMedecin(String nom);
	List<Medecin> findByNomMedecinContains(String nom); 
	
	/*@Query("select d from Doctor d where d.nameDoctor like %?1 and d.ageDoctor > ?2")
	List<Doctor> findByNameAge (String nom, int age);*/
	@Query("select m from Medecin m where m.nomMedecin like %:nom and m.salaire > :salaire")
	List<Medecin> findByNomSalaire (@Param("nom") String nom,@Param("salaire") int salaire);
	
	@Query("select m from Medecin m where m.specialite = ?1")
	List<Medecin> findBySpecialite (Specialite specialite);
	
	List<Medecin> findBySpecialiteIdA(Long id);
	List<Medecin> findByOrderByNomAsc();
	
	
	@Query("select m from Medecin m order by m.nomMedecin ASC, m.salaire DESC")
	List<Medecin> trierNomSalaire ();
}
