package com.louay.Medecins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.louay.Medecins.entities.Medecin;
import com.louay.Medecins.entities.Specialite;
import com.louay.Medecins.service.MedecinService;

import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedecinController {
	@Autowired
	MedecinService medecinService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}


	@RequestMapping("/ListeMedecins")
	public String listeMedecins(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
 {
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("Medecins", meds);
		modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeMedecins";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Specialite> spc = medecinService.getAllSpecialites();
		modelMap.addAttribute("Medecin", new Medecin());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("Specialite", spc);

		return "formMedecin";
	}
	
	@RequestMapping("/saveMedecin")
	public String saveMedecin(@Valid Medecin medecin, BindingResult bindingResult, 
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
 {

		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) return "formMedecin";
		
		if (medecin.getIdMedecin()==null) //ajout
			isNew=true;
		
		medecinService.saveMedecin(medecin);
		
		if (isNew) //ajout
		{
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		currentPage = meds.getTotalPages()-1;
		}
		else //modif
		currentPage=page;

		
		return ("redirect:/ListeMedecins?page="+currentPage+"&size="+size);

	}
	

	@RequestMapping("/supprimerMedecin")
	public String supprimerMedecin(@RequestParam("id") Long id,
							ModelMap modelMap,
							@RequestParam (name="page",defaultValue = "0") int page,
							@RequestParam (name="size", defaultValue = "2") int size)
		 {
		medecinService.deleteMedecinById(id);
		
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, 
				size);
				modelMap.addAttribute("Medecin", meds);
				modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
				
		return "listeMedecins";
	}

	@RequestMapping("/modifierMedecin")
	public String editerMedecin(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		List<Specialite> typs = medecinService.getAllSpecialites();
		Medecin p = medecinService.getMedecin(id);
		modelMap.addAttribute("Medecin", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("Specialite", typs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);


		return "formMedecin";
	}

	@RequestMapping("/updateMedecin")
	public String updateMedecin(@ModelAttribute("medecin") Medecin medecin, ModelMap modelMap) throws ParseException {
		

		medecinService.updateMedecin(medecin);
		List<Medecin> meds = medecinService.getAllMedecins();
		modelMap.addAttribute("Medecins", meds);
		
		return "listeMedecins";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}
}