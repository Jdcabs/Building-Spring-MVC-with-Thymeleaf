package com.demo.testfromsubmition.formsubmition.models;

import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@ToString
public class Events {
    private long id;
    private static long nextId = 1L;
    @NotBlank(message = "name required")
    @Size(max = 50, message = "name too long")
    private String eventName;
    @NotBlank(message = "description required")
    @Size(max = 200, message = "description too long")
    private String eventDescription;
    @NotBlank(message = "email required")
    @Email(message = "invalid email address")
    private String emailAddress;
    private TypeOfEvents typeOfEvents;

    public Events(String eventName, String eventDescription, String emailAddress, TypeOfEvents typeOfEvents) {
        this.eventName = eventName;
        this.emailAddress = emailAddress;
        this.eventDescription = eventDescription;
        this.typeOfEvents = typeOfEvents;
        this.id = nextId;
        nextId = nextId + 1;
    }

    public Events(){}

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
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public TypeOfEvents getTypeOfEvents() {
        return typeOfEvents;
    }

    public void setTypeOfEvents(TypeOfEvents typeOfEvents) {
        this.typeOfEvents = typeOfEvents;
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

