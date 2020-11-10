package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;

@Service
public class HotelService {

	private HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}

	public void addNewHotel(Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}

	public void update(Hotel hotel) {
		this.hotelRepository.save(hotel);
	}

	public void delete(String id) {
		this.hotelRepository.deleteById(id);
	}

	public Optional<Hotel> getHotel(String id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		return hotel; 
	}
	
	public List<Hotel> getByPricePerNight(int maxPrice) {
		List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		return hotels;
	}
	
	public List<Hotel> getByCity(String city) {
		List<Hotel> hotels = this.hotelRepository.findByCity(city);
		return hotels;
	}
	
	public List<Hotel> getBestHotels() {
		List<Hotel> hotels = this.hotelRepository.Recommendation();
		return hotels;
	}
	
	
}
