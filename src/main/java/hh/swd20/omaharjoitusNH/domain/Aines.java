package hh.swd20.omaharjoitusNH.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aines {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	private String nimi, sisalto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pohja")
	private List<Pizza> pizzat;

	public Aines() {
		super();
		this.nimi = null;
		this.sisalto = null;
	}

	public Aines(String nimi, String sisalto) {
		super();
		this.nimi = nimi;
		this.sisalto = sisalto;
	}
	public void setPizzas(List<Pizza> pizzat) {
		this.pizzat = pizzat;
	}

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

	public String getSisalto() {
		return sisalto;
	}

	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}

	@Override
	public String toString() {
		return "Aines [nimi=" + nimi + ", sisalto=" + sisalto + "]";
	}
	
	
	
}