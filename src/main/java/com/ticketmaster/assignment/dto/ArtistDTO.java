package com.ticketmaster.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArtistDTO {

    private Long id;
    private String name;
    private String imgSrc;
    private String url;
    private int rank;
    private List<EventDTO> events;
}
