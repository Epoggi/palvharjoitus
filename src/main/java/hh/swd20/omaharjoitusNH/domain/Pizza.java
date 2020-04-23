package hh.swd20.omaharjoitusNH.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*
//h2 testidatabase käyttöön
//Merkitään olio database olioksi
@Entity
public class Book {
//Atribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title, author, isbn;
	private int year;
	private double price;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;*/
@Entity
public class Pizza {
	//Atribuutit
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String nimi;
		private double hinta;

		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "pohjaid")
		private Pohja pohja;
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "ainesid")
		private Ainekset ainekset;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNimi() {
			return nimi;
		}

		public void setNimi(String nimi) {
			this.nimi = nimi;
		}

		public double getHinta() {
			return hinta;
		}

		public void setHinta(double hinta) {
			this.hinta = hinta;
		}

		public Pohja getPohja() {
			return pohja;
		}

		public void setPohja(Pohja pohja) {
			this.pohja = pohja;
		}

		public Ainekset getAinekset() {
			return ainekset;
		}

		public void setAinekset(Ainekset ainekset) {
			this.ainekset = ainekset;
		}

		public Pizza(long id, String nimi, double hinta, Pohja pohja, Ainekset ainekset) {
			super();
			this.id = id;
			this.nimi = nimi;
			this.hinta = hinta;
			this.pohja = pohja;
			this.ainekset = ainekset;
		}

		public Pizza() {
			super();
			this.nimi = null;
			this.hinta = 0.0;
		}

		@Override
		public String toString() {
			return "Pizza [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + ", pohja=" + pohja + ", ainekset="
					+ ainekset + "]";
		}
		
		
}
