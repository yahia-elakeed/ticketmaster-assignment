package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.model.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper extends BaseMapper {

    public ArtistDTO convertToDto(Artist artist) {
        return modelMapper.map(artist, ArtistDTO.class);
    }

    private Artist convertToModel(ArtistDTO artistDTO) {
        return modelMapper.map(artistDTO, Artist.class);
    }
}
