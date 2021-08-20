package orai.klimatas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class AtaskaitaFinal {
	
protected Session em;
	
	public AtaskaitaFinal() {}
	
	public AtaskaitaFinal(  Session em  ) {
		    this.em = em;
	}
	
	 public List<Object[]> duomenuFormavimas( String ataskaita ) {
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
		    return (List<Object[]>) query.getResultList();
	  }
	 
	 public HashSet<String> miestuSarasas(List<Object[]> ataskaita) {
		 
		 HashSet<String> miestu_sarasas = new HashSet<String>();
		 
			for(int i =0; i<ataskaita.size(); i++ ){
			    // System.out.println("elementas "+ ataskaita );
			    miestu_sarasas.add( (String) ( (Object[]) ataskaita.get(i) )[1] );
			}
			//System.out.println(atsiskaitymas);
		// miestu_sarasas.add(atas)
		 return miestu_sarasas;
	 }
}
