package cmg.geosamples.geosamples.service;

import cmg.geosamples.geosamples.config.PredicateService;
import cmg.geosamples.geosamples.domain.Sample;
import cmg.geosamples.geosamples.repo.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.querydsl.core.types.Predicate;
import org.springframework.util.MultiValueMap;

@Component
public class SampleService {

  @Autowired
  SampleRepository sampleRepository;

  @Autowired
  PredicateService predicateService;

  public Page<Sample> findSamples(MultiValueMap<String, String> parameters,
                                  Pageable page) {

    Predicate predicate = predicateService.getPredicateFromParameters(parameters, Sample.class);
    return sampleRepository.findAll(predicate, page);
  }

}

