package com.hotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hotel.booking.model.HotelBooking;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BookingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private BookingService bookingService;

	@MockBean
	private BookingRepository bookingRepository;

	private HotelBooking booking;

	@BeforeEach
	void setup() {
		booking = new HotelBooking();
		booking.setUserName("Test User1");
		booking.setHotelName("Hotel Texas Test");
		booking.setHotelAddress("Lane 1, Road Downtown, City Texas 125KN");
		booking.setCheckInDate("2024-12-20");
		booking.setCheckOutDate("2024-12-22");
		booking.setBookingAmount("500");
	}

	@Test
	void testCreateBooking() {
		when(bookingRepository.save(any(HotelBooking.class))).thenReturn(booking);
		HotelBooking createdBooking = bookingService.createBooking(booking);
		assertThat(createdBooking).isNotNull();
		assertThat(createdBooking.getUserName().equals("Test User1"));
		verify(bookingRepository, times(1)).save(booking);
	}

	@Test
	void testGetBookingById() {
		when(bookingRepository.findById(anyLong())).thenReturn(Optional.of(booking));
		HotelBooking foundBooking = bookingService.getBookingById(1L);
		assertThat(foundBooking).isNotNull();
		assertThat(foundBooking.getUserName()).isEqualTo("Test User1");
        verify(bookingRepository, times(1)).findById(1L);

	}

	@Test
    void testUpdateBooking() {
        when(bookingRepository.save(any(HotelBooking.class))).thenReturn(booking);
        when(bookingRepository.findById(anyLong())).thenReturn(Optional.of(booking));

        HotelBooking updatedBooking = bookingService.updateBooking(1L, booking);

        assertThat(updatedBooking).isNotNull();
        assertThat(updatedBooking.getUserName()).isEqualTo("Test User1");
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void testDeleteBooking() {
        doNothing().when(bookingRepository).deleteById(anyLong());

        bookingService.deleteBooking(1L);

        verify(bookingRepository, times(1)).deleteById(1L);
    }

}
