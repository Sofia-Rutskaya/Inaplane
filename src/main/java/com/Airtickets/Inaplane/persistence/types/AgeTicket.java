package com.Airtickets.Inaplane.persistence.types;

public enum AgeTicket {

    ADULT("Adult"),
    CHILD ("Child");

    private String title;

    AgeTicket(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
