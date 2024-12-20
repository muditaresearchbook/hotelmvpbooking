package com.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.model.HotelBooking;
import com.hotel.booking.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<HotelBooking> getMatchingBookings() {
        return bookingRepository.findAll(); 
    }

    public HotelBooking createBooking(HotelBooking booking) {
        return bookingRepository.save(booking);
    }

    public HotelBooking updateBooking(Long id, HotelBooking booking) {
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    public HotelBooking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
