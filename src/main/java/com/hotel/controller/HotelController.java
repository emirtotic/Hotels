package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = this.hotelService.getAllHotels();
        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel) {
        this.hotelService.addNewHotel(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel) {
        this.hotelService.update(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.hotelService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getHotel(@PathVariable("id") String id) {
        Optional<Hotel> hotel = this.hotelService.getHotel(id);
        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
        List<Hotel> hotels = this.hotelService.getByPricePerNight(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        List<Hotel> hotels = this.hotelService.getByCity(city);
        return hotels;
    }

    @GetMapping("/recommended")
    public List<Hotel> getBestHotels() {
        List<Hotel> hotels = this.hotelService.getBestHotels();
        return hotels;
    }


}
