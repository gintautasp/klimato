package orai.klimatas;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

public class AtaskaitaSukinys {

	 public HashSet<String> miestu_sarasas;
	 public HashSet<Integer> metu_sarasas;
	 public BigDecimal[][] temperaturos; 
	 
	 
	 public AtaskaitaSukinys() {
		 
		 miestu_sarasas = new HashSet<String>();
		 metu_sarasas = new HashSet<Integer>();
	 }
	 
	 public void setTemperaturosSizes() {
		 
		 temperaturos = new BigDecimal[ metu_sarasas.size()] [ miestu_sarasas.size() ];
	 }
	 
	 public void addTemperatura (Integer metai, String miestas, BigDecimal temperatura ) {

		 Integer nr_miestai = Arrays.asList( miestu_sarasas.toArray() ).indexOf ( miestas );		 
		 Integer nr_metai = Arrays.asList( metu_sarasas.toArray() ).indexOf ( metai );
		 
		 temperaturos [ nr_metai ] [ nr_miestai ] = temperatura;
	 }
	 
	 public BigDecimal getTemperatura (Integer metai, String miestas) {

		 Integer nr_miestai = Arrays.asList( miestu_sarasas.toArray() ).indexOf ( miestas );		 
		 Integer nr_metai = Arrays.asList( metu_sarasas.toArray() ).indexOf ( metai );
		 
		 return temperaturos [ nr_metai ] [ nr_miestai ];
	 }
}
