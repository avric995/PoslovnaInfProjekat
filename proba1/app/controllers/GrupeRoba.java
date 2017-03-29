package controllers;

import java.util.List;

import models.Drzava;
import models.GrupaRobe;
import models.JedinicaMere;
import models.PoslovnaGodina;
<<<<<<< HEAD
import models.Preduzece;
=======
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class GrupeRoba extends Controller {

    public static void show(String mode) {
        List<GrupaRobe> grupeRoba = GrupaRobe.findAll();
<<<<<<< HEAD
        List<Preduzece> preduzeca = Preduzece.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(grupeRoba, mode, preduzeca);
    }
    
    
    public static void add( @Required String nazivGrupe, long preduzece){
=======
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(grupeRoba, mode);
    }
    
    
    public static void add( @Required String nazivGrupe){
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    	
    	GrupaRobe grupaRobe = new GrupaRobe();
    	
    	grupaRobe.nazivGrupe = nazivGrupe;
<<<<<<< HEAD
    	grupaRobe.preduzece = Preduzece.findById(preduzece);
=======
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    	
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		grupaRobe.save();
    	show("add");
    	
    	
    }
    
<<<<<<< HEAD
    public static void edit (@Required String nazivGrupe, long id, long preduzece){
=======
    public static void edit (@Required String nazivGrupe, long id){
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    	GrupaRobe gr = GrupaRobe.findById(id);
    	if(gr!=null){
    		
    		gr.nazivGrupe = nazivGrupe;
<<<<<<< HEAD
    		gr.preduzece = Preduzece.findById(preduzece);
=======
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    		
    		gr.save();
    	}
    		show("edit");
    }
    public static void filter() {
		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
		String mode = "edit";
		renderTemplate("Drzave/show.html", drzave, mode);*/
	}
    
    public static void remove (Long id){
    	GrupaRobe grupaRobe = GrupaRobe.findById(id);
    	grupaRobe.delete();
    	show("");
    }
}
