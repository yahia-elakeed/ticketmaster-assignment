package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.model.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper extends BaseMapper {

    public ArtistDTO convertToDto(Artist artist) {
        ArtistDTO artistDTO = modelMapper.map(artist, ArtistDTO.class);
        return artistDTO;
    }

    private Artist convertToModel(ArtistDTO ArtistDTO) {
        Artist artist = modelMapper.map(ArtistDTO, Artist.class);
        return artist;
    }
}
