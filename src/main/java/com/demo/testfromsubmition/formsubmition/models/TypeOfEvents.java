package com.demo.testfromsubmition.formsubmition.models;

public enum TypeOfEvents {

    SEMINAR("Seminar"),
    BOOTCAMP("Bootcamp"),
    CRASHCOURSE("Crashcourse"),
    LIVEMEETING("LiveMeeting"),
    GATHERING("Gathering");

    private final String displayEventType;

    TypeOfEvents(String displayEventType) {
        this.displayEventType = displayEventType;
    }

    public String getDisplayEventType() {
        return displayEventType;
    }
}
