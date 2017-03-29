package controllers;

import java.util.List;

import models.Drzava;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Drzave extends Controller{

	public static void show(String mode){
    	List<Drzava> drzave = Drzava.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(drzave, mode);
    }
    
   
    
    public static void create(String naziv,String oznaka) {
//		validation.required(oznaka);
//		validation.required(naziv);
//		validation.minSize(oznaka, 2);
//		validation.maxSize(oznaka, 5);
//		if(validation.hasErrors()) {
//			 for(play.data.validation.Error error : validation.errors()) {
//			 System.out.println(error.message());
//			 }
//			 validation.keep();
//			 show("add");
//			}
		Drzava drzava = new Drzava(oznaka,naziv);
		 
		List<Drzava> drzave = Drzava.findAll();
		drzava.save();
		show("add");
	}

	public static void edit(String naziv,String oznaka,Long id) {
	Drzava d = Drzava.findById(id);
	if(d!=null){
	d.naziv=naziv;
	d.oznaka=oznaka;
	d.save();
	}
	show("");
	}

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Drzava drzava = Drzava.findById(id);
		drzava.delete();
		show("");
	}
    
}
