package orai.klimatas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class AtaskaitaFinal {
	
protected Session em;
	
	public AtaskaitaFinal() {}
	
	public AtaskaitaFinal(  Session em  ) {
		    this.em = em;
	}
	
	 public List<Ataskaita> duomenuFormavimas( String ataskaita ) {
		 String filtruoti = ")ORDER BY "
		 								+ "`temperaturos`.`metai`";
		 if(ataskaita != null) {
			 
				 filtruoti = ") WHERE `laikotarpis` = '"+ ataskaita +"'"
		  					+"ORDER BY "
		  					+	"`temperaturos`.`metai`";
		 }
		  	String uzklausa_pagal_laikotarpi =
		  				
		  			"SELECT" 

		  		    	+	" `temperaturos`.`id`,"
			  		    +	"`miestai`.`pav` AS `miestas` ,"
			  		    +	"`temperaturos`.`metai`,"
			  		    +	"`temperaturos`.`laikotarpis`,"
			  		    +	"`temperaturos`.`temperatura`"
			  		+"FROM "
			  			+	"`temperaturos`" 
			  		+"JOIN `miestai` ON (`temperaturos`.`id_miesto`=`miestai`.`id`" 
			  		+ filtruoti;
		  	
		  	System.out.println ( uzklausa_pagal_laikotarpi );
		    Query query = em.createNativeQuery ( uzklausa_pagal_laikotarpi );
		    return (List<Ataskaita>) query.getResultList();
	  }
	 
	 public List<String> miestuSarasas(List<Ataskaita> ataskaita) {
		 
		 List<String> miestu_sarasas = new ArrayList<String>(ataskaita.size());
		 /*int i =0;
			for( Ataskaita element : ataskaita ){
			    System.out.println("elementas "+ ataskaita );
			    i++;
			}*/
			//System.out.println(atsiskaitymas);
		// miestu_sarasas.add(atas)
		 return miestu_sarasas;
	 }
}
