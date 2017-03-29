package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Drzava extends Model{

//	@Required
	
	@Column(nullable = false)
	public String naziv;
//	@Required
//	@MinSize(5)
	@Column(nullable = false, unique = true)
	public String oznaka;
	
	@OneToMany(mappedBy = "drzava")
	public List<NaseljenoMesto> naseljenaMeste;

	public Drzava(String oznaka, String naziv) {
		super();
		this.naziv = naziv;
		this.oznaka = oznaka;
		naseljenaMeste = new ArrayList<NaseljenoMesto>();
	}

	
	
}
