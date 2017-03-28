package controllers;

import java.util.List;

import models.Roba;
import play.data.validation.Required;
import play.mvc.*;

public class Robe extends Controller {

	public static void show(String mode){
    	List<Roba> robe = Roba.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(robe, mode);
    }
	
	public static void add(@Required String nazivRobe) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			Roba roba = new Roba();
			roba.nazivRobe = nazivRobe;
			roba.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required String nazivRobe,long id) {
    	Roba r = Roba.findById(id);
    	if(r!=null){
    	r.nazivRobe = nazivRobe;
    	
    	
    	r.save();
    	}
    	show("edit");
    	}

    public static void filter() {
    		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
    		String mode = "edit";
    		renderTemplate("Drzave/show.html", drzave, mode);*/
    	}
        
    	public static void remove(Long id){
    		Roba roba = Roba.findById(id);
    		roba.delete();
    		show("");
    	}
    



}
