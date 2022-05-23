package com.usafarmers.farmers.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.usafarmers.farmers.calculateApi.CalculateRequest;
import com.usafarmers.farmers.calculateApi.CalculationResponse;
import com.usafarmers.farmers.calculateApi.CropResponse;

@Service
public class CalculatorService {

	private String apikey = "WBWLPiTmQELMAm63NXdi92gWFyQfjZu6bwmQMLZe";

	//fetch crops
	public CropResponse getCropResponse() {

		URI url = null;
		try {
			url = new URI("https://api.plantnutrition.io/nurd/toc");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-api-key", apikey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		RestTemplate rt = new RestTemplate();
		ResponseEntity<CropResponse> response = rt.exchange(url, HttpMethod.GET, requestEntity, CropResponse.class);

		return response.getBody();
	}
	//post crop and yield-goal and get response
	public CalculationResponse calculate(String cropKey, int yieldGoal) {

		URI url = null;
		try {
			url = new URI("https://api.plantnutrition.io/nurd/calculator");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-api-key", apikey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		CalculateRequest calReq = new CalculateRequest();
		calReq.cropKey = cropKey;
		calReq.yieldGoal = yieldGoal;
		calReq.isImperialMath = false;

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = ow.writeValueAsString(calReq);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<CalculationResponse> response = rt.exchange(url, HttpMethod.POST, requestEntity,
				CalculationResponse.class);

		return response.getBody();
	}

}
