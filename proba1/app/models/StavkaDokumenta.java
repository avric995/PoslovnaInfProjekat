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
<<<<<<< HEAD
=======
	
	@ManyToOne
	public Roba roba;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
}
