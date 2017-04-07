package controllers;

import java.util.List;

import models.GrupaRobe;
import models.JedinicaMere;
import models.NaseljenoMesto;
import models.Preduzece;
import models.Roba;
import play.data.validation.Required;
import play.mvc.*;

public class Robe extends Controller {

	public static void show(String mode){
    	List<Roba> robe = Roba.findAll();
    	List<JedinicaMere> jediniceMera = JedinicaMere.findAll();
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(robe,jediniceMera, mode, grupeRoba);
    }
	
	public static void add(@Required String nazivRobe, long jedinicaMere, long grupaRobe) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			Roba roba = new Roba();
			roba.nazivRobe = nazivRobe;
			roba.jedinicaMere = JedinicaMere.findById(jedinicaMere);
			roba.grupaRobe = GrupaRobe.findById(grupaRobe);
			roba.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required String nazivRobe,long id, long jedinicaMere, long grupaRobe) {
    	Roba r = Roba.findById(id);
    	if(r!=null){
    	r.nazivRobe = nazivRobe;
    	r.jedinicaMere = JedinicaMere.findById(jedinicaMere);
    	r.grupaRobe = GrupaRobe.findById(grupaRobe);
    	
    	
    	r.save();
    	}
    	show("edit");
    	}

    public static void filter(String nazivRobe) {
		
    	List<Roba> robe = Roba.find("byNazivRobeLike","%"+ nazivRobe.toLowerCase() +"%").fetch();
    	List<JedinicaMere> jediniceMera = JedinicaMere.findAll(); 
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll(); 
    	String mode = "edit";
    	renderTemplate("Robe/show.html", robe,jediniceMera,grupeRoba, mode);
    	
    	}
        
    	public static void remove(Long id){
    		Roba roba = Roba.findById(id);
    		roba.delete();
    		show("");
    	}
    



}
