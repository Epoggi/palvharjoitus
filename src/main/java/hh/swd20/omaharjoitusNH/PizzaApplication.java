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
import hh.swd20.omaharjoitusNH.domain.Ainekset;
import hh.swd20.omaharjoitusNH.domain.AinesRepository;

@SpringBootApplication
public class PizzaApplication {
	private static final Logger log = LoggerFactory.getLogger(PizzaApplication.class); // uusi loggeriattribuutti

	/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.nh1900646.Bookstore.domain.Book;
import hh.swd20.nh1900646.Bookstore.domain.BookRepository;
import hh.swd20.nh1900646.Bookstore.domain.Category;
import hh.swd20.nh1900646.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookDemo(BookRepository bRep, CategoryRepository cRep) {
		return (args) -> {
			log.info("save a couple of categories");
			Category category1 = new Category("Guide");
			cRep.save(category1);
			cRep.save(new Category("Comic"));
			cRep.save(new Category("Adult"));
			cRep.save(new Category("Educational"));

			log.info("fetch all categories");
			for (Category category : cRep.findAll()) {
				log.info(category.toString());
				}
			
			log.info("save a couple of books");
			bRep.save(new Book("When god was born", "R. Walker", "isbn123", 1989, 49.9, cRep.findByName("Comic").get(0)));
			bRep.save(new Book("When everything ends", "R. Walker", "isbn124", 2021, 34.9,cRep.findByName("Comic").get(0)));
			bRep.save(new Book("How I will save the universe", "N. H.", "isbn125", 2030, 69.9,cRep.findByName("Comic").get(0)));
			bRep.save(new Book("Better coding", "T. B.", "ibsn3125", 2020, 59.90, category1));
			
			
			log.info("fetch all books");
			for (Book book : bRep.findAll()) {
				log.info(book.toString());
			}

			
		};
	}
}
*/

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
	// testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner pizzaDemo(PizzaRepository piRep, AinesRepository aRep, PohjaRepository poRep) {
		return (args) -> {
			log.info("Ainekset");
			aRep.save(new Ainekset("Tonnikala", "Atlanti"));
			aRep.save(new Ainekset("Ananas", "Peru"));
			aRep.save(new Ainekset("Pinaatti", "Suomi"));

			log.info("fetch all ainekset");
			for (Ainekset ainekset : aRep.findAll()) {
				log.info(ainekset.toString());
				}
			log.info("Pohjat");
			poRep.save(new Pohja("Ruispohja", "norm"));
			poRep.save(new Pohja("Vehnäpohja", "norm"));
			poRep.save(new Pohja("Munapohja", "glut"));
			poRep.save(new Pohja("Vegepohja", "lak"));
			
			log.info("Pizzat");
			piRep.save(new Pizza("Suomalainen", 7.50, poRep.findByNimi("Ruispohja").get(0), aRep.findByNimi("Ananas").get(0)));
			piRep.save(new Pizza("Italialainen",8.50,poRep.findByNimi("Vehnäpohja").get(0), aRep.findByNimi("Ananas").get(0)));
			piRep.save(new Pizza("Karppaaja", 10.00,poRep.findByNimi("Munapohja").get(0), aRep.findByNimi("Ananas").get(0)));
			piRep.save(new Pizza("Vegeilijä", 15.00, poRep.findByNimi("Vegepohja").get(0), aRep.findByNimi("Ananas").get(0)));
			
			
			log.info("fetch all pizzas");
			for (Pizza pizza : piRep.findAll()) {
				log.info(pizza.toString());
			}

};}}
