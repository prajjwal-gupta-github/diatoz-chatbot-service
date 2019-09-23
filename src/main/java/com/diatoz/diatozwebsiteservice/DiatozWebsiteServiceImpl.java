package com.diatoz.diatozwebsiteservice;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diatoz.models.bot_request_model.BotRequest;

@Service
public class DiatozWebsiteServiceImpl implements DiatozWebsiteService{
	
	private static final Logger logger = LoggerFactory.getLogger(DiatozWebsiteServiceImpl.class);
	
	
	@Value("${chatbot_url}")
	private String location;
	

	RestTemplate restTemplate=new RestTemplate();

	@Override
	public Object getResult(BotRequest botRequest) throws URISyntaxException {
		
		logger.info("processing request");
		HttpEntity<BotRequest> requestEntity = new HttpEntity<>(botRequest);
		
		
		URI url=new URI(location);
		
		Object result =restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class).getBody();
				
		return result;
	}
}
