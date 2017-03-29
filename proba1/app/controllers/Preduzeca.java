package controllers;

import java.util.List;

<<<<<<< HEAD
import models.GrupaRobe;
import models.Preduzece;
=======
import models.Preduzece;
import models.Radnik;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Preduzeca extends Controller{

	public static void show(String mode){
    	List<Preduzece> preduzeca = Preduzece.findAll();
<<<<<<< HEAD
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(preduzeca, mode);
=======
    	List<Radnik> radnici = Radnik.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(preduzeca,radnici, mode);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    }
    
   
    
<<<<<<< HEAD
    public static void create(String naziv,String pib, String adresa) {
=======
    public static void create(String naziv,String pib, String adresa, long radnik) {
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
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
<<<<<<< HEAD
		
		 
=======
		pred.radnik = Radnik.findById(radnik);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
		List<Preduzece> preduzeca = Preduzece.findAll();
		pred.save();
		show("add");
	}

<<<<<<< HEAD
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
=======
	public static void edit(String naziv,String PIB,String adresa,long radnik, Long id) {
	Preduzece p = Preduzece.findById(id);
	if(p!=null){
	p.naziv=naziv;
	p.PIB = PIB;
	p.adresa = adresa;
	p.radnik = Radnik.findById(radnik);
	p.save();
	}
	show("edit");
	}
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Preduzece preduzece = Preduzece.findById(id);
		preduzece.delete();
		show("");
	}
    
}
