package cmg.geosamples.geosamples.controller;

import cmg.geosamples.geosamples.domain.Sample;
import cmg.geosamples.geosamples.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@RepositoryRestController
public class SampleController {

  @Autowired
  SampleService sampleService;

  @RequestMapping(value="/samples", method=RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getSamples(Sample sample) {
    List<Sample> sampleList = sampleService.findSamples(sample);
    return ResponseEntity.ok(sampleList);
  }
}
