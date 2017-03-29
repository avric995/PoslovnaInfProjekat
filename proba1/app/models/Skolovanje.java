package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Skolovanje extends Model {
	@Column(nullable = false, unique = true)
	public Integer brojSkolovanja;
	@Column(nullable = false)
	public String nazivSkole;
	@Column(nullable = false)
	public Date datumPocetka;
	@Column(nullable = true)
	public Date datumZavrsetka;
	@Column(nullable = true)
	public boolean polozio;
	
	public Skolovanje(Integer brojSkolovanja, String nazivSkole, Date datumPocetka, Date datumZavrsetka,
			boolean polozio) {
		super();
		this.brojSkolovanja = brojSkolovanja;
		this.nazivSkole = nazivSkole;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.polozio = polozio;
	}
	
	
}
