package com.demo.testfromsubmition.formsubmition.data;

import com.demo.testfromsubmition.formsubmition.models.Events;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventsData {

    // need some place to put the events data
    private static final Map<Long, Events> events = new HashMap<>();

    // get all events
    public static Collection<Events> getAllEvents() {
        return events.values();
    }

    // get single event
    public static Events getById(long id) {
        return events.get(id);
    }

    // add an event
    public static void addEvent(Events event) {
        event = new Events(event.getEventName(), event.getEventDescription());
        events.put(event.getId(), event);
    }

    // remove an event
    public static void removeEvent(Long id){
        events.remove(id);
    }
}
