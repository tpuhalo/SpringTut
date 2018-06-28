package com.tpuhalo.spring.welcome;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService{

	public List<String> getWelcomeMessage(String name) {
		
		List<String> message = new ArrayList<String>();
		
		message.add("Hello I'm ");
		message.add(name);
		message.add("!!!!");
		
		return message;
	}

}
