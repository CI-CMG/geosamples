package cmg.geosamples.geosamples.service;

  import cmg.geosamples.geosamples.config.PredicateService;
  import cmg.geosamples.geosamples.domain.Sample;
  import cmg.geosamples.geosamples.repo.SampleRepository;
  import freemarker.template.Configuration;
  import freemarker.template.Template;
  import freemarker.template.TemplateExceptionHandler;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Component;
  import com.querydsl.core.types.Predicate;
  import org.springframework.util.MultiValueMap;

  import javax.servlet.ServletException;
  import javax.servlet.ServletOutputStream;
  import javax.servlet.http.HttpServletResponse;
  import java.io.*;
  import java.util.ArrayList;
  import freemarker.template.SimpleHash;

  import java.util.List;
  import java.util.Map;

@Component
public class SampleService {
  Configuration cfg;
  @Autowired
  SampleRepository sampleRepository;
  @Autowired
  PredicateService predicateService;
  @Autowired
  LegacyKmlService legacyKmlService;

  public void findSamples(MultiValueMap<String, String> parameters,
                                  HttpServletResponse response) {
    List<Sample> sampleList = getSampleList(parameters);
    SimpleHash kmlHashMap = buildKmlHash(sampleList, parameters);
    generateKml(kmlHashMap, response);
  }

  private List<Sample> getSampleList(MultiValueMap<String, String> parameters) {
    Predicate predicate = predicateService.getPredicateFromParameters(
      parameters, Sample.class);
    List<Sample> sampleList = new ArrayList<>();
    Iterable<Sample> iterable = sampleRepository.findAll(predicate);
    iterable.forEach(sampleList::add);
    return sampleList;
  }

  // TODO: Extend freemarker Template to build hash from Sample List?
  private SimpleHash buildKmlHash(List<Sample> sampleList,
                                           MultiValueMap<String, String> parameters){
    // Re-implement similar logic of deriving KML global params
    SimpleHash dataModel = new SimpleHash();
    Map<String, String> globals = legacyKmlService.getGlobalParams(parameters);
    dataModel.put("lat", globals.get("global_lat"));
    dataModel.put("lon", globals.get("global_lon"));
    dataModel.put("facility", globals.get("global_facility"));
    dataModel.put("samples", sampleList);
    return dataModel;
  }

  private void generateKml(SimpleHash sampleList, HttpServletResponse response) {
    String filename = "GeoSamples.kml";
    try {
      Template kmlTempl = getFreeMarkerTemplate();
      kmlTempl.process(sampleList, getResponseWriter(response, filename));
    } catch (java.io.IOException io) {
      System.out.println(io);
    } catch (javax.servlet.ServletException se) {

    } catch (freemarker.template.TemplateException te) {
      System.out.println(te);
    }
  }

  private void initializeFreemarkerConfig() {
    // TODO: Consider options for storing config in application.yml
    cfg = new Configuration(Configuration.VERSION_2_3_27);
    try {
      cfg.setDirectoryForTemplateLoading(new File("."));
      cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
    } catch (java.io.IOException io) {
      // Handle IO Exception
    }
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);
  }

  private Template getFreeMarkerTemplate() throws java.io.IOException {
    return cfg.getTemplate("SampleKML.ftlh");
  }

  public Writer getResponseWriter(HttpServletResponse response, String filename)
    throws ServletException, IOException {

    // Set the content type
    response.setContentType("Content-type: text/xml");
    response.setHeader("Content-Disposition",
      "attachment; filename=" + filename);

    // Create writer for servelet stream
    ServletOutputStream servletOutputStream = response.getOutputStream();
    OutputStream os = new BufferedOutputStream(servletOutputStream);
    return new OutputStreamWriter(os);
  }

  public SampleService() {
    initializeFreemarkerConfig();
  }
}