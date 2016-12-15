package org.example.Exceptions;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

/**
 * Created by olgo on 22-Nov-16.
 */
public class EndpointExceptionResolver extends SoapFaultMappingExceptionResolver {
    private static final QName CODE = new QName("code");
    private static final QName SUB_CODE = new QName("sub-code");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        SoapFaultDetail detail = fault.addFaultDetail();
        detail.addFaultDetailElement(CODE).addText("123456");
        detail.addFaultDetailElement(SUB_CODE).addText("It's work!");
    }
}


