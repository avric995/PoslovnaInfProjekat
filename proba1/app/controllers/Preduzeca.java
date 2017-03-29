package controllers;

import java.util.List;

import models.GrupaRobe;
import models.Preduzece;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Preduzeca extends Controller{

	public static void show(String mode){
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(preduzeca, mode);
    }
    
   
    
    public static void create(String naziv,String pib, String adresa) {
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
		Preduzece pred = new Preduzece(adresa,naziv,pib);
		
		 
		List<Preduzece> preduzeca = Preduzece.findAll();
		pred.save();
		show("add");
	}

    public static void edit(String naziv,String PIB,String adresa, long id) {
    	Preduzece p = Preduzece.findById(id);
    	if(p!=null){
    	p.naziv=naziv;
    	p.PIB = PIB;
    	p.adresa = adresa;
    	//p.radnik = Radnik.findById(radnik);
    	p.save();
    	}
    	show("edit");
    	}

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Preduzece preduzece = Preduzece.findById(id);
		preduzece.delete();
		show("");
	}
    
}