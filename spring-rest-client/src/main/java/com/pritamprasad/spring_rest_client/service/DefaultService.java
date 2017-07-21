/**
 * 
 */
package com.pritamprasad.spring_rest_client.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.pritamprasad.common_interfaces.RequestBody;
import com.pritamprasad.spring_rest_client.model.DefaultModel;



/**
 * @author Pritam
 *
 */
@Service
public class DefaultService {

    private Logger logger = Logger.getLogger(DefaultService.class);

    @Autowired
    private DefaultModel defaultModel;
    
    @Autowired
    private RestTemplate restTemplate;

    public String sendDefaultRequest() {
	
	String url = "http://localhost:9000/index";
	
	RequestBody requestBody = new RequestBody();
	requestBody.setId(100);
	
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<RequestBody> requestEntity = new HttpEntity<RequestBody>(requestBody,headers);
	final ParameterizedTypeReference<RequestBody> responseType = new ParameterizedTypeReference<RequestBody>() {
	};
	
	ResponseEntity<RequestBody> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
	
	System.out.println(responseEntity.getStatusCode());	
	
	return null;
    }

    public DefaultModel getDefaultModel() {
	return defaultModel;
    }

    public void setDefaultModel(DefaultModel defaultModel) {
	this.defaultModel = defaultModel;
    }

}
