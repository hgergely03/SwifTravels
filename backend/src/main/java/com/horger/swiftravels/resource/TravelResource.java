package com.horger.swiftravels.resource;

import com.horger.swiftravels.model.Response;
import com.horger.swiftravels.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/travel")
@RequiredArgsConstructor
public class TravelResource {
    private final TravelService travelService;

    public ResponseEntity<Response> getTravels() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("travels", travelService.list(30)))
                        .message("Travels retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
