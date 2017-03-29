package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Roba extends Model {
	@Column(nullable = false)
	public String nazivRobe;
	
<<<<<<< HEAD
	@ManyToOne public JedinicaMere jedinicaMere;
	
	@ManyToOne public GrupaRobe grupaRobe;
	
=======
	@OneToMany(mappedBy = "roba")
	public List<StavkaDokumenta> stavkeDokumenata;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
	
}
