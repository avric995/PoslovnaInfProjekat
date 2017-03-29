package controllers;

import java.util.List;

import models.Zanimanje;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Zanimanja extends Controller{

	public static void show(String mode){
    	List<Zanimanje> zanimanja = Zanimanje.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	render(zanimanja, mode);
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
		Zanimanje zanimanje = new Zanimanje(naziv, oznaka);

		List<Zanimanje> zanimanja = Zanimanje.findAll();
		zanimanje.save();
		show("add");
	}

	public static void edit(String naziv,String oznaka,Long id) {
		Zanimanje z = Zanimanje.findById(id);
		if(z!=null){
				z.naziv=naziv;
				z.oznaka=oznaka;
				z.save();
			}
		show("");
	}

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Zanimanje zan  = Zanimanje.findById(id);
		zan.delete();
		show("");
	}
    
}
