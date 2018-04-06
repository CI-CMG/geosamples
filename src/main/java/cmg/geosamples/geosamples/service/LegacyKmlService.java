package cmg.geosamples.geosamples.service;

import freemarker.template.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This legacy service captures logic that was in place as part of the jsp view
 * files in the original Geosamples app. It should be considered for
 * port to the data store.
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
  public FacilityMethod getFacilityName() {
    return new FacilityMethod();
  }

  private class FacilityMethod implements TemplateMethodModel {
    public TemplateModel exec(List args) throws TemplateModelException {
      if (args.size() != 1) {
        throw new TemplateModelException("Wrong arguments");
      }
      String facilityCode = args.get(0).toString(), facilityName = "";
      switch (facilityCode) {
        case "AOML":
          facilityName = "NOAA Atlantic Oceanographic and Meteorological Labs (repository closed)";
          break;
        case "ARFFSU":
          facilityName = "Antarctic Marine Geology Research Facility, Florida State University";
          break;
        case "AWI":
          facilityName ="Alfred-Wegener-Institut";
          break;
        case "BOSCORF":
          facilityName = "British Ocean Sediment Core Research Facility";
          break;
        case "BPCRC":
          facilityName = "Byrd Polar and Climate Research Center, Sediment Core Repository";
          break;
        case "BPCRR":
          facilityName = "Byrd Polar and Climate Research Center, Polar Rock Repository";
          break;
        case "Canada":
          facilityName = "Geological Survey of Canada Atlantic Marine Geoscience Curation Facility";
          break;
        case "DSDP":
          facilityName = "Deep Sea Drilling Project Samples at IODP";
          break;
        case "EDYTEM":
          facilityName = "Universite de Savoie, EDYTEM";
          break;
        case "GEOMAR":
          facilityName = "GEOMAR Helmholtz Centre for Ocean Research Kiel";
          break;
        case "NMNH":
          facilityName = "Integrated Ocean Drilling Program Samples at IODP";
          break;
        case "LDEO":
          facilityName = "Lamont-Doherty Core Repository, Columbia University";
          break;
        case "LacCore":
          facilityName = "National Lacustrine Core Repository, U. Minnesota";
          break;
        case "ODP":
          facilityName = "Ocean Drilling Program Samples at IODP";
          break;
        case "OSU":
          facilityName = "Oregon State University Marine Geology Repository";
          break;
        case "PMEL":
          facilityName = "NOAA Pacific Marine Environmental Laboratory";
          break;
        case "RSMAS":
          facilityName = "Rosenstiel School of Marine and Atmospheric Science";
          break;
        case "SIO":
          facilityName = "Scripps Institution of Oceanography Geological Collections";
          break;
        case "SOEST":
          facilityName = "University of Hawaii at Manoa, SOEST";
          break;
        case "U WISC":
          facilityName = "University of Wisconsin-Madison Geology Museum";
          break;
        case "URI":
          facilityName = "University of Rhode Island Graduate School of Oceanography";
          break;
        case "USC":
          facilityName = "University of Southern California";
          break;
        case "USGSMP":
          facilityName = "USGS Pacific Coastal and Marine Science Center";
          break;
        case "USGSSP":
          facilityName = "USGS St. Petersburg Coastal and Marine Science Center";
          break;
        case "USGSWH":
          facilityName = "USGS Woods Hole Coastal and Marine Science Center";
          break;
        case "ECS":
          facilityName = "US Extended Continental Shelf Project Samples Repository";
          break;
        case "UT":
          facilityName = "University of Texas at Austin Institute for Geophysics";
          break;
        case "WHOI":
          facilityName = "Woods Hole Oceanographic Institution";
          break;
        default:
          facilityName ="";
          break;
      }
      return new SimpleScalar(facilityName);
    }
  }
}
