package orai.klimatas;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@Autowired
	private MiestaiRepository miestai_repository;
	@Autowired
	private TemperaturosRepository temperaturos_repository;
	
	@Autowired 
	EntityManagerFactory factory;	
	
	// @Bean
	public SessionFactory sessionFactory() {

		
	        if (factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
	        return factory.unwrap(SessionFactory.class);
	}	
	
	@RequestMapping(path="/")
	public  String pradzia() {
		
		return "pradzia";
	}
	
	@RequestMapping(path="/miestai", method= {RequestMethod.GET,RequestMethod.POST})
	public String visiMiestai( 
			@RequestParam(name="id", required =true, defaultValue="")String id,
			@RequestParam(name="pav", required =true, defaultValue="")String pav,
			@RequestParam(name="kodas_salies", required =true, defaultValue="")String kodas_salies,
			@RequestParam(name="platuma", required =true, defaultValue="")String platuma,
			@RequestParam(name="ilguma", required =true, defaultValue="")String ilguma,
			@RequestParam(name="skaicius_gyv", required =true, defaultValue="")String skaicius_gyv	,
			@RequestParam(name="plotas", required =true, defaultValue="")String plotas,
			@RequestParam(name="duom_gav_laikas", required =true, defaultValue="")String duom_gav_laikas,
			
			@RequestParam(name="siusti", required =true, defaultValue="")String siusti,

			Model model ) throws IOException {
		
		String url_tpl = "miestai";
		
		Iterable<Miestai> mano_miestai = miestai_repository.findAll();
		model.addAttribute("visu_miestu_info",mano_miestai );
		
		if (siusti != null && siusti.equals("Patvirtinti")) {
			
			Miestai miestai = new Miestai ( 
				null	
				,pav
				, kodas_salies
				, Double.parseDouble ( platuma )
				, Double.parseDouble ( ilguma )
				, Integer.parseInt ( skaicius_gyv )
				, Double.parseDouble ( plotas )
				, duom_gav_laikas
			);
			miestai_repository.save(miestai);
			
			return url_tpl;
			
			/*url_tpl="redirect:nuomos_zurnalas?kliento_id="+apklausa.getId();
			return url_tpl;*/
		}
		
		return url_tpl;

	}
	@RequestMapping(path="/temperaturos", method= {RequestMethod.GET,RequestMethod.POST})
	public String visosTemperaturos( 
			@RequestParam(name="id", required =true, defaultValue="")String id,
			@RequestParam(name="idMiesto", required =true, defaultValue="")String idMiesto,
			@RequestParam(name="metai", required =true, defaultValue="")String metai,
			@RequestParam(name="laikotarpis", required =true, defaultValue="")String laikotarpis,
			@RequestParam(name="temperatura", required =true, defaultValue="")String temperatura,
			
			@RequestParam(name="siusti", required =true, defaultValue="")String siusti,

			Model model ) throws IOException {
		
		String url_tpl = "temperaturos";
		
		Iterable<Temperaturos> mano_temperaturos = temperaturos_repository.findAll();
		model.addAttribute("visu_temperaturu_info",mano_temperaturos );
		
		Iterable<Miestai> mano_miestai = miestai_repository.findAll();
		model.addAttribute("visu_miestu_info",mano_miestai );
		
		if (siusti != null && siusti.equals("Patvirtinti")) {
			
			Temperaturos miestai = new Temperaturos ( 
				null	
				, Integer.parseInt ( idMiesto )
				, Integer.parseInt ( metai )
				, laikotarpis
				, Double.parseDouble ( temperatura )
			);
			temperaturos_repository.save(miestai);
			
			return url_tpl;
			
			/*url_tpl="redirect:nuomos_zurnalas?kliento_id="+apklausa.getId();
			return url_tpl;*/
		}
		
		return url_tpl;

	}
	
	@RequestMapping(path="/ataskaita", method= {RequestMethod.GET,RequestMethod.POST})
	public String ataskaita( 
			@RequestParam(name="ataskaita", required =true, defaultValue="")String ataskaita,
			@RequestParam(name="laikotarpis", required =true, defaultValue="")String laikotarpis,
			
			Model model ) throws IOException {
		
		String url_tpl = "ataskaita";
		
		Session session = this.sessionFactory().openSession();
		AtaskaitaFinal ataskaita_galutinis =  new AtaskaitaFinal( session );
		
		// model.addAttribute("ataskaita", ataskaita_galutinis.duomenuFormavimas(laikotarpis));
		
		List<Object[]> ataskaita_zalia = ataskaita_galutinis.duomenuFormavimas(laikotarpis);
		
		model.addAttribute("ataskaita_sukinys", ataskaita_galutinis.ataskaitaSukinys(ataskaita_zalia));
		
		return url_tpl;

	}
}
