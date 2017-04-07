package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Roba extends Model {
	@Column(nullable = false)
	public String nazivRobe;
	
	@OneToMany(mappedBy = "roba")
	public List<StavkaDokumenta> stavkeDokumenata;
	@ManyToOne public JedinicaMere jedinicaMere;
	
	@ManyToOne public GrupaRobe grupaRobe;
	
	@OneToMany(mappedBy = "roba")
	public List<RobnaKartica> robneKartice;
	
	
}
