package com.ticketmaster.assignment.client;

import com.ticketmaster.assignment.client.config.FeignClientConfiguration;
import com.ticketmaster.assignment.model.Venue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@Component
@ReactiveFeignClient(value = "venueClient", url = "${client.ticketmaster.venues.url}", configuration = FeignClientConfiguration.class)
public interface VenueClient {

    /**
     * Get all venues (rest client) will connect to the upstream and get all venues as a {@link Flux<  Venue  >}
     *
     * @return {@link Flux<Venue>}
     */
    @GetMapping
    Flux<Venue> getAllVenues();

}
