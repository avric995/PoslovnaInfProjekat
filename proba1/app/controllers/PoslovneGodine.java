package controllers;

import java.util.List;

import models.Drzava;
import models.NaseljenoMesto;
import models.PoslovnaGodina;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class PoslovneGodine extends Controller {

    public static void show(String mode) {
        List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(poslovneGodine, mode);
    }
    
    
    public static void add( @Required String godina,
    		@Required String zakljucena){
    	
    	PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
    	
    	poslovnaGodina.godina = godina;
    	poslovnaGodina.zakljucena = zakljucena;
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		poslovnaGodina.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required String godina,
    		@Required String zakljucena, long id){
    	PoslovnaGodina pg = PoslovnaGodina.findById(id);
    	if(pg!=null){
    		
    		pg.godina = godina;
    		pg.zakljucena = zakljucena;
    		pg.save();
    	}
    		show("edit");
    }
	public static void filter(String godina, String zakljucena){
		
		List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.find("byGodinaLikeAndZakljucenaLike","%"+ godina.toLowerCase() +"%", "%"+zakljucena.toLowerCase()+"%").fetch();
		String mode = "edit";
		renderTemplate("PoslovneGodine/show.html", poslovneGodine, mode);
	
	}
    
    public static void remove (Long id){
    	PoslovnaGodina poslovnaGodina = PoslovnaGodina.findById(id);
    	poslovnaGodina.delete();
    	show("");
    }
}
