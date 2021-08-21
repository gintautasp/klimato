package orai.klimatas;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

	public interface MiestaiRepository extends CrudRepository<Miestai, Integer>{

		Optional<Miestai> findByPav(String pav);
}
