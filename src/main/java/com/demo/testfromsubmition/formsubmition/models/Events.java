package com.demo.testfromsubmition.formsubmition.models;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@ToString
public class Events {
    private long id;
    private static long nextId = 1L;
    private String eventName;
    private String eventDescription;

    public Events(String eventName, String eventDescription) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.id = nextId;
        nextId = nextId + 1;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Objects.equals(eventName, events.eventName) && Objects.equals(eventDescription, events.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventDescription);
    }
}

