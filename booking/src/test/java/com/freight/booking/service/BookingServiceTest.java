package com.freight.booking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.freight.booking.model.AirlineDetail;
import com.freight.booking.model.BookingRequest;
import com.freight.booking.util.AirlineAndCompanyData;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingService.class})
@ExtendWith(SpringExtension.class)
class BookingServiceTest {
    @MockBean
    private AirlineAndCompanyData airlineAndCompanyData;

    @Autowired
    private BookingService bookingService;

    @Test
    @Disabled("TODO: Complete this test")
    void testCompanyBookRequest() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Calendar.setTime(Calendar.java:1770)
        //       at com.freight.booking.service.BookingService.companyBookRequest(BookingService.java:30)
        //   In order to prevent companyBookRequest(BookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   companyBookRequest(BookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        this.bookingService.companyBookRequest(new BookingRequest());
    }

    @Test
    void testCompanyBookRequest2() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(new ArrayList<>());

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCompanyBookRequest3() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.BookingService.lambda$companyBookRequest$0(BookingService.java:34)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)
        //       at com.freight.booking.service.BookingService.companyBookRequest(BookingService.java:41)
        //   In order to prevent companyBookRequest(BookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   companyBookRequest(BookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(new AirlineDetail());
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        this.bookingService.companyBookRequest(bookingRequest);
    }

    @Test
    void testCompanyBookRequest4() throws ParseException {
        when(this.airlineAndCompanyData.getAirlineList()).thenThrow(new ParseException("foo", 1));

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertThrows(ParseException.class, () -> this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    void testCompanyBookRequest5() throws ParseException {
        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        airlineDetailList.add(new AirlineDetail("Airline Code", "42", "Origin Airport", "Destination Airport",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 10.0d, 1L, 1L));
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCompanyBookRequest6() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.freight.booking.service.BookingService.lambda$companyBookRequest$0(BookingService.java:34)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:174)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)
        //       at com.freight.booking.service.BookingService.companyBookRequest(BookingService.java:41)
        //   In order to prevent companyBookRequest(BookingRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   companyBookRequest(BookingRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(null);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        this.bookingService.companyBookRequest(bookingRequest);
    }

    @Test
    void testCompanyBookRequest7() throws ParseException {
        AirlineDetail airlineDetail = mock(AirlineDetail.class);
        when(airlineDetail.getAirline_Code()).thenReturn("Airline Code");

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
        verify(airlineDetail).getAirline_Code();
    }

    @Test
    void testCompanyBookRequest8() throws ParseException {
        AirlineDetail airlineDetail = mock(AirlineDetail.class);
        when(airlineDetail.getFlight_Number()).thenReturn("42");
        when(airlineDetail.getAirline_Code()).thenReturn("Airline Code");

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setAirline_Code("Airline Code");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
        verify(airlineDetail).getAirline_Code();
        verify(airlineDetail).getFlight_Number();
    }

    @Test
    void testCompanyBookRequest9() throws ParseException {
        AirlineDetail airlineDetail = mock(AirlineDetail.class);
        when(airlineDetail.getOriginAirport()).thenReturn("Origin Airport");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(airlineDetail.getFlight_Time()).thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        when(airlineDetail.getFlight_Number()).thenReturn("42");
        when(airlineDetail.getAirline_Code()).thenReturn("Airline Code");

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFlight_Number("42");
        bookingRequest.setAirline_Code("Airline Code");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
        verify(airlineDetail).getAirline_Code();
        verify(airlineDetail).getFlight_Number();
        verify(airlineDetail).getOriginAirport();
        verify(airlineDetail).getFlight_Time();
    }

    @Test
    void testCompanyBookRequest10() throws ParseException {
        AirlineDetail airlineDetail = mock(AirlineDetail.class);
        when(airlineDetail.getOriginAirport()).thenReturn("Origin Airport");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(airlineDetail.getFlight_Time())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(6)).toInstant()));
        when(airlineDetail.getFlight_Number()).thenReturn("42");
        when(airlineDetail.getAirline_Code()).thenReturn("Airline Code");

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFlight_Number("42");
        bookingRequest.setAirline_Code("Airline Code");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
        verify(airlineDetail).getAirline_Code();
        verify(airlineDetail).getFlight_Number();
        verify(airlineDetail).getFlight_Time();
    }

    @Test
    void testCompanyBookRequest11() throws ParseException {
        AirlineDetail airlineDetail = mock(AirlineDetail.class);
        when(airlineDetail.getDestination_Airport()).thenReturn("Destination Airport");
        when(airlineDetail.getOriginAirport()).thenReturn("Origin Airport");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(airlineDetail.getFlight_Time()).thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        when(airlineDetail.getFlight_Number()).thenReturn("42");
        when(airlineDetail.getAirline_Code()).thenReturn("Airline Code");

        ArrayList<AirlineDetail> airlineDetailList = new ArrayList<>();
        airlineDetailList.add(airlineDetail);
        when(this.airlineAndCompanyData.getAirlineList()).thenReturn(airlineDetailList);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setOriginAirport("Origin Airport");
        bookingRequest.setFlight_Number("42");
        bookingRequest.setAirline_Code("Airline Code");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(this.bookingService.companyBookRequest(bookingRequest));
        verify(this.airlineAndCompanyData).getAirlineList();
        verify(airlineDetail).getAirline_Code();
        verify(airlineDetail).getDestination_Airport();
        verify(airlineDetail).getFlight_Number();
        verify(airlineDetail).getOriginAirport();
        verify(airlineDetail).getFlight_Time();
    }

    @Test
    void testGetDiscount() {
        assertEquals(9.0d, this.bookingService.getDiscount(10.0d, 10.0d));
        assertEquals(90.0d, this.bookingService.getDiscount(100.0d, 10.0d));
        assertEquals(-0.9d, this.bookingService.getDiscount(-1.0d, 10.0d));
        assertEquals(0.45d, this.bookingService.getDiscount(0.5d, 10.0d));
    }
}

