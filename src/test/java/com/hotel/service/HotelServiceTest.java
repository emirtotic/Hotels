package com.hotel.service;


import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class HotelServiceTest {

    @Autowired
    private HotelRepository hotelRepository;
    private HotelService hotelService;
    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotelRepository = mock(HotelRepository.class);
        hotelService = new HotelService(hotelRepository);
        createHotel();
    }

    @Test
    @DisplayName("Find all hotels")
    void getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        when(hotelService.getAllHotels())
                .thenReturn(hotels);

    }

    @Test
    @DisplayName("Add new hotel")
    void addNewHotel() {
        when(hotelRepository.save(hotel))
                .thenReturn(hotel);
    }

    @Test
    @DisplayName("Find hotel")
    void getHotel() {

        when(hotelService.getHotel(anyString()))
                .thenReturn(java.util.Optional.ofNullable(hotel));

    }

    @Test
    @DisplayName("Find all hotels by price")
    void getByPricePerNight() {

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        System.out.println(hotel.getName());
        assertTrue(hotel.getPricePerNight() < 200);
        when(hotelService.getByPricePerNight(anyInt()))
                .thenReturn(hotels);
    }

    @Test
    @DisplayName("Find hotels by city")
    void getByCity() {

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);

        when(hotelRepository.findByCity(anyString()))
                .thenReturn(hotels);

    }

    @Test
    @DisplayName("Find best hotels")
    void getBestHotels() {

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);

        when(hotelService.getBestHotels())
                .thenReturn(hotels);

    }

    private Hotel createHotel() {
        hotel = new Hotel();
        hotel.setName("HotelTest");
        hotel.setPricePerNight(100);
        return hotel;
    }

}