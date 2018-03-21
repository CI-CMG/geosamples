package cmg.geosamples.geosamples.repo;

import cmg.geosamples.geosamples.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Integer> {

}
