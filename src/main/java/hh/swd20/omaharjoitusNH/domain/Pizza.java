package hh.swd20.omaharjoitusNH.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Pizza {
	//Atribuutit
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@NotNull
		@Size(min=5, max=15)
		private String nimi;
		@NotNull
		@DecimalMax("15.0") 
		@DecimalMin("5.0")
		private double hinta;

		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "pohjaid")
		private Pohja pohja;
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "ainesid")
		private Aines aines;
//Monta täytettä = private List<Aines> ainekset, vertaa bookstore List<Book> books;
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

		public Aines getAines() {
			return aines;
		}

		public void setAines(Aines aines) {
			this.aines = aines;
		}

		public Pizza(String nimi, double hinta, Pohja pohja, Aines aines) {
			super();
			this.id = id;
			this.nimi = nimi;
			this.hinta = hinta;
			this.pohja = pohja;
			this.aines = aines;
		}

		public Pizza() {
			super();
			this.nimi = null;
			this.hinta = 0.0;
		}

		@Override
		public String toString() {
			return "Pizza [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + ", pohja=" + pohja + ", ainekset="
					+ aines + "]";
		}
		
		
}
