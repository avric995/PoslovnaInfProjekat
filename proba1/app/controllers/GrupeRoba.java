package controllers;

import java.util.List;

import models.Drzava;
import models.GrupaRobe;
import models.JedinicaMere;
import models.PoslovnaGodina;
import models.PoslovniPartner;
import models.Preduzece;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class GrupeRoba extends Controller {

    public static void show(String mode) {
        List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
        List<Preduzece> preduzeca = Preduzece.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(grupeRoba, mode, preduzeca);
    }
    
    
    public static void add( @Required String nazivGrupe, long preduzece){
    	
    	GrupaRobe grupaRobe = new GrupaRobe();
    	
    	grupaRobe.nazivGrupe = nazivGrupe;
    	grupaRobe.preduzece = Preduzece.findById(preduzece);
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		grupaRobe.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required String nazivGrupe, long id, long preduzece){
    	GrupaRobe gr = GrupaRobe.findById(id);
    	if(gr!=null){
    		
    		gr.nazivGrupe = nazivGrupe;
    		gr.preduzece = Preduzece.findById(preduzece);
    		
    		gr.save();
    	}
    		show("edit");
    }
    public static void filter(@Required String nazivGrupe, long preduzece) {
		
    	List<GrupaRobe> grupeRoba = GrupaRobe.find("byNazivGrupeLike","%"+ nazivGrupe.toLowerCase() +"%").fetch();
    	List<Preduzece> preduzeca = Preduzece.findAll(); 
    	String mode = "edit";
    	renderTemplate("GrupeRoba/show.html", grupeRoba,preduzeca, mode);
    	
    	}
    
    public static void remove (Long id){
    	GrupaRobe grupaRobe = GrupaRobe.findById(id);
    	grupaRobe.delete();
    	show("");
    }
}
