package cmg.geosamples.geosamples.repo;

import cmg.geosamples.geosamples.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface SampleRepository extends JpaRepository<Sample, Integer>,
  QueryByExampleExecutor<Sample> {
}
