package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.EventDTO;
import com.ticketmaster.assignment.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper extends BaseMapper {

    public EventDTO convertToDto(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    private Event convertToModel(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }
}
