package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
		@Column(nullable = false )
		public String adresa;
		@Column(nullable = false, unique = true)
		public String naziv;
		@Column(nullable = false)
		public String PIB;
<<<<<<< HEAD
=======
		
		@ManyToOne
		public Radnik radnik;
		
		
		
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
		public Preduzece(String adresa, String naziv, String pib) {
			super();
			this.adresa = adresa;
			this.naziv = naziv;
			this.PIB = pib;
		}
<<<<<<< HEAD
		
		@OneToMany (mappedBy ="preduzece")
		public List<GrupaRobe> grupeRoba;
=======
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
}