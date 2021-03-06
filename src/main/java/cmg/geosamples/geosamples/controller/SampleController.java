package cmg.geosamples.geosamples.controller;

import cmg.geosamples.geosamples.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

@RepositoryRestController
public class SampleController {

  @Autowired
  SampleService sampleService;

  @RequestMapping(value="/samples", method=RequestMethod.GET,
    headers={"content-type=application/vnd.google-earth.kml+xml"})
  @ResponseBody
  public void getSamplesAsText(
    @RequestParam final MultiValueMap<String, String> parameters,
    HttpServletResponse response) {
    sampleService.findSamples(parameters, response);
  }

  @RequestMapping(value="/samples", method=RequestMethod.GET,
    headers={"content-type=text/csv"})
  @ResponseBody
  public void getSamplesAsCsv(
    @RequestParam final MultiValueMap<String, String> parameters,
    HttpServletResponse response) {
    sampleService.samplesToCsv(parameters, response);
  }
}
