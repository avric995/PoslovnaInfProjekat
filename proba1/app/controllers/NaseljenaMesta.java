package controllers;

import java.util.List;

import models.Drzava;
import models.Magacin;
import models.NaseljenoMesto;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class NaseljenaMesta extends Controller{

	public static void show(String mode){
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		if (mode == null || mode.equals(""))
			mode = "edit";
		List<Drzava> drzave = Drzava.findAll();
		render(naseljenaMesta, drzave, mode);
	}
	
	public static void next(Long id){
		Drzava drzava = Drzava.findById(id);
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.find("byDrzava", drzava).fetch();
		String mode = "edit";
		List<Drzava> drzave = Drzava.findAll();
		renderTemplate("NaseljenaMesta/show.html", naseljenaMesta, drzave, mode);
	
	}
	
	public static void create(String naziv,String oznaka,String postanskiBroj, Long drzava) {
		validation.required(oznaka);
		validation.required(naziv);
		validation.minSize(oznaka, 2);
		validation.maxSize(oznaka, 5);
		if(validation.hasErrors()) {
			 for(play.data.validation.Error error : validation.errors()) {
			 System.out.println(error.message());
			 }
			 validation.keep();
			 show("add");
			}
		Drzava drzavaFilter = Drzava.findById(drzava);
		NaseljenoMesto nMesto = new NaseljenoMesto(oznaka, naziv, postanskiBroj, drzavaFilter);
		 
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		nMesto.save();
		show("add");
	}

	public static void edit(String naziv,String oznaka,String postanskiBroj, Drzava drzava) {

	}
	
	public static void remove(Long id){
		NaseljenoMesto nMesto = NaseljenoMesto.findById(id);
		nMesto.delete();
		show("");
	}	

	public static void filter(String naziv, String oznaka, String postanskiBroj, long drzava){
		
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.find("byNazivLikeAndOznakaLikeAndPostanskiBrojLikeAndDrzava_id","%"+ naziv.toLowerCase() +"%", "%"+oznaka.toLowerCase()+"%","%"+postanskiBroj.toLowerCase()+"%", drzava).fetch();
		List<Drzava> drzave = Drzava.findAll();
		String mode = "edit";
		renderTemplate("NaseljenaMesta/show.html", naseljenaMesta,drzave, mode);
	
	}

}
