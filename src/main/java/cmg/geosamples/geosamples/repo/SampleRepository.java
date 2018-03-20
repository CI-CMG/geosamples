package cmg.geosamples.geosamples.repo;

import cmg.geosamples.geosamples.domain.Sample;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<Sample, Integer> {
  
}
