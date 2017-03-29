package controllers;

import java.util.List;

import models.Odsustvo;
import models.Zanimanje;
import play.data.validation.Required;
import play.mvc.Controller;

public class Odsustva extends Controller{

	public static void show(String mode){
    	List<Odsustvo> odsustva = Odsustvo.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	render(odsustva, mode);
    }
	
	public static void create(String sifra,Long radnik, String pocetak, String kraj, String napomena) {
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
		Odsustvo odsustvo = new Odsustvo(sifra, radnik, pocetak, kraj, napomena);

		List<Odsustvo> odsustva = Odsustvo.findAll();
		odsustvo.save();
		show("add");
	}

	public static void edit(String sifra,Long radnik, String pocetak, String kraj, String napomena, Long id) {
		Odsustvo o = Odsustvo.findById(id);
		if(o!=null){
				o.sifra= sifra;
				o.radnik=radnik;
				o.pocetak=pocetak;
				o.kraj=kraj;
				o.napomena=napomena;
					
				o.save();
			}
		show("");
	}

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Odsustvo ods  = Odsustvo.findById(id);
		ods.delete();
		show("");
	}
}