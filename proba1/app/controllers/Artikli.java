package controllers;

import java.util.List;

import models.Artikal;
import models.Magacin;
import models.PoslovnaGodina;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Artikli extends Controller{

	public static void show(String mode){
		List<Artikal> artikli = Artikal.findAll();
		if (mode == null || mode.equals(""))
			mode = "edit";
		List<Magacin> magacini = Magacin.findAll();
		render(artikli, magacini, mode);
	}
	
	public static void next(Long id){
		Magacin mag = Magacin.findById(id);
		List<Artikal> artikli = Artikal.find("byMagacin", mag).fetch();
		String mode = "edit";
		List<Magacin> magacini = Magacin.findAll();
		renderTemplate("Artikli/show.html", artikli, magacini, mode);
	
	}
	
	public static void create(String naziv,String sifra,float pakovanje, String jedinica, Long magacin) {
		/*validation.required(oznaka);
		validation.required(naziv);
		validation.minSize(oznaka, 2);
		validation.maxSize(oznaka, 5);
		if(validation.hasErrors()) {
			 for(play.data.validation.Error error : validation.errors()) {
			 System.out.println(error.message());
			 }
			 validation.keep();
			 show("add");
			}*/
		Magacin magacinFilter = Magacin.findById(magacin);
		Artikal art = new Artikal(sifra, naziv, jedinica, pakovanje, magacinFilter);
		 
		List<Artikal> artikli = Artikal.findAll();
		art.save();
		show("add");
	}

	public static void edit(String naziv,String sifra,String jedinica, float pakovanje, long magacin, long id) {
		  Artikal ar = Artikal.findById(id);
		  if (ar!=null){
		   ar.naziv = naziv;
		   ar.jedinicaMere = jedinica;
		   ar.pakovanje = pakovanje;
		   ar.magacin = Magacin.findById(magacin);
		   ar.save();
		 }
		 show("edit");
		}
	
	public static void remove(Long id){
		Artikal artikal = Artikal.findById(id);
		artikal.delete();
		show("");
	}	

	/*public static void filter(String godina, String zakljucena){
		
		List<Artikal> artikli = PoslovnaGodina.find("byGodinaLikeAndZakljucenaLike","%"+ godina.toLowerCase() +"%", "%"+zakljucena.toLowerCase()+"%").fetch();
		String mode = "edit";
		renderTemplate("PoslovneGodine/show.html", poslovneGodine, mode);
	
	}*/

}
