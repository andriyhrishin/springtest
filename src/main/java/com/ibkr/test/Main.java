package com.ibkr.test;

import com.ibkr.test.config.ComponentScanConfig;
import com.ibkr.test.service.ServiceA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ComponentScanConfig.class)) {

            System.out.println("Spring context created ...");

            //GET an instance from context BY CLASS
            // SINGLETON by default in Spring
            ServiceA myServiceA = context.getBean(ServiceA.class);

            int result = myServiceA.compute(4);

            System.out.println("result=" + result);
        }
    }
}
