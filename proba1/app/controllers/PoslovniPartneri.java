package controllers;

import java.util.List;

import models.Drzava;
import models.NaseljenoMesto;
import models.PoslovniPartner;
import models.Preduzece;
import net.sf.oval.constraint.MaxSize;
import play.data.validation.Required;
import play.mvc.*;

@With(Secure.class)
public class PoslovniPartneri extends Controller {

	public static void show(String mode){
    	List<PoslovniPartner> poslovniPartneri = PoslovniPartner.findAll();
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(poslovniPartneri,preduzeca,naseljenaMesta, mode);
    }
	
	public static void add(@Required String tipPartnera,@Required String nazivPartnera,  @Required String pib, @Required String adresa, long preduzece, long naseljenoMesto) {
		
/*		if(validation.hasErrors()) {
			for(play.data.validation.Error error : validation.errors()) {
			System.out.println(error.message());
			}
			validation.keep();
			show("add");
		}else {*/
			PoslovniPartner poslovniPartner = new PoslovniPartner();
			poslovniPartner.tipPartnera = tipPartnera;
			poslovniPartner.nazivPartnera = nazivPartnera;
			poslovniPartner.pib = pib;
			poslovniPartner.adresa = adresa;
			poslovniPartner.preduzece = Preduzece.findById(preduzece);
			poslovniPartner.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
			poslovniPartner.save();
			validation.keep();
			show("add");
	}
    public static void edit(@Required String tipPartnera,@Required String nazivPartnera,  @Required String pib, @Required String adresa,long preduzece,long naseljenoMesto, long id) {
    	PoslovniPartner pP = PoslovniPartner.findById(id);
    	if(pP!=null){
    	pP.tipPartnera = tipPartnera;
    	pP.nazivPartnera = nazivPartnera;
    	pP.pib = pib;
    	pP.adresa = adresa;
    	pP.preduzece = Preduzece.findById(preduzece);
    	pP.naseljenoMesto = NaseljenoMesto.findById(naseljenoMesto);
    	
    	pP.save();
    	}
    	show("edit");
    	}

    public static void filter(String tipPartnera,String nazivPartnera, String pib,  String adresa) {
    		
    	List<PoslovniPartner> poslovniPartneri = PoslovniPartner.find("byTipPartneraLikeAndNazivPartneraLikeAndPibLikeAndAdresaLike","%"+ tipPartnera.toLowerCase() +"%","%"+ nazivPartnera.toLowerCase() +"%", "%"+pib.toLowerCase()+"%","%"+adresa.toLowerCase()+"%").fetch();
    	List<Preduzece> preduzeca = Preduzece.findAll();
    	List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
    	String mode = "edit";
    	renderTemplate("PoslovniPartneri/show.html", poslovniPartneri,preduzeca,naseljenaMesta, mode);
    	
    	}
        
    	public static void remove(Long id){
    		PoslovniPartner poslovniPartner = PoslovniPartner.findById(id);
    		poslovniPartner.delete();
    		show("");
    	}
    

}
