package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class AnalitikaMagKartice extends Model {
	
	
	@Column(nullable = false)
	public Integer redniBroj;
	@Column(nullable = false)
	public String vrstaPrometa;
	@Column(nullable = false)
	public String smer;
	@Column(nullable = false)
	public Long kolicina;
	@Column(nullable = false)
	public Long cena;
	@Column(nullable = false)
	public Long vrednost;
	
	@ManyToOne
	public RobnaKartica robnaKartica;
	
    
}
