package com.ibkr.test.service;

import java.util.Date;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default"})
public class ServiceBImpl implements ServiceB {
    @Override
    public int readFromExternalSource() {
        // obnoxious calculation that only works in production that we have no control over
        Date settleDate = new Date(new RandomDataGenerator().nextLong(0, new Date().getTime()*3));
        System.out.println("Settle date: " + settleDate);
        return new Date().before(settleDate) ? 1 : -1;
    }
}
