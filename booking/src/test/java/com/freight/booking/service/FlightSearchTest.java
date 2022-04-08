package com.freight.booking.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.freight.booking.model.AirlineDetail;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.util.AirlineAndCompanyData;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FlightSearch.class})
@ExtendWith(SpringExtension.class)
class FlightSearchTest {
    @MockBean
    private AirlineAndCompanyData airlineAndCompanyData;

    @Autowired
    private FlightSearch flightSearch;

    @Test
    void testGetCheapestFlightByPricePerKg() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(new ArrayList<>());
        assertNull(this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCheapestFlightByPricePerKg2() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getCheapestFlightByPricePerKg(FlightSearch.java:26)
        //   In order to prevent getCheapestFlightByPricePerKg(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCheapestFlightByPricePerKg(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(new AirlineDetail());
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d));
    }

    @Test
    void testGetCheapestFlightByPricePerKg3() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenThrow(new ParseException("foo", 1));
        assertThrows(ParseException.class, () -> this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    void testGetCheapestFlightByPricePerKg4() throws ParseException {
        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        airlineDetailList.add(new AirlineDetail("Airline Code", "42", "Origin Airport", "Destination Airport",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 10.0d, 1L, 1L));
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        assertNull(this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCheapestFlightByPricePerKg5() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getCheapestFlightByPricePerKg(FlightSearch.java:26)
        //   In order to prevent getCheapestFlightByPricePerKg(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCheapestFlightByPricePerKg(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(null);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCheapestFlightByPricePerKg6() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getCheapestFlightByPricePerKg(FlightSearch.java:26)
        //   In order to prevent getCheapestFlightByPricePerKg(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCheapestFlightByPricePerKg(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(new AirlineDetail());
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch.getCheapestFlightByPricePerKg(null);
    }

    @Test
    void testGetCheapestFlightByPricePerKg7() throws ParseException {
        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        AirlineDetail airlineDetail = new AirlineDetail("Airline Code", "42", "Origin Airport", "Destination Airport",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 10.0d, 1L, Long.MAX_VALUE);

        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        assertSame(airlineDetail, this.flightSearch
                .getCheapestFlightByPricePerKg(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    void testGetFastestFlightByDurationInMinutes() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(new ArrayList<>());
        assertNull(this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetFastestFlightByDurationInMinutes2() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getFastestFlightByDurationInMinutes(FlightSearch.java:32)
        //   In order to prevent getFastestFlightByDurationInMinutes(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getFastestFlightByDurationInMinutes(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(new AirlineDetail());
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d));
    }

    @Test
    void testGetFastestFlightByDurationInMinutes3() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenThrow(new ParseException("foo", 1));
        assertThrows(ParseException.class, () -> this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    void testGetFastestFlightByDurationInMinutes4() throws ParseException {
        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        airlineDetailList.add(new AirlineDetail("Airline Code", "42", "Origin Airport", "Destination Airport",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 10.0d, 1L, 1L));
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        assertNull(this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetFastestFlightByDurationInMinutes5() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getFastestFlightByDurationInMinutes(FlightSearch.java:32)
        //   In order to prevent getFastestFlightByDurationInMinutes(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getFastestFlightByDurationInMinutes(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(null);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetFastestFlightByDurationInMinutes6() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.FlightSearch.lambda$getAirlineDetail$0(FlightSearch.java:43)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:479)
        //       at java.util.stream.ReferencePipeline.min(ReferencePipeline.java:520)
        //       at com.freight.booking.service.FlightSearch.getAirlineDetail(FlightSearch.java:46)
        //       at com.freight.booking.service.FlightSearch.getFastestFlightByDurationInMinutes(FlightSearch.java:32)
        //   In order to prevent getFastestFlightByDurationInMinutes(FlightBookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getFastestFlightByDurationInMinutes(FlightBookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(new AirlineDetail());
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        this.flightSearch.getFastestFlightByDurationInMinutes(null);
    }

    @Test
    void testGetFastestFlightByDurationInMinutes7() throws ParseException {
        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        AirlineDetail airlineDetail = new AirlineDetail("Airline Code", "42", "Origin Airport", "Destination Airport",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 10.0d, 1L, Long.MAX_VALUE);

        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);
        assertSame(airlineDetail, this.flightSearch
                .getFastestFlightByDurationInMinutes(new FlightBookingRequest("Origin airport", "Destination airport", 10.0d)));
        verify(this.airlineAndCompanyData).getAirlineList();
    }
}

