package com.diatoz.resource;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diatoz.botrequest.BotRequest;
import com.diatoz.diatozwebsiteservice.DiatozWebsiteService;
import com.diatoz.diatozwebsiteservice.DiatozWebsiteServiceImpl;

@RestController
@RequestMapping("/api")
public class DiatozResource {
	
	private static final Logger logger = LoggerFactory.getLogger(DiatozWebsiteServiceImpl.class);
	
	@Autowired
	DiatozWebsiteService diatozWebsiteService;
	
	@Value("${chatbot_url}")
	String chatbotUrl;
	
	Object result;
	
	@PostMapping("/bot")
	ResponseEntity<?> getData(@RequestBody BotRequest botRequest) throws URISyntaxException,Exception{
		
		logger.debug("Post-request mapped in getData()");
		
		try {
		result=diatozWebsiteService.getResult(botRequest);	
		}
		
		
		//Modifying the Exception message because if it contains chatbot url
		catch(Exception e) {
			if(e.getMessage().contains(chatbotUrl)) {
				
				logger.info("Modifying the Exception message because it contains chatbot url");
				throw new Exception("Some Error Occurred!");
			}
			else {
				logger.info("Exception Rethrown");
				throw e;
			}
		}
		
		logger.debug("Post-request from getData has been completed");
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
}
