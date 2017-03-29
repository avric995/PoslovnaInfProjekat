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
	
	
	/*public PoslovniPartner(String tipPartnera, String idPartnera, String nazivPartnera, String pib, String adresa) {
		super();
		this.tipPartnera = tipPartnera;
		this.idPartnera = idPartnera;
		this.nazivPartnera = nazivPartnera;
		this.pib = pib;
		this.adresa = adresa;
	}*/
	
	


	
}
