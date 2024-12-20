package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.model.HotelBooking;

public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

}
