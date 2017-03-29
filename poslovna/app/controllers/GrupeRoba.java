package controllers;

import java.util.List;

import models.Drzava;
import models.GrupaRobe;
import models.JedinicaMere;
import models.PoslovnaGodina;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class GrupeRoba extends Controller {

    public static void show(String mode) {
        List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(grupeRoba, mode);
    }
    
    
    public static void add( @Required String nazivGrupe){
    	
    	GrupaRobe grupaRobe = new GrupaRobe();
    	
    	grupaRobe.nazivGrupe = nazivGrupe;
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		grupaRobe.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required String nazivGrupe, long id){
    	GrupaRobe gr = GrupaRobe.findById(id);
    	if(gr!=null){
    		
    		gr.nazivGrupe = nazivGrupe;
    		
    		gr.save();
    	}
    		show("edit");
    }
    public static void filter() {
		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
		String mode = "edit";
		renderTemplate("Drzave/show.html", drzave, mode);*/
	}
    
    public static void remove (Long id){
    	GrupaRobe grupaRobe = GrupaRobe.findById(id);
    	grupaRobe.delete();
    	show("");
    }
}
