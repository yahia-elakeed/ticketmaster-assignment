package com.ticketmaster.assignment.service;

import com.ticketmaster.assignment.dto.ArtistDTO;
import reactor.core.publisher.Mono;

public interface ArtistService {

    Mono<ArtistDTO> findArtistById(long id);
}
