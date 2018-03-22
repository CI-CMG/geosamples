package cmg.geosamples.geosamples.config;

import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration extends RepositoryRestConfigurerAdapter {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    System.out.println("**********************I happened*********************");
  }
  @Override
  public void configureConversionService(ConfigurableConversionService conversionService) {

  }
}

