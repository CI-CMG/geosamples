package cmg.geosamples.geosamples.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="CURATORS_SAMPLE_TSQP")
public class Cruise {
  @Id
  private Integer objectid;
  private String facility_code;
  private String platform;
  private String cruise;
  private String leg;
}
