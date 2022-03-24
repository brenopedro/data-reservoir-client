package com.reservoir.datareservoir.client.domain.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.supercsv.io.ICsvBeanWriter;

import com.reservoir.datareservoir.client.config.auth.AuthorizationToken;
import com.reservoir.datareservoir.client.domain.model.CubeData;
import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.model.UrlEnum;

public class CubeDataService {

    public static CubeData[] getCubeData(PropertiesFilter propertiesFilter) {
        String accessToken = AuthorizationToken.getAccessToken(false);
        CubeData[] cubeData;

        Map<String, String> params = new HashMap<>();
        params.put("fromTimeStamp", propertiesFilter.getFromTimeStamp());
        params.put("toTimeStamp", propertiesFilter.getToTimeStamp());

        String uri = UriComponentsBuilder.fromHttpUrl(UrlEnum.COLLECTION_CUBE.getUrl())
                .queryParam("fromTimeStamp", "{fromTimeStamp}")
                .queryParam("toTimeStamp", "{toTimeStamp}")
                .encode().toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            cubeData = new RestTemplate().exchange(uri, HttpMethod.GET,
                            request, CubeData[].class, params).getBody();
        } catch (HttpClientErrorException e) {
            accessToken = AuthorizationToken.getAccessToken(true);

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            cubeData = new RestTemplate().exchange(uri, HttpMethod.GET,
                    request, CubeData[].class, params).getBody();
        }


        return cubeData;
    }

	public static void downloadCsv(ICsvBeanWriter csvBeanWriter, CubeData[] cubeDataList) throws IOException {
		String[] header = {"ID", "External Temperature", "Battery Current", "Battery Voltage", "Battery Temperature",
				"Magnetic Field X", "Magnetic Field Y", "Magnetic Field Z",
				"Euler Angle X", "Euler Angle Y", "Euler Angle Z",
				"Linear Speed X", "Linear Speed Y", "Linear Speed Z",
				"Angular Speed X", "Angular Speed Y", "Angular Speed Z",
				"Transmitted Transciever Power", "Received Transceiver Power",
				"Time Stamp Cube", "Time Stamp Base"};

		String[] fieldMapping = {"id", "externalTemperature", "batteryCurrent", "batteryVoltage", "batteryTemperature",
						"magneticFieldX", "magneticFieldY", "magneticFieldY",
						"eulerAngleX", "eulerAngleY", "eulerAngleZ",
						"linearSpeedX", "linearSpeedY", "linearSpeedZ",
						"linearSpeedZ", "linearSpeedZ", "linearSpeedZ",
						"transmittedTransceiverPower", "transmittedTransceiverPower",
						"timeStampCube", "timeStampBase"};
		
		csvBeanWriter.writeHeader(header);
		
		for (CubeData cubeData : cubeDataList) {
			csvBeanWriter.write(cubeData, fieldMapping);
		}

	}
}
