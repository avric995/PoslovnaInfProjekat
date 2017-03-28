package controllers;

import java.util.List;

import models.PrometniDokument;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class PrometniDokumenti extends Controller {

	public static void show(String mode){
    	List<PrometniDokument> prometniDokumenti = PrometniDokument.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(prometniDokumenti, mode);
    }
	
	public static void add(@Required String vrstaDokumenta,@Required Integer redniBrojDokumenta,  @Required String datumFormiranja, @Required String datumKnjizenja,@Required String status ) {
		
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
			prometniDokument.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required String vrstaDokumenta,@Required Integer redniBrojDokumenta,  @Required String datumFormiranja, @Required String datumKnjizenja,@Required String status, long id) {
    	PrometniDokument pD = PrometniDokument.findById(id);
    	if(pD!=null){
    	pD.vrstaDokumenta = vrstaDokumenta;
    	pD.redniBrojDokumenta = redniBrojDokumenta;
    	pD.datumFormiranja = datumFormiranja;
    	pD.datumKnjizenja = datumKnjizenja;
    	pD.status = status;
    	
    	pD.save();
    	}
    	show("edit");
    	}

    public static void filter() {
    		/*List<Drzava> drzave = Drzava.find("byNazivLikeAndOznakaLike", "%"+naziv+"%", "%"+oznaka+"%").fetch();
    		String mode = "edit";
    		renderTemplate("Drzave/show.html", drzave, mode);*/
    	}
        
    	public static void remove(Long id){
    		PrometniDokument promentiDokument = PrometniDokument.findById(id);
    		promentiDokument.delete();
    		show("");
    	}
    

}
