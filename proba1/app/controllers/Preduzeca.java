package controllers;

import java.util.List;

import models.GrupaRobe;
import models.NaseljenoMesto;
import models.PoslovniPartner;
import models.Preduzece;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Preduzeca extends Controller{

	public static void show(String mode){
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
    	List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(preduzeca, naseljenaMesta, mode);
    }
    
   
    
/*    public static void create(String naziv,String pib, String adresa, long naseljenoMesto) {
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
		pred.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
		
		
		 
		List<Preduzece> preduzeca = Preduzece.findAll();
		pred.save();
		show("add");
	}*/
    public static void add(String naziv,String pib, String adresa, long naseljenoMesto) {
		
    	/*	if(validation.hasErrors()) {
    			for(play.data.validation.Error error : validation.errors()) {
    			System.out.println(error.message());
    				}
    			validation.keep();
    			show("add");
    		}else {*/
    			Preduzece preduzece = new Preduzece();
    			preduzece.naziv = naziv;
    			preduzece.PIB = pib;
    			preduzece.adresa = adresa;
    			preduzece.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
    			preduzece.save();
    			validation.keep();
    			show("add");
    }

    public static void edit(String naziv,String PIB,String adresa, long id, long naseljenoMesto) {
    	//greska u editu nzm sto
    	Preduzece p = Preduzece.findById(id);
    	if(p!=null){
    	p.naziv=naziv;
    	p.PIB = PIB;
    	p.adresa = adresa;
    	p.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
    	//p.radnik = Radnik.findById(radnik);
    	p.save();
    	}
    	show("edit");
    	}

    public static void filter(String naziv,String pib,String adresa) {
		
    	List<Preduzece> preduzeca = Preduzece.find("byNazivLikeAndAdresaLikeAndPibLike","%"+ naziv.toLowerCase() +"%", "%"+ adresa.toLowerCase() +"%", "%"+ pib.toLowerCase() +"%").fetch();
    	List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll(); 
    	String mode = "edit";
    	renderTemplate("Preduzeca/show.html", preduzeca,naseljenaMesta, mode);
    	
    	}
    
    
	public static void remove(Long id){
		Preduzece preduzece = Preduzece.findById(id);
		preduzece.delete();
		show("");
	}
    
}
