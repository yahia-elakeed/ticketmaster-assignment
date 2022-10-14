package com.ticketmaster.assignment.mapper;

import com.ticketmaster.assignment.dto.EventDTO;
import com.ticketmaster.assignment.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper extends BaseMapper {

    public EventDTO convertToDto(Event event) {
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        return eventDTO;
    }

    private Event convertToModel(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        return event;
    }

}
