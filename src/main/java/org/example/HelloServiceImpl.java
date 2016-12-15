package org.example;

/**
 * Created by olgo on 09-Nov-16.
 */
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class HelloServiceImpl implements HelloService{
    public String getHello(String name) throws Exception {
        return "Hello, " + name + "!";
    }
    public XMLGregorianCalendar getCurrentTime() throws DatatypeConfigurationException {
        Calendar createDate = Calendar.getInstance();
        Date date = createDate.getTime();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return calendar;
    }
}
