package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.VenueDTO;
import com.ticketmaster.assignment.model.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper extends BaseMapper {

    public VenueDTO convertToDto(Venue venue) {
        return modelMapper.map(venue, VenueDTO.class);
    }

    public Venue convertToModel(VenueDTO venueDTO) {
        return modelMapper.map(venueDTO, Venue.class);
    }

}
