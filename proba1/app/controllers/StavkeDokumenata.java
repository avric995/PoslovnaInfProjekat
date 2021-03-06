package controllers;

import java.util.List;

import models.PrometniDokument;
import models.Roba;
import models.StavkaDokumenta;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class StavkeDokumenata extends Controller {

	public static void show(String mode){
    	List<StavkaDokumenta> stavkeDokumenata = StavkaDokumenta.findAll();
    	List<PrometniDokument> prometniDokumenti = PrometniDokument.findAll();
    	List<Roba> robe = Roba.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(stavkeDokumenata,prometniDokumenti,robe, mode);
    }
	
	public static void add(@Required Integer kolicina,@Required Double cena,  @Required Double vrednost, long prometniDokument, long roba) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			StavkaDokumenta stavkaDokumenta = new StavkaDokumenta();
			stavkaDokumenta.kolicina = kolicina;
			stavkaDokumenta.cena = cena;
			stavkaDokumenta.vrednost = vrednost;
			stavkaDokumenta.prometniDokument = PrometniDokument.findById(prometniDokument);
			stavkaDokumenta.roba = Roba.findById(roba);
			stavkaDokumenta.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required Integer kolicina,@Required Double cena,  @Required Double vrednost,long prometniDokument,long roba, long id) {
    	StavkaDokumenta sD = StavkaDokumenta.findById(id);
    	if(sD!=null){
    	sD.kolicina = kolicina;
    	sD.cena = cena;
   		sD.vrednost = vrednost;
   		sD.prometniDokument = PrometniDokument.findById(prometniDokument);
   		sD.roba = Roba.findById(roba);
    	
    		sD.save();
    	}
    	show("edit");
    	}

    public static void filter() {
    		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
    		String mode = "edit";
    		renderTemplate("Drzave/show.html", drzave, mode);*/
    	}
        
    	public static void remove(Long id){
    		StavkaDokumenta stavkaDokumenta = StavkaDokumenta.findById(id);
    		stavkaDokumenta.delete();
    		show("");
    	}
    

}
