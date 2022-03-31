package com.jcj.interview.config;

import com.jcj.interview.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan("com.jcj.interview.bean")
public class SpringLifeCycleConfig {

    //@Scope("prototype")
    //@Bean(initMethod = "init", destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

}
