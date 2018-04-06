package cmg.geosamples.geosamples.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This legacy service captures logic that was in place as part of the jsp view
 * files in the original Geosamples app. It should be considered for
 * replacement by data store/hibernaate backed logic.
 */
@Component
public class LegacyKmlService {
  // TODO: Capture this information at the data store level
  public Map<String, String> getGlobalParams(
    MultiValueMap<String, String> parameters) {
    int lon, lat;
    String facility = parameters.getOrDefault("facility_code",
      Arrays.asList("")).get(0);
    switch(facility) {
      case "":
        lon = 0;
        lat = 0;
        break;
      case "AOML":
        lon = -73;
        lat = 36;
        break;
      case "ARFFSU":
        lon = -9;
        lat = -61;
        break;
      case "AWI":
        lon = 5;
        lat = 9;
        break;
      case "BOSCORF":
        lon = -15;
        lat = 22;
        break;
      case "BPCRC":
        lon = -25;
        lat = 78;
        break;
      case "BPCRR":
        lon = -25;
        lat = -61;
        break;
      case "Canada":
        lon = -81;
        lat = 52;
        break;
      case "DSDP":
        lon = -6;
        lat = 14;
        break;
      case "GEOMAR":
        lon = 23;
        lat = 36;
        break;
      case "NMNH":
        lon = -104;
        lat = 42;
        break;
      case "IODP":
        lon = -57;
        lat = 17;
        break;
      case "LDEO":
        lon = -32;
        lat = 12;
        break;
      case "LacCore":
        lon = -73;
        lat = 39;
        break;
      case "ODP":
        lon = 1;
        lat = 9;
        break;
      case "OSU":
        lon = -96;
        lat = 30;
        break;
      case "PMEL":
        lon = -130;
        lat = 44;
        break;
      case "RSMAS":
        lon = -56;
        lat = 15;
        break;
      case "SIO":
        lon = -150;
        lat = 6;
        break;
      case "SOEST":
        lon = -170;
        lat = -1;
        break;
      case "U WISC":
        lon = -142;
        lat = 83;
        break;
      case "URI":
        lon = -47;
        lat = 21;
        break;
      case "USC":
        lon = -119;
        lat = 34;
        break;
      case "USGSMP":
        lon = -125;
        lat = 42;
        break;
      case "USGSSP":
        lon = -90;
        lat = 30;
        break;
      case "USGSWH":
        lon = -72;
        lat = 40;
        break;
      case "ECS":
        lon = -153;
        lat = 75;
        break;
      case "UT":
        lon = -92;
        lat = 25;
        break;
      case "WHOI":
        lon = -28;
        lat = 20;
        break;
      default:
        lon = 0;
        lat = 0;
        break;
    }
    return new HashMap<String, String>() {{
      put("global_facility", facility);
      put("global_lat", String.valueOf(lat));
      put("global_lon", String.valueOf(lon));
    }};
  }
}
