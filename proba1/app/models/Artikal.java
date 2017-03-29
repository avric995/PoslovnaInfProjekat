package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Artikal extends Model {
	@Column(nullable = false, length = 6)
	public String sifra;
	@Column(nullable = false, length = 6)
	public float pakovanje;
	@Column(nullable = true, length = 6)
	public String jedinicaMere;
	@Column(nullable = false, unique = true, length = 40)
	public String naziv;
	@ManyToOne
	public Magacin magacin;
	
	public Artikal(String sifra, String naziv, String jedinica, float pakovanje, Magacin magacin) {
		super();
		this.naziv = naziv;
		this.sifra = sifra;
		this.pakovanje = pakovanje;
		this.jedinicaMere = jedinica;
		this.magacin = magacin;
	}
}
