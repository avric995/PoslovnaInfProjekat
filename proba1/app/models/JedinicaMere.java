package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class JedinicaMere extends Model {
	
	
	@Column(nullable = false)
	public String nazivJedMere;
	
<<<<<<< HEAD
	@OneToMany(mappedBy = "jedinicaMere")
	public List<Roba> robe;
=======
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
	
    
}
