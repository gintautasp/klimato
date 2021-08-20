package orai.klimatas;

import java.math.BigDecimal;
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
	
	 public List<Object[]> duomenuFormavimas( String pagal ) { 
		 
		 String filtruoti = " 1 ";
		 
		 if ( pagal != null ) {
			 
				 filtruoti = "`laikotarpis` = '"+ pagal +"'";
		 }
		 String uzklausa_pagal_laikotarpi =
		  				
		  			"SELECT" 

		  		    	+	" `temperaturos`.`id`,"
			  		    +	"`miestai`.`pav` AS `miestas` ,"
			  		    +	"`temperaturos`.`metai`,"
			  		    +	"`temperaturos`.`laikotarpis`,"
			  		    +	"`temperaturos`.`temperatura`"
			  		+ " FROM "
			  			+	"`temperaturos`" 
			  		+ " LEFT JOIN `miestai` ON (`temperaturos`.`id_miesto`=`miestai`.`id`)" 
			  		+ " WHERE " + filtruoti
			  		+ " ORDER BY `temperaturos`.`metai`,`temperaturos`.`id_miesto`"
			  ;
		  	
		  	System.out.println ( uzklausa_pagal_laikotarpi );
		    Query query = em.createNativeQuery ( uzklausa_pagal_laikotarpi );
		    return (List<Object[]>) query.getResultList();
	  }
	 
	 public AtaskaitaSukinys ataskaitaSukinys(List<Object[]> ataskaita) {
		 
		 AtaskaitaSukinys ataskaita_sukinys = new AtaskaitaSukinys();
		 
			for(int i =0; i<ataskaita.size(); i++ ){
			    // System.out.println("elementas "+ ataskaita );
			    ataskaita_sukinys.miestu_sarasas.add( (String) ( (Object[]) ataskaita.get(i) )[1] );
			    ataskaita_sukinys.metu_sarasas.add( (Integer) ( (Object[]) ataskaita.get(i) )[2] );
			}
			
			ataskaita_sukinys.setTemperaturosSizes();
			
			for(int i =0; i<ataskaita.size(); i++ ){
				
				String miestas = (String) ( (Object[]) ataskaita.get(i) )[1];
				Integer metai = (Integer) ( (Object[]) ataskaita.get(i) )[2];
				BigDecimal temperatura = (BigDecimal) ( (Object[]) ataskaita.get(i) )[4];
				ataskaita_sukinys.addTemperatura(metai, miestas, temperatura);
			}
			
		 return ataskaita_sukinys;
	 }
}
