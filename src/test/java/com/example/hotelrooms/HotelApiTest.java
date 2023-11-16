package com.example.hotelrooms;

import com.example.hotelrooms.model.HotelAvailability;
import com.example.hotelrooms.model.HotelUsage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelApiTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHotelOccupancy() throws Exception {
        String url = "http://localhost:" + port + "/roomsUsage";
        assertThat(this.restTemplate.postForObject(url,
                new HotelAvailability(3, 3), HotelUsage.class))
                .isEqualTo(new HotelUsage(3, 3, 738, 167));
        assertThat(this.restTemplate.postForObject(url,
                new HotelAvailability(7, 5), HotelUsage.class))
                .isEqualTo(new HotelUsage(6, 4, 1054, 189));
        assertThat(this.restTemplate.postForObject(url,
                new HotelAvailability(10, 1), HotelUsage.class))
                .isEqualTo(new HotelUsage(7, 1, 1153, 45));
    }
}
