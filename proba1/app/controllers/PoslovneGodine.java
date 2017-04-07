package controllers;

import java.util.List;

import models.Drzava;
import models.Magacin;
import models.PoslovnaGodina;
import models.RobnaKartica;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class PoslovneGodine extends Controller {

    public static void show(String mode) {
        List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();
        if (mode == null || mode.equals(""))
			mode ="edit";
        
        render(poslovneGodine, mode);
    }
    
    
    public static void add( @Required String godina,
    		@Required String zakljucena){
    	
    	PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
    	
    	poslovnaGodina.godina = godina;
    	poslovnaGodina.zakljucena = zakljucena;
    	
    	/*List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();*/
		poslovnaGodina.save();
    	show("add");
    	
    	
    }
    
    public static void edit (@Required String godina,
    		@Required String zakljucena, long id){
    	PoslovnaGodina pg = PoslovnaGodina.findById(id);
    	if(pg!=null){
    		
    		pg.godina = godina;
    		pg.zakljucena = zakljucena;
    		pg.save();
    	}
    		show("edit");
    }
	public static void filter(String godina, String zakljucena){
		
		List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.find("byGodinaLikeAndZakljucenaLike","%"+ godina.toLowerCase() +"%", "%"+zakljucena.toLowerCase()+"%").fetch();
		String mode = "edit";
		renderTemplate("PoslovneGodine/show.html", poslovneGodine, mode);
	
	}
   public static void novaGodina() {
    	List<RobnaKartica> kartice = RobnaKartica.findAll();
    	RobnaKartica robnaKartica = new RobnaKartica();
    	PoslovnaGodina novaPoslovnaGodina = new PoslovnaGodina();
    	
    	for(int i=0;kartice.size() > i; i++)
    	{    		
    		robnaKartica = kartice.get(i);
    		if (robnaKartica.ukupnaKolicina>0)
    		{
    			RobnaKartica novaKartica = new RobnaKartica();
    			int godinaBroj = 0;
    			godinaBroj = Integer.parseInt(robnaKartica.poslovnaGodina.godina)+1;
    			novaPoslovnaGodina.godina = String.valueOf(godinaBroj);
    			novaPoslovnaGodina.zakljucena = robnaKartica.poslovnaGodina.zakljucena;
    			novaKartica.magacin= robnaKartica.magacin;
    			novaKartica.roba = robnaKartica.roba;
    			novaKartica.cena = robnaKartica.cena;
    			novaKartica.pocStanjeKolicine=0;
    			novaKartica.pocStanjeVrednosti=0.0;
    			novaKartica.prometIzlazaKolicine=0;
    			novaKartica.prometIzlazaVrednosti=0;
    			novaKartica.prometUlazaKolicine=0;
    			novaKartica.prometUlazaVrednosti=0;
    			novaKartica.ukupnaKolicina = robnaKartica.ukupnaKolicina;
    			novaKartica.ukupnaVrednost = robnaKartica.ukupnaVrednost;
    			novaKartica.poslovnaGodina = novaPoslovnaGodina;
    			novaPoslovnaGodina.save();
    			novaKartica.save();
    			//show("novaGodina");
    			show("");
    		}
    	}
	}
    
    public static void remove (Long id){
    	PoslovnaGodina poslovnaGodina = PoslovnaGodina.findById(id);
    	poslovnaGodina.delete();
    	show("");
    }
}
