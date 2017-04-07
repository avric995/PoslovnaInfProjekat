package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class RobnaKartica extends Model {
	@Column(nullable = false)
	public Double cena;
	@Column(nullable = false)
	public Integer pocStanjeKolicine;
	@Column(nullable = false)
	public Double pocStanjeVrednosti;
	@Column(nullable = true)
	public Integer prometUlazaKolicine;
	@Column(nullable = true)
	public Integer prometUlazaVrednosti;
	@Column(nullable = true)
	public Integer prometIzlazaKolicine;
	@Column(nullable = true)
	public Integer prometIzlazaVrednosti;
	@Column(nullable = true)
	public Integer ukupnaKolicina;
	@Column(nullable = true)
	public Double ukupnaVrednost;
	
	@ManyToOne
	public Roba roba;
	
	@ManyToOne
	public Magacin magacin;
	
	@ManyToOne
	public PoslovnaGodina poslovnaGodina;
	
	@OneToMany(mappedBy = "robnaKartica")
	public List<AnalitikaMagKartice> analitikeMagKartica;
	
}
