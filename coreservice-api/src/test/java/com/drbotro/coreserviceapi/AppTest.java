package com.drbotro.coreserviceapi;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase{

    public AppTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(AppTest.class);
    }

    public void testApp(){
        assertTrue(true);
    }

    public void testJoda(){

        final String formatter = "yyyy-MM-dd HH:mm z";
        final DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatter);
        //final String timeZoneAthens = "Europe/Athens";
        //final String timeZoneBogota = "America/Bogota";
        final String timeZoneMadrid = "Europe/Madrid";
        final String timeZoneSaoPaulo = "America/Sao_Paulo";

        DateTime dtDefault = new DateTime(2019, 10, 21, 21, 00);

        final DateTime dtZoneDeparture = new LocalDateTime(dtDefault.getMillis())
                .toDateTime(DateTimeZone.forID(timeZoneSaoPaulo));
        final DateTime dtZoneReference = new LocalDateTime(dtDefault.getMillis())
                .toDateTime(DateTimeZone.forID(timeZoneMadrid));

        long offset = dtZoneDeparture.getMillis() - dtZoneReference.getMillis();

        //convert to local time
        DateTime dtZoneDefault = dtZoneDeparture.withZoneRetainFields(DateTimeZone.getDefault());
        dtZoneDefault = dtZoneDefault.plusMillis((int) offset);

        String dtfCEST = dtFormatter
                .print(new LocalDateTime(dtZoneDefault.getMillis()).toDateTime(DateTimeZone.forID(timeZoneMadrid)));

        System.out.println(dtZoneDeparture);
        System.out.println(DateTimeZone.getDefault());
        System.out.println(offset);
        System.out.println(dtfCEST);

        assertTrue(true);

    }
}
