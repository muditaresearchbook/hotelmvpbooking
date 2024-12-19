package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
