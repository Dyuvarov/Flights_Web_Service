package com.dyuvarov.aviasales.model;

public class Flight {
    private String name;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;

    public Flight(String name, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime) {
        this.name = name;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
    }
}
