package com.diatoz.diatozwebsiteservice;

import java.net.URISyntaxException;



import com.diatoz.botrequest.BotRequest;

public interface DiatozWebsiteService {
	Object getResult(BotRequest botRequest)throws URISyntaxException;
}
