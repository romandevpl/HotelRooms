package com.example.hotelrooms.service;

import com.example.hotelrooms.model.HotelAvailability;
import com.example.hotelrooms.model.HotelUsage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelOccupancyService {
    public static HotelUsage calculateHotelOccupancy(HotelAvailability room) {
        List<Integer> prices = readHotelClientsFromFile();
        return calculateHotelUsageAndPrices(prices, room);
    }

    private static List<Integer> readHotelClientsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("testData.json");
            return objectMapper.readValue(is, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HotelUsage calculateHotelUsageAndPrices(List<Integer> prices, HotelAvailability room) {
        List<Integer> premiumPrices = prices.stream()
                .filter(integer -> integer >= 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> economyPrices = prices.stream()
                .filter(integer -> integer < 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (room.getFreePremiumRooms() > premiumPrices.size()
                && room.getFreeEconomyRooms() < economyPrices.size()) {
            premiumPrices.add(economyPrices.get(0));
            economyPrices.remove(0);
        }

        premiumPrices = premiumPrices.stream()
                .limit(room.getFreePremiumRooms())
                .collect(Collectors.toList());
        economyPrices = economyPrices.stream()
                .limit(room.getFreeEconomyRooms())
                .collect(Collectors.toList());

        int premiumTotalPrice = premiumPrices.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int economyTotalPrice = economyPrices.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return new HotelUsage(premiumPrices.size(), economyPrices.size(), premiumTotalPrice, economyTotalPrice);
    }
}