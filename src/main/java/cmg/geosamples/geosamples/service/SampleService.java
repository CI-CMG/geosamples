package cmg.geosamples.geosamples.service;

  import cmg.geosamples.geosamples.config.PredicateService;
  import cmg.geosamples.geosamples.domain.Sample;
  import cmg.geosamples.geosamples.repo.SampleRepository;
  import freemarker.template.Configuration;
  import freemarker.template.Template;
  import freemarker.template.TemplateExceptionHandler;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.data.domain.Page;
  import org.springframework.data.domain.Pageable;
  import org.springframework.stereotype.Component;
  import com.querydsl.core.types.Predicate;
  import org.springframework.util.MultiValueMap;

  import javax.servlet.ServletException;
  import javax.servlet.ServletOutputStream;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletResponse;
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;

@Component
public class SampleService {
  Configuration cfg;
  @Autowired
  SampleRepository sampleRepository;
  @Autowired
  PredicateService predicateService;

  public List<Sample> findSamples(MultiValueMap<String, String> parameters) {
    Predicate predicate = predicateService.getPredicateFromParameters(
      parameters, Sample.class);

    List<Sample> target = new ArrayList<>();
    Iterable<Sample> iterable = sampleRepository.findAll(predicate);
    iterable.forEach(target::add);

    return target;
  }

  public void generateKml(List<Sample> sampleList, HttpServletResponse response) {
    String filename = "GeoSamples.kml";
    try {
      Template kmlTempl = getFreeMarkerTemplate();
      kmlTempl.process(sampleList.get(1),
        new ServletWriter().getWriter(response, filename));
    } catch (java.io.IOException io) {

    } catch (javax.servlet.ServletException se) {

    } catch (freemarker.template.TemplateException te) {

    }
  }

  private void initializeFreemarkerConfig() {
    // TODO: Consider options for storing config in application.yml
    cfg = new Configuration(Configuration.VERSION_2_3_27);
    try {
      cfg.setDirectoryForTemplateLoading(new File("."));
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

  private class ServletWriter extends HttpServlet {
    public Writer getWriter(HttpServletResponse response, String filename)
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
  }

  public SampleService() {
    initializeFreemarkerConfig();
  }
}