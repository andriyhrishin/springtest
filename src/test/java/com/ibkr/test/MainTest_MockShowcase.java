package com.ibkr.test;

import com.ibkr.test.config.ComponentScanConfig;
import com.ibkr.test.service.ServiceA;
import com.ibkr.test.service.ServiceB;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainTest_MockShowcase.TestConfig.class, ComponentScanConfig.class})
public class MainTest_MockShowcase {

    @Autowired
    private ServiceA myServiceA;

    /**
     * Need to autowire ServiceB here to be able to define what ServiceB mock should do when invoked
     */
    @Autowired
    private ServiceB mockServiceB;

    @Before
    public void init() {
        // make ServiceB mock always return -1
        //doReturn(-1).when(mockServiceB).readFromExternalSource();
        when(mockServiceB.readFromExternalSource())
                .thenAnswer(invocationOnMock -> {
                    System.out.println(getClass() + ": Faking reading from external source, will return -1");
                    return -1;
                });
    }

    @Test
    public void testCompute() {
        int result = myServiceA.compute(4);
        Assert.isTrue(result == -4, "result is not -4");
    }

    /**
     * Spring configuration for this test: it overrides ServiceB from main spring config
     */
    @Profile("test")
    @Configuration
    static class TestConfig {
        @Bean
        @Primary
        public ServiceB mockServiceB() {
            return Mockito.mock(ServiceB.class);
        }
    }
}
