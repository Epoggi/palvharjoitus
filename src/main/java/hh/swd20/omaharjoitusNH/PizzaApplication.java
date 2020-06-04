package hh.swd20.omaharjoitusNH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.omaharjoitusNH.domain.Pizza;
import hh.swd20.omaharjoitusNH.domain.PizzaRepository;
import hh.swd20.omaharjoitusNH.domain.Pohja;
import hh.swd20.omaharjoitusNH.domain.PohjaRepository;
import hh.swd20.omaharjoitusNH.domain.Aines;
import hh.swd20.omaharjoitusNH.domain.AinesRepository;

@SpringBootApplication
public class PizzaApplication {
	private static final Logger log = LoggerFactory.getLogger(PizzaApplication.class); // uusi loggeriattribuutti



	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
	// testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner pizzaDemo(PizzaRepository piRep, AinesRepository aRep, PohjaRepository poRep) {
		return (args) -> {
			log.info("Ainekset");
			aRep.save(new Aines("Tonnikala", "Atlanti"));
			aRep.save(new Aines("Ananas", "Peru"));
			aRep.save(new Aines("Pinaatti", "Suomi"));

			log.info("fetch all ainekset");
			for (Aines aines : aRep.findAll()) {
				log.info(aines.toString());
				}
			log.info("Pohjat");
			poRep.save(new Pohja("Ruispohja", "norm"));
			poRep.save(new Pohja("Vehnäpohja", "norm"));
			poRep.save(new Pohja("Munapohja", "glut"));
			poRep.save(new Pohja("Vegepohja", "lak"));
			
			log.info("Pizzat");
			piRep.save(new Pizza("Suomalainen", 7.50, poRep.findByNimi("Ruispohja").get(0), aRep.findByNimi("Tonnikala").get(0)));
			piRep.save(new Pizza("Italialainen",8.50,poRep.findByNimi("Vehnäpohja").get(0), aRep.findByNimi("Ananas").get(0)));
			piRep.save(new Pizza("Karppaaja", 10.00,poRep.findByNimi("Munapohja").get(0), aRep.findByNimi("Ananas").get(0)));
			piRep.save(new Pizza("Vegeilijä", 15.00, poRep.findByNimi("Vegepohja").get(0), aRep.findByNimi("Pinaatti").get(0)));
			
			
			log.info("fetch all pizzas");
			for (Pizza pizza : piRep.findAll()) {
				log.info(pizza.toString());
			}

};}}
