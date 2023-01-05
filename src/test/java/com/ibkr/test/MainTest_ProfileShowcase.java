package com.ibkr.test;
import com.ibkr.test.service.*;
import com.ibkr.test.config.ComponentScanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ComponentScanConfig.class)
@ActiveProfiles(profiles = "localtest")
public class MainTest_ProfileShowcase {
    /**
     * since this test is ran with "localtest" profile component scan will find test implementation of
     * ServiceB in src/test/java/com/ibkr.test/service
     * and will autowire test implementation into ServiceAImpl
     */
    @Autowired
    private ServiceA myServiceA;

    @Test
    public void checkMyServiceAInjection() {
        Assert.notNull(myServiceA, "myServiceA is not injected");
    }

    @Test
    public void testCompute() {
        int result = myServiceA.compute(4);
        Assert.isTrue(result == -4, "result is not -4");
    }
}
