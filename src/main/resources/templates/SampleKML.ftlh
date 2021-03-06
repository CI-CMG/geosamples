<?xml version="1.0" encoding="UTF-8"?>
<kml xmlns="http://earth.google.com/kml/2.1">
  <Document>
    <name>Index to Marine and Lacustrine Geological Samples</name>
    <open>1</open>
    <LookAt>
      <longitude>${(lon)!}</longitude>
      <latitude>${(lat)!}</latitude>
      <altitude>6000000</altitude>
      <altitudeMode>absolute</altitudeMode>
    </LookAt>
    <Snippet></Snippet>
    <Style id="normalPlacemark">
      <LabelStyle><scale>0</scale></LabelStyle>
      <IconStyle><scale>1</scale><Icon><href>https://www.ngdc.noaa.gov/mgg/image/off.png</href></Icon></IconStyle>
       <BalloonStyle><text><![CDATA[<table align="center" width="400" border="0"><tr><td align="center"><img src="https://www.ngdc.noaa.gov/mgg/image/noaa22x22.gif" alt="NOAA icon" width="22" height="22"><strong><a href="https://dx.doi.org/doi:10.7289/V5H41PB8" style="text-decoration: none;">Index to Marine and Lacustrine Geological Samples (IMLGS)</a></strong><img src="https://www.ngdc.noaa.gov/mgg/image/nsf22x22.gif" alt="NSF icon" width="22" height="22"><br /><br /><div align="left"> $[description]</div></td></tr></table><br /><br />]]></text></BalloonStyle>
    </Style>
    <Style id="highlightPlacemark">
      <LabelStyle><scale>1</scale></LabelStyle>
      <IconStyle><scale>1</scale><Icon><href>https://www.ngdc.noaa.gov/mgg/image/on.png</href></Icon></IconStyle>
        <BalloonStyle><text><![CDATA[<table align="center" width="400" border="0"><tr><td align="center"><img src="https://www.ngdc.noaa.gov/mgg/image/noaa22x22.gif" alt="NOAA icon" width="22" height="22"><strong><a href="https://dx.doi.org/doi:10.7289/V5H41PB8" style="text-decoration: none;">Index to Marine and Lacustrine Geological Samples (IMLGS)</a></strong><img src="https://www.ngdc.noaa.gov/mgg/image/nsf22x22.gif" alt="NSF icon" width="22" height="22"><br /><br />$[name]<br /><br />$[description]</td></tr></table><br /><br />]]></text></BalloonStyle>
    </Style>
    <StyleMap id="csm">
      <Pair><key>normal</key><styleUrl>#normalPlacemark</styleUrl></Pair>
      <Pair><key>highlight</key><styleUrl>#highlightPlacemark</styleUrl></Pair>
    </StyleMap>
    <styleUrl>#csm</styleUrl>
    <name>Index to Marine and Lacustrine Geological Samples (IMLGS)</name>
    <Snippet></Snippet>
    <description><![CDATA[About:<br /><br />The Index to Marine and Lacustrine Geological Samples (IMLGS) is a tool to help scientists locate and obtain geologic material from sea floor and lakebed cores, grabs, and dredges archived by <a href="https://www.ngdc.noaa.gov/mgg/curator/participants.HTML" style="text-decoration: none;">participating institutions</a>. Before proposing research on any sample, please contact the curator for sample condition and availability.<br /><br />The IMLGS includes basic collection and storage information and links to related data and images available for many samples at the originating institutions, NCEI, and related websites.Alternate interfaces and web services are also available: <a href="https://dx.doi.org/doi:10.7289/V5H41PB8" style="text-decoration: none;">https://dx.doi.org/doi:10.7289/V5H41PB8</a>.<br /><br />Cite the database as:<br /><br /><strong><cite>Curators of Marine and Lacustrine Geological Samples Consortium: Index to Marine and Lacustrine Geological Samples (IMLGS). National Geophysical Data Center, NOAA. <a href="https://dx.doi.org/doi:10.7289/V5H41PB8" title="go to Digital Object Identifier (DOI) for the IMLGS" style="text-decoration: none;">doi:10.7289/V5H41PB8</a></cite>.</strong><br /><br />Data Sources and Credits:<br /><br />Data are contributed by partner repositories, please cite the repository if you use data from this database. Several U.S. insitutions receive funding from the National Science Foundation (<a href="http://www.nsf.gov/" style="text-decoration: none;">NSF</a>) to prepare data for the IMLGS. <br /><br />The National Centers for Environmental Information (<a href="https://www.ngdc.noaa.gov/" style="text-decoration: none;">NCEI</a>)/World Data Service for Geophysics maintains the IMLGS on behalf of the participating institutions, as the NSF-designated archive<br />(<a href="http://www.nsf.gov/publications/pub_summ.jsp?ods_key=nsf11060&amp;org=NSF" style="text-decoration: none;">NSF Division of Ocean Sciences Data and Sample Policy</a>). NCEI is part of the National Oceanic and Atmospheric Administration (<a href="http://noaa.gov" style="text-decoration: none;">NOAA</a>),<br />US Department of Commerce.]]></description>
    <visibility>1</visibility>
    <open>0</open>
    <#assign lastFacilityCode = "">
    <#list samples as sample>
      <#assign facilityCode = sample.facility_code>
      <#if facilityCode != lastFacilityCode>
        <#if lastFacilityCode != "">
        </Folder>
        </#if>
        <#assign facilityName = getFacilityName(facilityCode)>
        <Folder>
        <styleUrl>#csm</styleUrl>
        <name>${facilityName}</name>
        <Snippet></Snippet>
        <description><![CDATA[<table align="center" border="0"><tr align="left"><td><p><a href="http://www.whoi.edu/science/GG/corelab/index.html">${facilityName}</a><br>(http://www.whoi.edu/science/GG/corelab/index.html)<br>Jim Broda<br>Ellen Roosen<br>${facilityName}<br>Department of Geology and Geophysics<br>Woods Hole, MA 02543<br>(508)289-2466 (Jim Broda)<br>(508)289-2959 (Ellen Roosen)<br>(508)457-2183 (fax)<br><a href="mailto:jbroda@whoi.edu">jbroda@whoi.edu</a><br><a href="mailto:eroosen@whoi.edu">eroosen@whoi.edu</a><br></p><br><br>
          <cite>Cite as: Woods Hole Oceanographic Institution (WHOI) Seafloor Samples Laboratory: Archive of WHOI geosample data and information. NOAA National Centers for Environmental Information. <a href="https://dx.doi.org/10.7289/V5WH2N0Z">doi:10.7289/V5WH2N0Z</a> [date of access]</cite></td></tr></table>]]></description>
        <visibility>1</visibility>
        <open>0</open>
      </#if>
      <Placemark>
        <name></name>
        <styleUrl>#csm</styleUrl>
        <visibility>1</visibility>
        <open>0</open>
        <name>${(sample.platform)!}, ${(sample.cruise)!} (${(sample.device)!})</name>
        <Snippet>${(sample.lat)!}, ${(sample.lon)!}</Snippet>
        <description><![CDATA[<div align="center"> <br /><br /></div><div align="center">[<a href="https://www.ngdc.noaa.gov/geosamples/facility/${(sample.facility_code)!}/">Contact the Curator</a>]   [<a href="*******https://www.ngdc.noaa.gov/geosamples/samples?imlgs=imlgs0184141">View/Download Data, Images, and Links</a>]<br /><br /><table border="1" cellspacing="0" width="360"><tr><td>Repository: </td><td><a href="${(sample.other_link)!}">******Woods Hole Oceanographic Institution</a></td></tr><tr><td width="25%">Sample id: </td><td width="75%"><a href="https://www.ngdc.noaa.gov/geosamples/samples/${(sample.objectid)!}">${(sample.sample)!}</a></td></tr><tr><td width="25%">Device type: </td><td width="75%">${(sample.device)!}</td></tr><tr><td width="25%">Core len/diam: </td><td width="75%">${(sample.cored_length)!} ${(sample.cored_diam)!}</td></tr><tr><td>Latitude: </td><td>${(sample.lat)!}</td></tr><tr><td>Longitude: </td><td>${(sample.lon)!}</td></tr><tr><td>Ship: </td><td>${(sample.platform)!}</td></tr><tr><td>Cruise/Leg: </td><td><a href="https://www.ngdc.noaa.gov/geosamples/cruises?cruise=${(sample.cruise)!}">${(sample.cruise)!}</a>  </td></tr><tr><td>YearMoDay: </td><td>${(sample.begin_date)!}</td></tr><tr><td>Water depth: </td><td>${(sample.water_depth)!} meters</td></tr><tr><td>Lake: </td><td>${(sample.lake)!}</td></tr><tr><td>Province: </td><td>${(sample.province)!}</td></tr><tr><td>IGSN: </td><td><a href="*********http://app.geosamples.org/sample_display.php?igsn=WHO0001F4">${(sample.igsn)!}</a></td></tr></table><br /> <a href="{sample.other_link">Access/Cite the Index to Marine and Lacustrine Geological Samples</a><br><br><a href="http://dx.doi.org/doi:10.7289/V5WH2N0Z">Access/Cite IMLGS data from this Partner Repository</a></div>]]></description>
        <LookAt>
          <longitude>${(sample.lat)!}</longitude>
          <latitude>${(sample.lon)!}</latitude>
          <range>200000.</range>
        </LookAt>
        <Point>
          <coordinates>${(sample.lon)!}, ${(sample.lat)!}</coordinates>
        </Point>
      </Placemark>
      <#assign lastFacilityCode = facilityCode>
    </#list>
    </Folder>
  </Document>
</kml>
