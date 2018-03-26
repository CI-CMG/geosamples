package cmg.geosamples.geosamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.querydsl.binding.QuerydslBindingsFactory;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;

@Configuration
public class QueryDslConfiguration {
  @Bean
  public QuerydslBindingsFactory querydslBindingsFactory() {
    return new QuerydslBindingsFactory(SimpleEntityPathResolver.INSTANCE);
  }

  @Bean
  public QuerydslPredicateBuilder querydslPredicateBuilder() {
    return new QuerydslPredicateBuilder(new DefaultConversionService(), querydslBindingsFactory().getEntityPathResolver());
  }
}
