package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Odsustvo extends Model {
		@Column(nullable = false, unique = true)
		public String sifra;
		@Column(nullable = true)
		public Long radnik;
		@Column(nullable = false)
		public String pocetak;
		@Column(nullable = false)
		public String kraj;
		@Column(nullable = true)
		public String napomena;
		
		public Odsustvo(String sifra, Long radnik, String pocetak, String kraj, String napomena) {
			super();
			this.sifra = sifra;
			this.radnik = radnik;
			this.pocetak = pocetak;
			this.kraj = kraj;
			this.napomena = napomena;
		}
}