package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.VenueDTO;
import com.ticketmaster.assignment.model.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper extends BaseMapper {

    public VenueDTO convertToDto(Venue venue) {
        VenueDTO venueDTO = modelMapper.map(venue, VenueDTO.class);
        return venueDTO;
    }

    public Venue convertToModel(VenueDTO venueDTO) {
        Venue venue = modelMapper.map(venueDTO, Venue.class);
        return venue;
    }

}
