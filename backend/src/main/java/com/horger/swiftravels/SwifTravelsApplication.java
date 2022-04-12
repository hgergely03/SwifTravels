package com.horger.swiftravels;

import com.horger.swiftravels.model.Travel;
import com.horger.swiftravels.repository.TravelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SwifTravelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwifTravelsApplication.class, args);
    }

	@Bean
    CommandLineRunner runner(TravelRepository travelRepository) {
        return args -> {
            LocalDate date = LocalDate.of(2022, 2, 2);
            travelRepository.save(
					new Travel(
							null,
							"Canada",
							"Canada trip",
							"",
							45.562548,
							-73.543787,
							"Canada",
							"Montréal",
							date, date));
			travelRepository.save(
					new Travel(
							null,
							"Bali",
							"Bali trip",
							"",
							-8.345780,
							115.097574,
							"Indonesia",
							"Bali",
							date, date));
			travelRepository.save(
					new Travel(
							null,
							"Szeged",
							"Szeged trip",
							"",
							46.248544,
							20.148806,
							"Hungary",
							"Szeged",
							date, date));
        };
    }

}
