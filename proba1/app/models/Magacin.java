package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.ManyToOne;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
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
	
<<<<<<< HEAD
=======
	@ManyToOne
	public Radnik radnik;
	
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
	public Magacin(){
		
	}
	public Magacin(String naziv) {
		super();
		this.naziv = naziv;
		artikli = new ArrayList<Artikal>();
	}
}
