package cmg.geosamples.geosamples.service;

import cmg.geosamples.geosamples.domain.Sample;
import cmg.geosamples.geosamples.repo.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@Component
public class SampleService {

  @Autowired
  SampleRepository sampleRepository;

  private ExampleMatcher getMatcher() {
    ExampleMatcher matcher = ExampleMatcher.matchingAll()
      .withMatcher("lake", startsWith().ignoreCase())
      .withMatcher("device", startsWith().ignoreCase())
      .withMatcher("platform", startsWith().ignoreCase())
      .withMatcher("cruise", startsWith().ignoreCase())
      .withMatcher("facility_code", startsWith().ignoreCase())
      .withMatcher("date", startsWith().ignoreCase());
      // Water depth range
      //.withMatcher("water_depth", match -> match);
      // Geospatial (within bounding box)
    return matcher;
  }

  public List<Sample> findSamples(Sample probe) {
    return sampleRepository.findAll(Example.of(probe, getMatcher()));
  }

}

