package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class NaseljenoMesto extends Model{
	
	@Column(nullable = false)
	public String naziv;
	@Column(nullable = false, unique = true)
	public String oznaka;
	public String postanskiBroj;
	@ManyToOne
	public Drzava drzava;
	
	@OneToMany (mappedBy = "naseljenoMesto")
	public List<Preduzece> preduzeca;
	
	public NaseljenoMesto(String oznaka, String naziv, String postanskiBroj, Drzava drzava) {
		super();
		this.naziv = naziv;
		this.oznaka = oznaka;
		this.postanskiBroj = postanskiBroj;
		this.drzava = drzava;
	}
	
	

}
