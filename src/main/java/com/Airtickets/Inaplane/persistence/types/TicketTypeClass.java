package com.Airtickets.Inaplane.persistence.types;

public enum TicketTypeClass {


    FIRST_CLASS ("First class"),
    BUSINESS_CLASS ("Business class"),
    ECONOMY_CLASS ("Economy class");

    private String title;

    TicketTypeClass(String title) {
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
