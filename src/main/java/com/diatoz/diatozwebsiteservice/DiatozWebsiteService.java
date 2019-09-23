package com.diatoz.diatozwebsiteservice;

import java.net.URISyntaxException;

import com.diatoz.models.bot_request_model.BotRequest;

public interface DiatozWebsiteService {
	Object getResult(BotRequest botRequest)throws URISyntaxException;
}
