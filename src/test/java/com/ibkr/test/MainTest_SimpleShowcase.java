package com.ibkr.test;

import com.ibkr.test.service.ServiceA;
import com.ibkr.test.service.ServiceAImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.util.Assert;

public class MainTest_SimpleShowcase extends TestCase {

    @Test
    public void testCompute() {
        // create MyServiceAImpl manually, passing a test implementation of ServiceB to constructor
        ServiceA myServiceA = new ServiceAImpl(()->{
            System.out.println(getClass() + ": Faking reading from external source, will return -1");
            return -1;
        });
        int result = myServiceA.compute(4);
        Assert.isTrue(result == -4, "result is not -4");
    }
}
