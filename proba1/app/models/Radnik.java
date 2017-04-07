package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Radnik extends Model {
		@Column(nullable = false, unique = true)
		public String sifra;
		@Column(nullable = false)
		public String ime;
		@Column(nullable = false)
		public String prezime;
		@Column(nullable = true)
		public String devojacko;
		@Column(nullable = false)
		public String roditelj;
		@Column(nullable = false)
		public Date datumRodjenja;
		@Column(nullable = false, unique = true)
		public String brojLicneKarte;
		@Column(nullable = false)
		public String brojRadneKnjizice;
		@Column(nullable = false, unique = true)
		public String JMBG;
		@Column(nullable = true)
		public boolean invalid;
		@Column(nullable = true)
		public boolean pripravnik;
		@Column(nullable = false)
		public String nacionalnost;
		@Column(nullable = false)
		public char pol;
		@Column(nullable = false)
		public char status;
		@Column(nullable = true)
		public String adresa;
		@Column(nullable = true)
		public String telefon;
		
		@OneToMany(mappedBy = "radnik")
		public List<Preduzece> preduzeca;
		
		@OneToMany(mappedBy = "radnik")
		public List<Magacin> magacini;

		public Radnik(String ime, String prezime, String sifra) {
			super();
			this.ime = ime;
			this.prezime = prezime;
			this.sifra = sifra;
		}
	
}
