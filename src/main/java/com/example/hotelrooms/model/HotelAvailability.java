package com.example.hotelrooms.model;

import lombok.Data;

@Data
public class HotelAvailability {
    int freePremiumRooms;
    int freeEconomyRooms;

    public HotelAvailability(int freePremiumRooms, int freeEconomyRooms) {
        this.freePremiumRooms = freePremiumRooms;
        this.freeEconomyRooms = freeEconomyRooms;
    }
}
