package com.horger.swiftravels.service;

import com.horger.swiftravels.model.Travel;

import java.util.Collection;

public interface TravelService {
    Travel create(Travel travel);
    Collection<Travel> list(int limit);
    Travel get(Long id);
    Travel update(Travel server);
    Boolean delete(Long id);
}
