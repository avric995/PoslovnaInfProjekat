package controllers;

import java.util.List;

import models.Magacin;
<<<<<<< HEAD
=======
import models.Radnik;
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Magacini extends Controller{

	public static void show(String mode){
    	List<Magacin> magacini = Magacin.findAll();
<<<<<<< HEAD
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(magacini, mode);
=======
    	List<Radnik> radnici = Radnik.findAll();
    	if (mode == null || mode.equals(""))
    		 mode = "edit";
    	
    	render(magacini,radnici, mode);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
    }
    
   
    
<<<<<<< HEAD
    public static void create(String naziv) {
=======
    public static void create(String naziv, long radnik) {
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
//		validation.required(oznaka);
//		validation.required(naziv);
//		validation.minSize(oznaka, 2);
//		validation.maxSize(oznaka, 5);
//		if(validation.hasErrors()) {
//			 for(play.data.validation.Error error : validation.errors()) {
//			 System.out.println(error.message());
//			 }
//			 validation.keep();
//			 show("add");
//			}
    	Magacin mag = new Magacin();
		mag.naziv = naziv;
<<<<<<< HEAD
=======
		mag.radnik = Radnik.findById(radnik);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
		List<Magacin> magacini = Magacin.findAll();
		mag.save();
		show("add");
	}

<<<<<<< HEAD
	public static void edit(String naziv,Long id) {
		Magacin m = Magacin.findById(id);
		if(m!=null){
			m.naziv=naziv;
=======
	public static void edit(String naziv,long radnik, Long id) {
		Magacin m = Magacin.findById(id);
		if(m!=null){
			m.naziv=naziv;
			m.radnik = Radnik.findById(radnik);
>>>>>>> 41960a067b6d58f5af7102db222a6e644a797573
			m.save();
		}
		show("");
		}

	public static void filter() {
	
	}
    
	public static void remove(Long id){
		Magacin mag = Magacin.findById(id);
		mag.delete();
		show("");
	}
	public static void logout(){
		   try {
			Secure.logout();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
    
}
