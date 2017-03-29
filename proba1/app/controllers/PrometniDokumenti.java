package controllers;

import java.util.List;

import models.Magacin;
import models.PoslovniPartner;
import models.PrometniDokument;
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
