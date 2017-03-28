package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class PrometniDokument extends Model {
	@Column(nullable = false, unique = true)
	public String vrstaDokumenta;
/*	@Column(nullable = false, unique = true)
	public String idPartnera;*/
	@Column(nullable = false)
	public Integer redniBrojDokumenta;
	@Column(nullable = false)
	public String datumFormiranja;
	@Column(nullable = true)
	public String datumKnjizenja;
	@Column(nullable = true)
	public String status;
	
	
}
