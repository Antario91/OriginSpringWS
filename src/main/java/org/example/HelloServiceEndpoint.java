package org.example;

import org.example.helloservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.EndpointExceptionResolver;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.server.endpoint.mapping.AbstractEndpointMapping;
import org.springframework.ws.server.endpoint.mapping.PayloadRootAnnotationMethodEndpointMapping;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SimpleSoapExceptionResolver;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olgo on 09-Nov-16.
 */

@Endpoint
public class HelloServiceEndpoint {
    private static final String namespaceUri = "http://www.example.org/HelloService";

    @Autowired
    private HelloService helloService;

    @PayloadRoot(localPart = "ServiceRequest", namespace = namespaceUri)
    @ResponsePayload
    public ServiceResponse getService(@RequestPayload ServiceRequest request) throws Exception {
        ServiceResponse response = new ServiceResponse();
        response.setHello(helloService.getHello(request.getName()));
        response.setCurrentTime(helloService.getCurrentTime());
        return response;
    }

    @PayloadRoot(localPart = "GreetingServiceRequest", namespace = namespaceUri)
    @ResponsePayload
    public GreetingServiceResponse getServiceOfGreeting(@RequestPayload GreetingServiceRequest request) {
        GreetingServiceResponse response = new GreetingServiceResponse();

        GreetingType greetingTypeInstance1 = new GreetingType();
        greetingTypeInstance1.setNumber(request.getNumber());
        greetingTypeInstance1.setGreeting(request.getGreeting());

        GreetingType greetingTypeInstance2 = new GreetingType();
        greetingTypeInstance2.setNumber(request.getNumber());
        greetingTypeInstance2.setGreeting(request.getGreeting());

        GreetingType greetingTypeInstance3 = new GreetingType();
        greetingTypeInstance3.setNumber(request.getNumber());
        greetingTypeInstance3.setGreeting(request.getGreeting());


        response.getGreeting().add(greetingTypeInstance1);
        response.getGreeting().add(greetingTypeInstance2);
        response.getGreeting().add(greetingTypeInstance3);
//        if (true)
//            throw new ArithmeticException("Hello, My Little World! (^^,)");
        return response;
    }
}