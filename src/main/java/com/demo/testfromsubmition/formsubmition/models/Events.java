package com.demo.testfromsubmition.formsubmition.models;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@ToString
public class Events {
    private long id;
    private static long nextId = 1L;
    @NotBlank
    @Size(min = 5, max = 50, message = "too long")
    private String eventName;
    @Size(min = 5, max = 200, message = "too long")
    private String eventDescription;
    @Email(message = "invalid email address")
    private String emailAddress;

    public Events(String eventName, String eventDescription, String emailAddress) {
        this.eventName = eventName;
        this.emailAddress = emailAddress;
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
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
        return emailAddress;
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

