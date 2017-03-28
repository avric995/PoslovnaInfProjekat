package controllers;

import java.util.List;

import models.RobnaKartica;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class RobneKartice extends Controller {

	public static void show(String mode){
    	List<RobnaKartica> robneKartice = RobnaKartica.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(robneKartice, mode);
    }
	
	public static void add(@Required Double cena,@Required Integer pocStanjeKolicine,  @Required Double pocStanjeVrednosti, @Required String prometUlazaKolicine,@Required String prometUlazaVrednosti,@Required String prometIzlazaKolicine, @Required String prometIzlazaVrednosti, @Required Integer ukupnaKolicina,@Required Double ukupnaVrednost) {
		
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
			robnaKartica.ukupnaKolicina = ukupnaKolicina;
			robnaKartica.ukupnaVrednost = ukupnaVrednost;
			robnaKartica.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required Double cena,@Required Integer pocStanjeKolicine,  @Required Double pocStanjeVrednosti, @Required String prometUlazaKolicine,@Required String prometUlazaVrednosti,@Required String prometIzlazaKolicine, @Required String prometIzlazaVrednosti, @Required Integer ukupnaKolicina,@Required Double ukupnaVrednost, long id) {
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
    	
    	rK.save();
    	}
    	show("edit");
    	}

    public static void filter() {
    		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
    		String mode = "edit";
    		renderTemplate("Drzave/show.html", drzave, mode);*/
    	}
        
    	public static void remove(Long id){
    		RobnaKartica robnaKartica = RobnaKartica.findById(id);
    		robnaKartica.delete();
    		show("");
    	}
    

}

