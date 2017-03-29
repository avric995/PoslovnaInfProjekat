package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class JedinicaMere extends Model {
	
	
	@Column(nullable = false)
	public String nazivJedMere;
	
	
    
}
