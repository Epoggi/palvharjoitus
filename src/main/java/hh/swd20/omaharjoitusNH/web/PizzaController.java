package hh.swd20.omaharjoitusNH.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
	@RequestMapping(value = "pizzas", method = RequestMethod.GET)
	public String getAllPizzas(Model model) {
		List<Pizza> pizzas = (List<Pizza>) pizRep.findAll();
		model.addAttribute("pizzas", pizzas);
		return "pizzat";
	}
	
}
