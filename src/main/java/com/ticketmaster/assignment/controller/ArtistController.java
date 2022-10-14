package com.ticketmaster.assignment.controller;

import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.exception.ResourceNotFoundException;
import com.ticketmaster.assignment.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    /**
     * Endpoint to get artist information for a specific artistId
     *
     * @param artistId
     * @return serialized json object from {@link Mono<ArtistDTO>}
     */
    @Operation(summary = "Get artist by artist id.",
            description = "Get artist information for a specific artist, this will contain all fields of the given artist and all the events the artist will perform at.")
    @GetMapping("${artist.api.base_url}/{artistId}")
    public Mono<ArtistDTO> findArtistById(@PathVariable("artistId") long artistId) {

        return artistService.findArtistById(artistId).switchIfEmpty(Mono.error(new ResourceNotFoundException("Artist not found!")));
    }
}
