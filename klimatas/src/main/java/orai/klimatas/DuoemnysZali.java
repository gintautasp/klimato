package orai.klimatas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DuoemnysZali {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String laikotarpis;
    private String rodiklis;
    private String miestas;
    private String periodiskumas;
    private String mat_vnt;
    private Double reiksme;
    
    public DuoemnysZali(){	
	}
    
    public DuoemnysZali(Integer id, String laikotarpis, String rodiklis, String miestas, String periodiskumas, String mat_vnt, Double reiksme) {
		super();
		
		this.id = id;
		this.laikotarpis = laikotarpis;
		this.rodiklis = rodiklis;
		this.miestas = miestas;
		this.periodiskumas = periodiskumas;
		this.mat_vnt = mat_vnt;
		this.reiksme = reiksme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLaikotarpis() {
		return laikotarpis;
	}

	public void setLaikotarpis(String laikotarpis) {
		this.laikotarpis = laikotarpis;
	}

	public String getRodiklis() {
		return rodiklis;
	}

	public void setRodiklis(String rodiklis) {
		this.rodiklis = rodiklis;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public String getPeriodiskumas() {
		return periodiskumas;
	}

	public void setPeriodiskumas(String periodiskumas) {
		this.periodiskumas = periodiskumas;
	}

	public String getMat_vnt() {
		return mat_vnt;
	}

	public void setMat_vnt(String mat_vnt) {
		this.mat_vnt = mat_vnt;
	}

	public Double getReiksme() {
		return reiksme;
	}

	public void setReiksme(Double reiksme) {
		this.reiksme = reiksme;
	}
}
