package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.MatriculaService;
import domain.Matricula;

@Controller
public class MatriculaController {
	
	@Autowired
	MatriculaService matriculaService;

	@RequestMapping(value = "/matricula", method = RequestMethod.POST)
	String saveMatricula(@ModelAttribute Matricula matricula, ModelMap model) {
		System.out.println("saving: " + matricula.getId());
		matriculaService.save(matricula);
		return showMatricula(matricula.getId(), model);
	}
	
	@RequestMapping(value = "/add-matricula", method = RequestMethod.GET)
	String addNewMatricula(@RequestParam(required = false) Long id, ModelMap model) {
		Matricula matricula = id == null ? new Matricula() : matriculaService.get(id);
		model.addAttribute("matricula", matricula);
		return "add-matricula";
	}
	
	@RequestMapping(value = "/matricula", method = RequestMethod.GET)
	String showMatricula(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Matricula matricula = matriculaService.get(id);
			model.addAttribute("matricula", matricula);
			return "matricula";
		} else {
			Collection<Matricula> matriculas = matriculaService.getAll();
			model.addAttribute("matriculas", matriculas);
			return "matriculas";
		}
	}

}
