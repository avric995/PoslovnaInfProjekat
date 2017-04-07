package controllers;

import java.util.List;

import models.AnalitikaMagKartice;
import models.Drzava;
import models.PoslovnaGodina;
import models.RobnaKartica;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class AnalitikeMagKartica extends Controller {

    public static void show(String mode) {
        List<AnalitikaMagKartice> analitikeMagKartica = AnalitikaMagKartice.findAll();
        List<RobnaKartica> robneKartice = RobnaKartica.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(analitikeMagKartica,robneKartice, mode);
    }
    
    
    public static void add( @Required Integer redniBroj, @Required String vrstaPrometa,@Required String smer,
    		@Required Long kolicina, @Required Long cena, @Required Long vrednost, long robnaKartica){
    	
    	AnalitikaMagKartice analitikaMagKartice = new AnalitikaMagKartice();
    	
    	analitikaMagKartice.redniBroj = redniBroj;
    	analitikaMagKartice.vrstaPrometa = vrstaPrometa;
    	analitikaMagKartice.smer = smer;
    	analitikaMagKartice.kolicina = kolicina;
    	analitikaMagKartice.cena = cena;
    	analitikaMagKartice.vrednost = vrednost;
    	analitikaMagKartice.robnaKartica = RobnaKartica.findById(robnaKartica);
    	
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
    	analitikaMagKartice.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required Integer redniBroj, @Required String vrstaPrometa,@Required String smer,
    		@Required Long kolicina, @Required Long cena, @Required Long vrednost,long robnaKartica, long id){
    	AnalitikaMagKartice amk = AnalitikaMagKartice.findById(id);
    	if(amk!=null){
    		
    		amk.redniBroj = redniBroj;
    		amk.vrstaPrometa = vrstaPrometa;
    		amk.smer = smer;
    		amk.kolicina = kolicina;
    		amk.cena = cena;
    		amk.vrednost = vrednost;
    		amk.robnaKartica = RobnaKartica.findById(robnaKartica);
    		amk.save();
    	}
    		show("edit");
    }
    public static void filter(String vrstaPrometa,String smer) {
    	//popraviti
    	List<AnalitikaMagKartice> analitike = AnalitikaMagKartice.find("byVrstaPrometaLike", "%"+vrstaPrometa.toLowerCase()+"%").fetch();
    	List<RobnaKartica> robneKartice = RobnaKartica.findAll();
    	String mode = "edit";
    	renderTemplate("AnalitikeMagKartica/show.html", analitike,robneKartice, mode);
    		
    	
	}
    
    public static void remove (Long id){
    	AnalitikaMagKartice analitikaMagKartice = AnalitikaMagKartice.findById(id);
    	analitikaMagKartice.delete();
    	show("");
    }
}
