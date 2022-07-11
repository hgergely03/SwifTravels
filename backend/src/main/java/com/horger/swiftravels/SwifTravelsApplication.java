package com.horger.swiftravels;

import com.horger.swiftravels.model.Travel;
import com.horger.swiftravels.repository.TravelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SwifTravelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwifTravelsApplication.class, args);
    }

	@Bean
    CommandLineRunner runner(TravelRepository travelRepository) {
        return args -> {
            LocalDate startDate = LocalDate.of(2022, 2, 2);
			LocalDate endDate = LocalDate.of(2022, 2, 4);
            travelRepository.save(
					new Travel(
							null,
							"Canada",
							"Canada trip",
							"https://cdn.pixabay.com/photo/2022/06/27/10/58/mount-kilimanjaro-7287226_960_720.jpg",
							45.562548,
							-73.543787,
							"Canada",
							"Montréal",
							 startDate, endDate));
			travelRepository.save(
					new Travel(
							null,
							"Bali",
							"Bali trip",
							"https://cdn.pixabay.com/photo/2022/06/27/10/58/mount-kilimanjaro-7287226_960_720.jpg",
							-8.345780,
							115.097574,
							"Indonesia",
							"Bali",
							startDate, endDate));
			travelRepository.save(
					new Travel(
							null,
							"Szeged",
							"Szeged trip",
							"https://cdn.pixabay.com/photo/2022/06/27/10/58/mount-kilimanjaro-7287226_960_720.jpg",
							46.248544,
							20.148806,
							"Hungary",
							"Szeged",
							startDate, endDate));
        };
    }

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token",
				"Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return  new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
