package com.tpuhalo.service;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService{

    @Override
    public List<String> getWelcomeMessage(String name){
        List<String> myWelcomeMessage = new ArrayList<String>();

        myWelcomeMessage.add("hello");
        myWelcomeMessage.add(name);
        myWelcomeMessage.add("Tnx");
        return myWelcomeMessage;
    }
}
