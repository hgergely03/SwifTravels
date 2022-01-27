package com.horger.swiftravels.repository;

import com.horger.swiftravels.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    Travel findById(long id);
}
