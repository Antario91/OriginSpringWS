package org.example;

/**
 * Created by olgo on 09-Nov-16.
 */
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;

public interface HelloService {
    public String getHello(String name) throws Exception;
    public XMLGregorianCalendar getCurrentTime() throws DatatypeConfigurationException;
}
