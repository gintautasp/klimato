package orai.klimatas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Temperaturos {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private Integer idMiesto;
    private Integer	metai;
    private String laikotarpis;
    private Double temperatura;
    
    @ManyToOne
    @JoinColumn(name="idMiesto", insertable=false, updatable=false)
    private Miestai miestai;
    
    public Temperaturos(){	
	}
    
    public Temperaturos(Integer id, Integer idMiesto, Integer metai, String laikotarpis, Double temperatura ) {
		super();
		
		this.id = id;
		this.idMiesto = idMiesto;
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

	public Integer getIdMiesto() {
		return idMiesto;
	}

	public void setIdMiesto(Integer idMiesto) {
		this.idMiesto = idMiesto;
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
	
	public Miestai getMiestai() {
		return miestai;
	}

	public void setMiestai(Miestai miestai) {
		this.miestai = miestai;
	}
}