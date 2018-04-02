package cmg.geosamples.geosamples.controller;

import cmg.geosamples.geosamples.domain.Sample;
import cmg.geosamples.geosamples.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
public class SampleController {

  @Autowired
  SampleService sampleService;

  @RequestMapping(value="/samples", method=RequestMethod.GET)
  @ResponseBody
  public List<Sample> getSamples(
    @RequestParam final MultiValueMap<String, String> parameters) {
    return sampleService.findSamples(parameters);
  }
}
