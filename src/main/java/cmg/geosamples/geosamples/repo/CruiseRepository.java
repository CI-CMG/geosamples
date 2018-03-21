package cmg.geosamples.geosamples.repo;

import cmg.geosamples.geosamples.domain.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CruiseRepository extends JpaRepository<Cruise, Integer> {

}
