package orai.klimatas;

import javax.persistence.Entity;

public class Ataskaita {	//turi buti panasi i pagrindine lentele tik setteriai ir getteriai atitinka po selecto gautus laukelius ir ju eiliskumas turi buti toks pats kaip lenteleje
    
    private Integer id;
    private String miestas;
    private Integer	metai;
    private String laikotarpis;
    private Double temperatura;
    
    public Ataskaita(){	
	}
    
    public Ataskaita(Integer id, String miestas, Integer metai, String laikotarpis, Double temperatura ) {
		super();
		
		this.id = id;
		this.miestas = miestas;
		this.metai = metai;
		this.laikotarpis = laikotarpis;
		this.temperatura = temperatura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public Integer getMetai() {
		return metai;
	}

	public void setMetai(Integer metai) {
		this.metai = metai;
	}

	public String getLaikotarpis() {
		return laikotarpis;
	}

	public void setLaikotarpis(String laikotarpis) {
		this.laikotarpis = laikotarpis;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

}