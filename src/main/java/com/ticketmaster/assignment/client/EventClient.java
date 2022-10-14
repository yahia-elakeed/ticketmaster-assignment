package com.ticketmaster.assignment.client;

import com.ticketmaster.assignment.client.config.FeignClientConfiguration;
import com.ticketmaster.assignment.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@Component
@ReactiveFeignClient(value = "eventClient", url = "${client.ticketmaster.events.url}", configuration = FeignClientConfiguration.class)
public interface EventClient {

    /**
     * Get all events (rest client) will connect to the upstream and get all events as a {@link Flux< Event >}
     *
     * @return {@link Flux<Event>}
     */
    @GetMapping
    Flux<Event> getAllEvents();

}
