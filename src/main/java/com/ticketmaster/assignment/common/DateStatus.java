package com.ticketmaster.assignment.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum DateStatus {

    NONE("none"),
    SINGLE_DATE("singleDate"),
    MULTI_DATE("multiDate");
    private String value;

    DateStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
