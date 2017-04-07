package controllers;

import java.util.List;

import models.JedinicaMere;
import models.Magacin;
import models.Preduzece;
import models.Radnik;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Magacini extends Controller{

	public static void show(String mode){
    	List<Magacin> magacini = Magacin.findAll();
    	List<Radnik> radnici = Radnik.findAll();
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(magacini,radnici,preduzeca, mode);
    }
    
   
    
    public static void create(String naziv, long radnik, long preduzece) {
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
    	Magacin mag = new Magacin();
		mag.naziv = naziv;
		mag.radnik = Radnik.findById(radnik);
		mag.preduzece = Preduzece.findById(preduzece);
//		List<Magacin> magacini = Magacin.findAll();
		mag.save();
		show("add");
	}

	public static void edit(String naziv,long radnik, long id, long preduzece) {
		//greska u editu nzm sto
		Magacin m = Magacin.findById(id);
		if(m!=null){
			m.naziv=naziv;
			m.radnik = Radnik.findById(radnik);
			m.preduzece = Preduzece.findById(preduzece);
			m.save();
		}
		show("edit");
		}

	 public static void filter(String naziv) {
			
	    List<Magacin> magacini = Magacin.find("byNazivLike","%"+ naziv.toLowerCase() +"%").fetch();
	    List<Preduzece> preduzeca = Preduzece.findAll();
	    String mode = "edit";
	    renderTemplate("Magacini/show.html", magacini,preduzeca, mode);
	    	
	    }
    
	public static void remove(long id){
		//greska u brisanju nece prva dva da obrise
		Magacin mag = Magacin.findById(id);
		mag.delete();
		show("delete");
	}
	public static void logout(){
		   try {
			Secure.logout();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
    
}
