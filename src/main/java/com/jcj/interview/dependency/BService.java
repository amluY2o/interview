package com.jcj.interview.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BService {

    @Autowired
    private AService aService;

    public BService(){
        System.out.println("BService created...");
    }

//    public BService(AService aService) {
//        this.aService = aService;
//    }
}
