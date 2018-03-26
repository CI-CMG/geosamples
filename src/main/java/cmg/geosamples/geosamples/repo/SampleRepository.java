package cmg.geosamples.geosamples.repo;

import cmg.geosamples.geosamples.domain.QSample;
import cmg.geosamples.geosamples.domain.Sample;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface SampleRepository extends JpaRepository<Sample, Integer>,
  QuerydslPredicateExecutor<Sample>, QuerydslBinderCustomizer<QSample> {

  @Override
  default public void customize(QuerydslBindings bindings, QSample sample) {
    bindings.bind(String.class).first(
      (StringPath path, String value) -> path.containsIgnoreCase(value));
    bindings.bind(sample.water_depth).first((path, value) ->
      path.goe(value));
    bindings.bind(sample.end_water_depth).first((path, value) ->
      path.loe(value));
  }
}
