package controllers;

import java.util.List;

import models.GrupaRobe;
import models.NaseljenoMesto;
import models.Preduzece;
import models.Radnik;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Preduzeca extends Controller{

	public static void show(String mode){
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	List<Radnik> radnici = Radnik.findAll();
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
    	List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(preduzeca,radnici,naseljenaMesta, mode);
    }
    
   
    
    public static void create(String naziv,String pib, String adresa, long radnik,  long naseljenoMesto) {
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
		Preduzece pred = new Preduzece();
		pred.naziv = naziv;
		pred.PIB = pib;
		pred.adresa = adresa;
		pred.radnik = Radnik.findById(radnik);
		pred.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
		pred.save();
		show("add");
	}

	public static void edit(String naziv,String PIB,String adresa,long radnik, long id, long naseljenoMesto) {
	Preduzece p = Preduzece.findById(id);
	if(p!=null){
	p.naziv=naziv;
	p.PIB = PIB;
	p.adresa = adresa;
	p.radnik = Radnik.findById(radnik);
  p.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
	p.save();
	}
	show("edit");
	}

	public static void filter() {
	//ima greska na kontroleru ispraviti je i uraditi filter
	}
    
	public static void remove(Long id){
		Preduzece preduzece = Preduzece.findById(id);
		preduzece.delete();
		show("");
	}
    
}
