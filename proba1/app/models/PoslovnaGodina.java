package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class PoslovnaGodina extends Model {
	
	
	@Column(nullable = false)
	public String godina;
	@Column(nullable = false)
	public String zakljucena;
	
	@OneToMany(mappedBy = "poslovnaGodina")
	public List<RobnaKartica> robneKartice;
	
    
}
