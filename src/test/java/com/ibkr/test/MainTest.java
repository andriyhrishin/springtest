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
public class MainTest {
    @Autowired
    private ServiceA myServiceA;

    @Test
    public void checkMyServiceAInjection() {
        Assert.notNull(myServiceA, "myServiceA is not injected");
    }

    @Test
    public void checkIfGetNumber1Is40() {
        int result = myServiceA.compute(4);
        Assert.isTrue(result == -4, "The Result1 is not -4");
    }
}
