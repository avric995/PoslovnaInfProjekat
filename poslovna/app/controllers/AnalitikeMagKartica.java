package controllers;

import java.util.List;

import models.AnalitikaMagKartice;
import models.Drzava;
import models.PoslovnaGodina;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class AnalitikeMagKartica extends Controller {

    public static void show(String mode) {
        List<AnalitikaMagKartice> analitikeMagKartica = AnalitikaMagKartice.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(analitikeMagKartica, mode);
    }
    
    
    public static void add( @Required Integer redniBroj, @Required String vrstaPrometa,@Required String smer,
    		@Required Long kolicina, @Required Long cena, @Required Long vrednost){
    	
    	AnalitikaMagKartice analitikaMagKartice = new AnalitikaMagKartice();
    	
    	analitikaMagKartice.redniBroj = redniBroj;
    	analitikaMagKartice.vrstaPrometa = vrstaPrometa;
    	analitikaMagKartice.smer = smer;
    	analitikaMagKartice.kolicina = kolicina;
    	analitikaMagKartice.cena = cena;
    	analitikaMagKartice.vrednost = vrednost;
    	
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
    	analitikaMagKartice.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required Integer redniBroj, @Required String vrstaPrometa,@Required String smer,
    		@Required Long kolicina, @Required Long cena, @Required Long vrednost, long id){
    	AnalitikaMagKartice amk = AnalitikaMagKartice.findById(id);
    	if(amk!=null){
    		
    		amk.redniBroj = redniBroj;
    		amk.vrstaPrometa = vrstaPrometa;
    		amk.smer = smer;
    		amk.kolicina = kolicina;
    		amk.cena = cena;
    		amk.vrednost = vrednost;
    		amk.save();
    	}
    		show("edit");
    }
    public static void filter() {
		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
		String mode = "edit";
		renderTemplate("Drzave/show.html", drzave, mode);*/
	}
    
    public static void remove (Long id){
    	AnalitikaMagKartice analitikaMagKartice = AnalitikaMagKartice.findById(id);
    	analitikaMagKartice.delete();
    	show("");
    }
}
