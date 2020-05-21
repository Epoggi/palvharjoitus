  package hh.swd20.omaharjoitusNH.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.omaharjoitusNH.domain.AinesRepository;
import hh.swd20.omaharjoitusNH.domain.Pizza;
import hh.swd20.omaharjoitusNH.domain.PizzaRepository;
import hh.swd20.omaharjoitusNH.domain.PohjaRepository;

@Controller

public class PizzaController {
	@Autowired
	AinesRepository aRep;
	@Autowired
	PohjaRepository pRep;
	@Autowired
	PizzaRepository pizRep;
	
	@RequestMapping(value = "/")
	public String frontPage() {
		return "mainpage";
	}
	//listaus
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public String getAllPizzas(Model model) {
		List<Pizza> pizzas = (List<Pizza>) pizRep.findAll();
		model.addAttribute("pizzas", pizzas);
		return "pizzat";
	}
	//pizza lomakkeen muodostaminen
	@RequestMapping(value="/pizzalomake", method = RequestMethod.GET)
	public String getNewPizzaForm (Model model) {
		model.addAttribute("pizza", new Pizza());
		model.addAttribute("pohjat", pRep.findAll());
		model.addAttribute("ainekset", aRep.findAll());
		return "pizzanteko";
	}
	//lomakkeella syötettyjen pizza tietojen tallentaminen
	@RequestMapping(value="/luopizza", method = RequestMethod.POST)
	public String savePizza(@ModelAttribute Pizza pizza) {
		pizRep.save(pizza);
		return "redirect:/pizzas";
	}
	//Pizzan poisto
	@RequestMapping(value = "/deletepizza/{id}", method = RequestMethod.GET)
	public String deletePizza(@PathVariable("id") Long id) {
		pizRep.deleteById(id);
		return "redirect:../pizzas";
	}
	//Pizzan muokkaus
	@RequestMapping(value="/editpizza/{id}", method =RequestMethod.GET)
	public String editPizza(@PathVariable("id") Long id, Model model) {
		model.addAttribute("pizza", pizRep.findById(id));
		model.addAttribute("pohjat", pRep.findAll());
		model.addAttribute("ainekset", aRep.findAll());
		return "pizzanteko";
	}
	
}
