package com.ticketmaster.assignment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BaseMapper {
    @Autowired
    protected ModelMapper modelMapper;
}
