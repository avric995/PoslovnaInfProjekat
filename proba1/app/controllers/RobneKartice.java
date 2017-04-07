package controllers;

import java.util.List;

import models.Magacin;
import models.NaseljenoMesto;
import models.PoslovnaGodina;
import models.Preduzece;
import models.Roba;
import models.RobnaKartica;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class RobneKartice extends Controller {

	public static void show(String mode){
    	List<RobnaKartica> robneKartice = RobnaKartica.findAll();
    	List<Roba> robe = Roba.findAll();
    	List<Magacin> magacini = Magacin.findAll();
    	List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(robneKartice,robe,magacini,poslovneGodine, mode);
    }
	
	public static void add(@Required Double cena,@Required Integer pocStanjeKolicine,  @Required Double pocStanjeVrednosti, @Required Integer prometUlazaKolicine,@Required Integer prometUlazaVrednosti,@Required Integer prometIzlazaKolicine, @Required Integer prometIzlazaVrednosti, @Required Integer ukupnaKolicina,@Required Double ukupnaVrednost, long roba, long magacin, long poslovnaGodina) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			RobnaKartica robnaKartica = new RobnaKartica();
			robnaKartica.cena = cena;
			robnaKartica.pocStanjeKolicine = pocStanjeKolicine;
			robnaKartica.pocStanjeVrednosti = pocStanjeVrednosti;
			robnaKartica.prometUlazaKolicine = prometUlazaKolicine;
			robnaKartica.prometUlazaVrednosti = prometUlazaVrednosti;
			robnaKartica.prometIzlazaKolicine = prometIzlazaKolicine;
			robnaKartica.prometIzlazaVrednosti = prometIzlazaVrednosti;
			robnaKartica.ukupnaKolicina = pocStanjeKolicine  + prometUlazaVrednosti - prometIzlazaKolicine;
			robnaKartica.ukupnaVrednost = pocStanjeVrednosti + prometUlazaVrednosti  - prometIzlazaKolicine;
			robnaKartica.roba = Roba.findById(roba);
			robnaKartica.magacin = Magacin.findById(magacin);
			robnaKartica.poslovnaGodina = PoslovnaGodina.findById(poslovnaGodina);
			robnaKartica.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required Double cena,@Required Integer pocStanjeKolicine,  @Required Double pocStanjeVrednosti, @Required Integer prometUlazaKolicine,@Required Integer prometUlazaVrednosti,@Required Integer prometIzlazaKolicine, @Required Integer prometIzlazaVrednosti, @Required Integer ukupnaKolicina,@Required Double ukupnaVrednost,long roba, long magacin, long poslovnaGodina, long id) {
    	RobnaKartica rK = RobnaKartica.findById(id);
    	if(rK!=null){
    	rK.cena = cena;
    	rK.pocStanjeKolicine = pocStanjeKolicine;
    	rK.pocStanjeVrednosti = pocStanjeVrednosti;
    	rK.prometUlazaKolicine = prometUlazaKolicine;
    	rK.prometUlazaVrednosti = prometUlazaVrednosti;
    	rK.prometIzlazaKolicine = prometIzlazaKolicine;
    	rK.prometIzlazaVrednosti = prometIzlazaVrednosti;
    	rK.ukupnaKolicina = ukupnaKolicina;
    	rK.ukupnaVrednost = ukupnaVrednost;
    	rK.roba = Roba.findById(roba);
    	rK.magacin = Magacin.findById(magacin);
    	rK.poslovnaGodina = PoslovnaGodina.findById(poslovnaGodina);
    	
    	rK.save();
    	}
    	show("edit");
    	}

    public static void filter(Double cena) {
		
  	/*List<RobnaKartica> kartice = RobnaKartica.find("byCena",+ cena).fetch();
    	String mode = "edit";
    	renderTemplate("RobneKartice/show.html", kartice, mode);
    	NEE RADII OVO
   */
    	}
        
    	public static void remove(Long id){
    		RobnaKartica robnaKartica = RobnaKartica.findById(id);
    		robnaKartica.delete();
    		show("");
    	}
    

}

