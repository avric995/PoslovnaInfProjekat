package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class StavkaDokumenta extends Model {
	@Column(nullable = false)
	public Integer kolicina;
	@Column(nullable = false)
	public Double cena;
	@Column(nullable = false)
	public String vrednost;
	
	@ManyToOne
	public PrometniDokument prometniDokument;
	
	@ManyToOne
	public Roba roba;
}
