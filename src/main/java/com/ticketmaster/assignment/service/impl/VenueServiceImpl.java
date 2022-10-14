package com.ticketmaster.assignment.service.impl;

import com.ticketmaster.assignment.client.VenueClient;
import com.ticketmaster.assignment.dto.VenueDTO;
import com.ticketmaster.assignment.mapper.VenueMapper;
import com.ticketmaster.assignment.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service("venueService")
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueClient venueClient;

    @Autowired
    private VenueMapper venueMapper;


    /**
     * Find venue by id is responsible for interacting with venue client to get venue information from upstream
     *
     * @param id
     * @return {@link Mono < VenueDTO >}
     */
    @Override
    public Mono<VenueDTO> findVenueById(long id) {

        return venueClient.getAllVenues().filter(venue -> venue.getId().equals(id)).map(venueMapper::convertToDto).next();
    }

}
