package controllers;

import java.util.List;

import models.PrometniDokument;
<<<<<<< HEAD
=======
import models.Roba;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
import models.StavkaDokumenta;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class StavkeDokumenata extends Controller {

	public static void show(String mode){
    	List<StavkaDokumenta> stavkeDokumenata = StavkaDokumenta.findAll();
    	List<PrometniDokument> prometniDokumenti = PrometniDokument.findAll();
<<<<<<< HEAD
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(stavkeDokumenata,prometniDokumenti, mode);
    }
	
	public static void add(@Required Integer kolicina,@Required Double cena,  @Required String vrednost, long prometniDokument) {
=======
    	List<Roba> robe = Roba.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(stavkeDokumenata,prometniDokumenti,robe, mode);
    }
	
	public static void add(@Required Integer kolicina,@Required Double cena,  @Required String vrednost, long prometniDokument, long roba) {
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
		
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
<<<<<<< HEAD
=======
			stavkaDokumenta.roba = Roba.findById(roba);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
			stavkaDokumenta.save();
			validation.keep();
			show("add");
	}
<<<<<<< HEAD
    public static void edit(@Required Integer kolicina,@Required Double cena,  @Required String vrednost,long prometniDokument, long id) {
=======
    public static void edit(@Required Integer kolicina,@Required Double cena,  @Required String vrednost,long prometniDokument,long roba, long id) {
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    	StavkaDokumenta sD = StavkaDokumenta.findById(id);
    	if(sD!=null){
    	sD.kolicina = kolicina;
    	sD.cena = cena;
   		sD.vrednost = vrednost;
   		sD.prometniDokument = PrometniDokument.findById(prometniDokument);
<<<<<<< HEAD
=======
   		sD.roba = Roba.findById(roba);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    	
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
