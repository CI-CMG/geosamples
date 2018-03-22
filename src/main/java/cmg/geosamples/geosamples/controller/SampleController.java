package cmg.geosamples.geosamples.controller;

import cmg.geosamples.geosamples.repo.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class SampleController {

  private final SampleRepository sampleRepository;

  @Autowired
  public SampleController(SampleRepository sampleRepository) {
    this.sampleRepository = sampleRepository;
  }

  @RequestMapping(value="/samples", method=RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getSamples() {
    return ResponseEntity.ok("test");
  }
}
