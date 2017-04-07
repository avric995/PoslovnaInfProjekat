package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class PoslovniPartner extends Model {
	@Column(nullable = false, unique = true)
	public String tipPartnera;
/*	@Column(nullable = false, unique = true)
	public String idPartnera;*/
	@Column(nullable = false)
	public String nazivPartnera;
	@Column(nullable = false)
	public String pib;
	@Column(nullable = true)
	public String adresa;
	
	@OneToMany(mappedBy = "poslovniPartner")
	public List<PrometniDokument> prometniDokumenti;
	
	@ManyToOne
	public Preduzece preduzece;
	
	@ManyToOne
	public NaseljenoMesto naseljenoMesto;

	
	
}
