package com.hotel.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.model.HotelBooking;
import com.hotel.booking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/bookings")
@Api(value="Booking Service APIs", description = "Operations to Interact with Booking Service")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    /**
     * 
     * @param id
     * @return Returns the Booking with matching id
     */

    @ApiOperation(value = "Retreive Booking by booking Id")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Booking Id", required = true, dataType = "Long")})
    @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retrieved Booking Details"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Not Found"),
    })
    @GetMapping("/{id}")
    public HotelBooking viewBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

     /**
      * 
      * @param bookingId
      * @return Get all matching booking Ids
      */
    @ApiOperation(value = "Retreive Matching Bookings")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Booking Id", required = true, dataType = "Long")})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Retrieved Booking Details"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 404, message = "Not Found"),
    })
    @GetMapping List<HotelBooking> searchBookings(Long bookingId) {
        return bookingService.getMatchingBookings();
    }

    /**
     * 
     * @param Parameter of type Booking
     * @returns the created booking
     */
    @ApiOperation(value = "Creates the Booking with specified details")
    @ApiImplicitParams({@ApiImplicitParam(name = "booking", value = "Booking Details", required = true, dataType = "Json")})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Booking Created Successfully"),
    @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping
    public HotelBooking createBooking(@RequestBody HotelBooking booking) {
        return bookingService.createBooking(booking);
    }

    /**
     * 
     * @param id
     * @param booking
     * @return The Updated Booking Details
     */
    @ApiOperation(value = "Update the Booking with given Booking Id")
    @ApiImplicitParams({@ApiImplicitParam(name = "booking", value = "Booking Details", required = true, dataType = "Json")})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Booking Updated Successfully"),
    @ApiResponse(code = 400, message = "Bad Request")})
    @PutMapping("/{id}")
    public HotelBooking updateBooking(@PathVariable Long id, @RequestBody HotelBooking booking) {
        return bookingService.updateBooking(id, booking);
    }

    /**
     * 
     * @param id
     * @return Booking Deleted Sucessfully
     */
    @ApiOperation(value = "Delete the Booking with given Booking Id")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Booking Id", required = true, dataType = "Json")})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Booking Deleted Successfully"),
    @ApiResponse(code = 404, message = "Booking Not Found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
