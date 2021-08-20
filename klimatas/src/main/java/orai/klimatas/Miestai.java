package orai.klimatas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Miestai {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String pav;
    private String kodas_salies;
    private Double platuma;
    private Double ilguma;
    private Integer skaicius_gyv;
    private Double plotas;
    private String duom_gav_laikas;
    
    public Miestai(){	
	}
    
    public Miestai(Integer id, String pav, String kodas_salies, Double platuma, Double ilguma, Integer skaicius_gyv, Double plotas, String duom_gav_laikas ) {
		super();
		
		this.id = id;
		this.pav = pav;
		this.kodas_salies = kodas_salies;
		this.platuma = platuma;
		this.ilguma = ilguma;
		this.skaicius_gyv = skaicius_gyv;
		this.plotas = plotas;
		this.duom_gav_laikas = duom_gav_laikas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public String getKodas_salies() {
		return kodas_salies;
	}

	public void setKodas_salies(String kodas_salies) {
		this.kodas_salies = kodas_salies;
	}

	public Double getPlatuma() {
		return platuma;
	}

	public void setPlatuma(Double platuma) {
		this.platuma = platuma;
	}

	public Double getIlguma() {
		return ilguma;
	}

	public void setIlguma(Double ilguma) {
		this.ilguma = ilguma;
	}

	public Integer getSkaicius_gyv() {
		return skaicius_gyv;
	}

	public void setSkaicius_gyv(Integer skaicius_gyv) {
		this.skaicius_gyv = skaicius_gyv;
	}

	public Double getPlotas() {
		return plotas;
	}

	public void setPlotas(Double plotas) {
		this.plotas = plotas;
	}

	public String getDuom_gav_laikas() {
		return duom_gav_laikas;
	}

	public void setDuom_gav_laikas(String duom_gav_laikas) {
		this.duom_gav_laikas = duom_gav_laikas;
	}
}