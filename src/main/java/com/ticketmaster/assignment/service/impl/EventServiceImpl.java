package com.ticketmaster.assignment.service.impl;

import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.dto.EventDTO;
import com.ticketmaster.assignment.mapper.EventMapper;
import com.ticketmaster.assignment.model.Artist;
import com.ticketmaster.assignment.service.EventService;
import com.ticketmaster.assignment.service.VenueService;
import com.ticketmaster.assignment.client.EventClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service("eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventClient eventClient;

    @Autowired
    private VenueService venueService;

    @Autowired
    private EventMapper eventMapper;

    /**
     * Find event by artistId is responsible for interacting with event client to get event information from upstream
     *
     * @param artistId
     * @return {@link Mono < EventDTO >}
     */
    @Override
    public Flux<EventDTO> findEventByArtistId(long artistId) {
        return eventClient.getAllEvents()
                .filter(event -> event.getArtists().stream().map(Artist::getId).collect(Collectors.toList())
                        .contains(artistId)).map(eventMapper::convertToDto)
                .flatMap(eventDTO -> venueService.findVenueById(eventDTO.getVenue().getId()).doOnNext(eventDTO::setVenue).thenReturn(eventDTO));
    }
}
