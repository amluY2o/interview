package com.jcj.interview.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {

    @Autowired
    private BService bService;

    public AService() {
        System.out.println("AService created...");
    }

    //    public AService(BService bService) {
//        this.bService = bService;
//    }
}
