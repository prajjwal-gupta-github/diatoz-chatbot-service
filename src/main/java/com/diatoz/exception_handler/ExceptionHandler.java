package com.diatoz.exception_handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	
	@Value("${chatbot_url}")
	String chatbotUrl;
	
//	@ExceptionHandler({Exception.class})
//			public void handleException(Exception ex) throws Exception{
//		
//	}
	
}

