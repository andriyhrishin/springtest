package com.ibkr.test.service;
import org.springframework.stereotype.Service;

@Service
public class ServiceAImpl implements ServiceA {
    final ServiceB serviceB;
    public ServiceAImpl(ServiceB serviceB) {this.serviceB = serviceB;}

    /**
     * Reads a coefficient from external source and returns parameter multiplied by that coefficient
     * @param a
     * @return
     */
    @Override
    public int compute(int a) {
        return serviceB.readFromExternalSource() * a;
    }
}
