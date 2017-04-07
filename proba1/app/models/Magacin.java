package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Magacin extends Model {
	@Column(nullable = false, length = 30)
	public String naziv;
	@OneToMany(mappedBy = "magacin")
	public List<Artikal> artikli;
	
	@OneToMany(mappedBy = "magacin")
	public List<PrometniDokument> prometniDokumenti;
	
	@OneToMany(mappedBy = "magacin")
	public List<RobnaKartica> robneKartice;
	
	@ManyToOne
	public Radnik radnik;
	
	@ManyToOne
	public Preduzece preduzece;
	
	public Magacin(){
		
	}
	public Magacin(String naziv) {
		super();
		this.naziv = naziv;
		artikli = new ArrayList<Artikal>();
	}
}
