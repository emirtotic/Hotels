package com.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hotel.entity.Address;
import com.hotel.entity.Hotel;
import com.hotel.entity.Review;
import com.hotel.repository.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private HotelRepository hotelRepository;
	
	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel rittenhouse = new Hotel(
				"The Rittenhouse", 
				220, 
				new Address("Philadelphia", "USA"), 
				Arrays.asList(
						new Review("Maria", 8, false), 
						new Review("Mark", 7, true)
					)
		);
		
		Hotel archipelagos = new Hotel(
				"Archipelagos", 
				160, 
				new Address("Mykonos", "Greece"), 
				Arrays.asList(
						new Review("Karl", 9, true),
						new Review("Ben", 10, true),
						new Review("Simon", 7, false)
					)
		);
		
		Hotel dAngleterre = new Hotel(
				"d'Angleterre", 
				90, 
				new Address("Geneva", "Switzerland"), 
				new ArrayList<>()
		);
		
		Hotel rosewoodSanMiguelDeAllende = new Hotel(
				"Rosewood San Miguel de Allende", 
				110, 
				new Address("San Miguel de Allende", "Mexico"), 
				Arrays.asList(
						new Review("Anna", 10, true),
						new Review("Mario", 6, true),
						new Review("Tony", 8, false)
					)
		);
		
		Hotel faena = new Hotel(
				"Faena Hotel Miami Beach", 
				240, 
				new Address("Miami", "USA"), 
				Arrays.asList(
						new Review("John", 10, true),
						new Review("Christina", 9, true),
						new Review("Clara", 8, false),
						new Review("Nathan", 10, false)
					)
		);
		
		// drop all hotels
		
		this.hotelRepository.deleteAll();
		
		// add our hotels to the database
		List<Hotel> hotels = Arrays.asList(rittenhouse, archipelagos, dAngleterre, rosewoodSanMiguelDeAllende, faena);
		this.hotelRepository.saveAll(hotels);
		
	}

}
