package com.jcj.interview.test;


import com.jcj.interview.config.SpringLifeCycleConfig;
import com.jcj.interview.dependency.AService;
import com.jcj.interview.dependency.BService;
import com.jcj.interview.dependency.DependencyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCLifeCycleTest {

    @Test
    public void test01(){
        // 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringLifeCycleConfig.class);
        System.out.println("容器创建完成");

        //Car car  = applicationContext.getBean(Car.class);

        // 关闭容器
        applicationContext.close();

    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);

        AService aService = applicationContext.getBean(AService.class);
        BService bService = applicationContext.getBean(BService.class);

        System.out.println(aService);
        System.out.println(bService);

        applicationContext.close();
    }



      
}
