package com.dyuvarov.aviasales.model;

public class Flight {
    private String name;
    private String departureDate;
    private String arrivalDate;


    public Flight(String name, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime) {
        this.name = name;
        this.departureDate = departureDate + " " + departureTime;
        this.arrivalDate = arrivalDate + " " + arrivalTime;
    }

    public String getName() {
        return name;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
