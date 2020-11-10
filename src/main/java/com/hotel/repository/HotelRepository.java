package com.hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	Optional<Hotel> findById(String id);
	
	List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{'address.city':?0}")
	List<Hotel> findByCity(String city);
	
	@Query("{'reviews.rating': {$gt: 6}}")  
	List<Hotel> Recommendation();

}
