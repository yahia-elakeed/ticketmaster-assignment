package com.ticketmaster.assignment.client;

import com.ticketmaster.assignment.client.config.FeignClientConfiguration;
import com.ticketmaster.assignment.model.Artist;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@Component
@ReactiveFeignClient(value = "artistClient", url = "${client.ticketmaster.artists.url}", configuration = FeignClientConfiguration.class)
public interface ArtistClient {

    /**
     * Get all artists (rest client) will connect to the upstream and get all artist as a {@link Flux<Artist>}
     *
     * @return {@link Flux<Artist>}
     */
    @GetMapping
    Flux<Artist> getAllArtists();
}
