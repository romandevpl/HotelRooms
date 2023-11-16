package com.example.hotelrooms.controller;

import com.example.hotelrooms.model.HotelAvailability;
import com.example.hotelrooms.model.HotelUsage;
import com.example.hotelrooms.service.HotelOccupancyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    private HotelOccupancyService occupancyService;

    @PostMapping(path = "/roomsUsage",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelUsage availableRooms(@RequestBody HotelAvailability room){
        return occupancyService.calculateHotelOccupancy(room);
    }
}
