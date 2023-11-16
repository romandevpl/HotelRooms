package com.example.hotelrooms.model;

import lombok.Data;

import java.util.List;

@Data
public class HotelUsage {
    private int usagePremium;
    private int usageEconomy;

    private int premiumRoomsTotalPrice;
    private int economyRoomsTotalPrice;

    public HotelUsage(int usagePremium, int usageEconomy, int premiumRoomsTotalPrice, int economyRoomsTotalPrice) {
        this.usagePremium = usagePremium;
        this.usageEconomy = usageEconomy;
        this.premiumRoomsTotalPrice = premiumRoomsTotalPrice;
        this.economyRoomsTotalPrice = economyRoomsTotalPrice;
    }
}
