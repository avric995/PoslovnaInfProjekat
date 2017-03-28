package controllers;

import java.util.List;

import models.Radnik;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Radnici extends Controller{

    public static void show(){
    	List<Radnik> radnici = Radnik.findAll();
    	render(radnici);
    }
    
    
}
