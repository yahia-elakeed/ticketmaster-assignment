package com.ticketmaster.assignment.service.impl;

import com.ticketmaster.assignment.client.ArtistClient;
import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.mapper.ArtistMapper;
import com.ticketmaster.assignment.service.ArtistService;
import com.ticketmaster.assignment.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistClient artistClient;

    @Autowired
    private EventService eventService;

    @Autowired
    private ArtistMapper artistMapper;


    /**
     * Find artist by id is responsible for interacting with artist client to get artist information from upstream
     *
     * @param id
     * @return {@link Mono<ArtistDTO>}
     */
    @Override
    public Mono<ArtistDTO> findArtistById(long id) {

        return artistClient.getAllArtists().filter(artist -> artist.getId().equals(id))
                .map(artistMapper::convertToDto)
                .flatMap(artistDTO -> eventService.findEventByArtistId(id).collectList().doOnNext(artistDTO::setEvents).thenReturn(artistDTO)).next();
    }
}
