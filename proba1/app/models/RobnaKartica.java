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
	public String prometUlazaKolicine;
	@Column(nullable = true)
	public String prometUlazaVrednosti;
	@Column(nullable = true)
	public String prometIzlazaKolicine;
	@Column(nullable = true)
	public String prometIzlazaVrednosti;
	@Column(nullable = true)
	public Integer ukupnaKolicina;
	@Column(nullable = true)
	public Double ukupnaVrednost;
	
}
