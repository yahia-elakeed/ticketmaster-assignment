package com.ticketmaster.assignment.service;

import com.ticketmaster.assignment.dto.EventDTO;
import reactor.core.publisher.Flux;

public interface EventService {

    Flux<EventDTO> findEventByArtistId(long artistId);
}
