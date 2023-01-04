package com.ibkr.test.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"localtest"})
public class ServiceBTestImpl implements ServiceB {
    @Override
    public int readFromExternalSource() {
        // always return -1 when testing
        System.out.println("Faking reading from external source, will return -1");
        return -1;
    }
}
