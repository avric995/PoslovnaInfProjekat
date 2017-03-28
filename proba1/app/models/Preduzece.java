package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
		@Column(nullable = false, unique = true)
		public String sifra;
		@Column(nullable = false)
		public String naziv;
		@Column(nullable = false)
		public String PIB;
		@Column(nullable = true)
		public String sifraDelatnosti;
		@Column(nullable = false)
		public String registarskiBroj;
		@Column(nullable = false)
		public boolean aktivno;
}