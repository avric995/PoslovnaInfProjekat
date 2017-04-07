package controllers;

import java.util.List;

import models.Magacin;
import models.PoslovnaGodina;
import models.PoslovniPartner;
import models.Preduzece;
import models.PrometniDokument;
import models.Roba;
import models.RobnaKartica;
import models.StavkaDokumenta;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class PrometniDokumenti extends Controller {

	public static void show(String mode){
    	List<PrometniDokument> prometniDokumenti = PrometniDokument.findAll();
    	List<Magacin> magacini = Magacin.findAll();
    	List<PoslovniPartner> poslovniPartneri = PoslovniPartner.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(prometniDokumenti,magacini,poslovniPartneri, mode);
    }
	
	public static void add(@Required String vrstaDokumenta,@Required Integer redniBrojDokumenta,  @Required String datumFormiranja, @Required String datumKnjizenja,@Required String status, long magacin, long poslovniPartner ) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			PrometniDokument prometniDokument = new PrometniDokument();
			prometniDokument.vrstaDokumenta = vrstaDokumenta;
			prometniDokument.redniBrojDokumenta = redniBrojDokumenta;
			prometniDokument.datumFormiranja = datumFormiranja;
			prometniDokument.datumKnjizenja = datumKnjizenja;
			prometniDokument.status = status;
			prometniDokument.magacin = Magacin.findById(magacin);
			prometniDokument.poslovniPartner = PoslovniPartner.findById(poslovniPartner);
			prometniDokument.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required String vrstaDokumenta,@Required Integer redniBrojDokumenta,  @Required String datumFormiranja, @Required String datumKnjizenja,@Required String status,long magacin,long poslovniPartner, long id) {
    	PrometniDokument pD = PrometniDokument.findById(id);
    	if(pD!=null){
    	pD.vrstaDokumenta = vrstaDokumenta;
    	pD.redniBrojDokumenta = redniBrojDokumenta;
    	pD.datumFormiranja = datumFormiranja;
    	pD.datumKnjizenja = datumKnjizenja;
    	pD.status = status;
    	pD.magacin = Magacin.findById(magacin);
    	pD.poslovniPartner = PoslovniPartner.findById(poslovniPartner);
    	
    	pD.save();
    	}
    	show("edit");
    	}

    public static void filter(String vrstaDokumenta,Integer redniBrojDokumenta,String datumFormiranja,String datumKnjizenja,String status) {
		
    	List<PrometniDokument> prometniDokumenti = PrometniDokument.find("byVrstaDokumentaLikeAndDatumFormiranjaLikeAndDatumKnjizenjaLikeAndStatusLike","%"+ vrstaDokumenta.toLowerCase() +"%", "%"+ datumFormiranja.toLowerCase() +"%", "%"+ datumKnjizenja.toLowerCase() +"%", "%"+ status.toLowerCase() +"%").fetch();
    	List<Magacin> magacini = Magacin.findAll(); 
    	List<PoslovniPartner> poslovniPartneri = PoslovniPartner.findAll(); 
    	String mode = "edit";
    	renderTemplate("PrometniDokumenti/show.html", prometniDokumenti,magacini,poslovniPartneri, mode);
    	
    	}
      public static void proknjizi() {
    	PrometniDokument dokument = PrometniDokument.findById(Long.parseLong("1"));
    	List<StavkaDokumenta> stavke = dokument.stavkeDokumenata;
    	for(int i=0;stavke.size() > i; i++)
    	{    	
    		Roba roba = stavke.get(i).roba;
    		List<RobnaKartica> robneKartice = roba.robneKartice;
    		if(robneKartice.isEmpty())
    		{
    			RobnaKartica kartica = new RobnaKartica();
    			kartica.pocStanjeKolicine=0;
    			kartica.pocStanjeVrednosti=0.0;
    			kartica.prometIzlazaKolicine=0;
    			kartica.prometIzlazaVrednosti=0;
    			kartica.prometUlazaKolicine=0;
    			kartica.prometUlazaVrednosti=0;
    			kartica.ukupnaKolicina=0;
    			kartica.ukupnaVrednost=0.0;
    			kartica.cena=0.0;
    			kartica.magacin = Magacin.findById(Long.parseLong("1"));
    			kartica.poslovnaGodina = PoslovnaGodina.findById(Long.parseLong("1"));
    			kartica.roba = roba;
    			kartica.save();
    			
    		}
    		
    		
    	}
    	show("");
	}
        
    	public static void remove(Long id){
    		PrometniDokument promentiDokument = PrometniDokument.findById(id);
    		promentiDokument.delete();
    		show("");
    	}
    

}
