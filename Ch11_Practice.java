/*
 * Name: 
 * Purpose: 
 * Programmer: Biruk Yidnekachew
 * Date: 28 October 2025
 */

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Ch11_Practice {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("US230",
            new GregorianCalendar(2014, 4, 5, 5, 5, 0),
            new GregorianCalendar(2014, 4, 5, 6, 15, 0)));
        
        flights.add(new Flight("US235",
            new GregorianCalendar(2014, 4, 5, 6, 55, 0),
            new GregorianCalendar(2014, 4, 5, 7, 45, 0)));
        
        flights.add(new Flight("US237",
            new GregorianCalendar(2014, 4, 5, 9, 35, 0),
            new GregorianCalendar(2014, 4, 5, 12, 55, 0)));
        
        Itinerary itinerary = new Itinerary(flights);

        System.out.println(itinerary.getTotalTravelTime());
        System.out.println(itinerary.getTotalFlightTime());
    }
}

class Flight {
    private String flightNo; 
    private GregorianCalendar departureTime; 
    private GregorianCalendar arrivalTime; 

    // Constructor
    public Flight(String newFlightNo, GregorianCalendar newDepartureTime, GregorianCalendar newArrivalTime) {
        this.flightNo = newFlightNo;
        this.departureTime = newDepartureTime;
        this.arrivalTime = newArrivalTime;
    }

    // Getters
    public String getFlightNo(){
        return this.flightNo;
    }
    public GregorianCalendar getDepartureTime(){
        return this.departureTime;
    }
    public GregorianCalendar getArrivalTime(){
        return this.arrivalTime;
    }

    // Setters
    public void setDepartureTime(GregorianCalendar newDepartureTime){
        this.departureTime = newDepartureTime;
    }
    public void SetArrivalTime(GregorianCalendar newArrivalTime){
        this.arrivalTime = newArrivalTime;
    }

    // getFlightTime()
    public long getFlightTime(){
        /*
        long departureMillis = departureTime.getTimeInMillis();
        long arrivalMillis = arrivalTime.getTimeInMillis();
        long durationMillis = arrivalMillis - departureMillis;
        */
        return (arrivalTime.getTimeInMillis() - departureTime.getTimeInMillis()) / (60 * 1000);
    }
}

class Itinerary {
    private List<Flight> flightsItinerary;

    // Constructor
    public Itinerary(List<Flight> newFlightsItinerary){
        this.flightsItinerary = newFlightsItinerary;
    }

    // getTotalTime()
    public long getTotalTravelTime(){
        return ((flightsItinerary.get(flightsItinerary.size() - 1).getArrivalTime().getTimeInMillis()) - (flightsItinerary.get(0).getDepartureTime().getTimeInMillis())) / (60 * 1000);
    }
    public long getTotalFlightTime(){
        long totalFlightTime = 0;
        for (Flight i : this.flightsItinerary){
            totalFlightTime += i.getFlightTime();
        }
        return totalFlightTime;
    }
}