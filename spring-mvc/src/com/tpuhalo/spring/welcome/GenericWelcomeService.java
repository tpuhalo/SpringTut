package com.tpuhalo.spring.welcome;

import java.util.List;

public interface GenericWelcomeService {
	public List<String> getWelcomeMessage(String name);
}