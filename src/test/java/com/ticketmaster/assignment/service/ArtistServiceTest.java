package com.ticketmaster.assignment.service;

import com.ticketmaster.assignment.client.ArtistClient;
import com.ticketmaster.assignment.dto.ArtistDTO;
import com.ticketmaster.assignment.dto.EventDTO;
import com.ticketmaster.assignment.mapper.ArtistMapper;
import com.ticketmaster.assignment.model.Artist;
import com.ticketmaster.assignment.service.impl.ArtistServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArtistServiceTest {


    @InjectMocks
    private ArtistServiceImpl artistService;

    @Mock
    private ArtistClient artistClient;

    @Mock
    private EventService eventService;

    @Mock
    private ArtistMapper artistMapper;

    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    public void findArtistById_ShouldReturnArtist(long artistId) {

        Artist artist = new Artist();
        artist.setId(artistId);

        when(artistClient.getAllArtists()).thenReturn(Flux.just(artist));

        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(Long.MAX_VALUE);
        eventDTO.setStartDate(LocalDateTime.now().plusMonths(1));

        when(eventService.findEventByArtistId(artistId)).thenReturn(Flux.just(eventDTO));

        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(artistId);

        when(artistMapper.convertToDto(artist)).thenReturn(artistDTO);

        Mono<ArtistDTO> artistDTOMono = artistService.findArtistById(artistId);

        StepVerifier.create(artistDTOMono).expectNextMatches(artistDTO1 -> artistDTO1.getId().equals(artistId)).verifyComplete();
    }


}
