package controllers;

import java.util.List;

import models.Drzava;
import models.GrupaRobe;
import models.JedinicaMere;
import models.PoslovnaGodina;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class JediniceMera extends Controller {

    public static void show(String mode) {
        List<JedinicaMere> jediniceMera = JedinicaMere.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(jediniceMera, mode);
    }
    
    
    public static void add( @Required String nazivJedMere){
    	
    	JedinicaMere jedinicaMere = new JedinicaMere();
    	
    	jedinicaMere.nazivJedMere = nazivJedMere;
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		jedinicaMere.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required String nazivJedMere, long id){
    	JedinicaMere jm = JedinicaMere.findById(id);
    	if(jm!=null){
    		
    		jm.nazivJedMere = nazivJedMere;
    		
    		jm.save();
    	}
    		show("edit");
    }
    public static void filter(@Required String nazivJedMere) {
		
    	List<JedinicaMere> jediniceMera = JedinicaMere.find("byNazivJedMereLike","%"+ nazivJedMere.toLowerCase() +"%").fetch();
    	String mode = "edit";
    	renderTemplate("JediniceMera/show.html", jediniceMera, mode);
    	
    	}
    
    public static void remove (Long id){
    	JedinicaMere jedinicaMere = JedinicaMere.findById(id);
    	jedinicaMere.delete();
    	show("");
    }
}
