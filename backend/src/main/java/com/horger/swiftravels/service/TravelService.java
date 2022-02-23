package com.horger.swiftravels.service;

import com.horger.swiftravels.model.Travel;
import com.horger.swiftravels.repository.TravelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TravelService {
    private final TravelRepository travelRepository;

    public Travel create(Travel travel) {
        log.info("Saving new Travel: {}", travel.getName());
        travel.setImageLink(setTravelImageLink());

        return travelRepository.save(travel);
    }

    public Collection<Travel> list(int limit) {
        log.info("Fetching all travels");
        return travelRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    public Travel get(Long id) {
        log.info("Fetching travel by id: {}", id);
        return travelRepository.findById(id).get();
        // return travelRepository.findById(id).isPresent() ? travelRepository.findById(id).get() : null;
    }

    public Travel update(Travel server) {
        log.info("Updating ravel: {}", server.getName());

        return travelRepository.save(server);
    }

    public Boolean delete(Long id) {
        log.info("Deleting travel by id: {}", id);
        travelRepository.deleteById(id);

        return TRUE;
    }

    private String setTravelImageLink() {
        return "https://cdn.pixabay.com/photo/2016/09/12/16/35/krakow-1665093_960_720.jpg";
    }
}
