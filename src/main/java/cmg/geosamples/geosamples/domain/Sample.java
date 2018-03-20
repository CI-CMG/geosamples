package cmg.geosamples.geosamples.domain;

import com.vividsolutions.jts.io.WKTWriter;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import com.vividsolutions.jts.geom.Geometry;

@Entity
@Data
@Table(name="CURATORS_SAMPLE_TSQP")
public class Sample {
  @Id
  private Integer objectid;
  private String facility_code;
  private String ship_code;
  private String platform;
  private String cruise;
  private String sample;
  private String device;
  private String begin_date;
  private String end_date;
  private BigDecimal lat;
  private BigDecimal latdeg;
  private String latmin;
  private String ns;
  private BigDecimal end_lat;
  private BigDecimal end_latdeg;
  private String end_latmin;
  private String end_ns;
  private BigDecimal lon;
  private BigDecimal londeg;
  private String lonmin;
  private String ew;
  private BigDecimal end_lon;
  private BigDecimal end_londeg;
  private String end_lonmin;
  private String end_ew;
  private String latlon_orig;
  private String water_depth;
  private BigDecimal end_water_depth;
  private String storage_meth;
  private BigDecimal cored_length;
  private BigDecimal cored_length_mm;
  private BigDecimal cored_diam;
  private BigDecimal cored_diam_mm;
  private String pi;
  private String province;
  private String lake;
  private String other_link;
  private String last_update;
  private String igsn;
  private String leg;
  private String sample_comments;
  private String publish;
  private String previous_state;
  private Geometry shape;
  private String show_sampl;
  private String imlgs;

  public String getShape() {
    return new WKTWriter().write(this.shape);
  }
}
