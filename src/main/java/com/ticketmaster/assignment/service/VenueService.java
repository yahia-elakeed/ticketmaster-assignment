package com.ticketmaster.assignment.service;

import com.ticketmaster.assignment.dto.VenueDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VenueService {

    Mono<VenueDTO> findVenueById(long id);

}
