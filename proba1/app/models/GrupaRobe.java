package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class GrupaRobe extends Model {
	
	
	@Column(nullable = false)
	public String nazivGrupe;
	
<<<<<<< HEAD
	@OneToMany (mappedBy = "grupaRobe")
	public List<Roba> robe;
	
	@ManyToOne public Preduzece preduzece;
=======
	
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    
}
