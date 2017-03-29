package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class GrupaRobe extends Model {
	
	
	@Column(nullable = false)
	public String nazivGrupe;
	
	
    
}
