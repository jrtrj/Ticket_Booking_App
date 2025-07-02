package com.trainBooking.app.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Train {

    private String trainId;
    private String trainName;
    private Station originStation;
    private Station arrivalStation;
    private List<List<Boolean>> seats;  // A 2D list to represent seat availability (true = taken, false = available)
    private Map<Station, LocalDateTime> stationTimes;  // Time for all stations along the way

    public Train(String trainId, String trainName, Station originStation, Station arrivalStation, 
                 int row, int column, Map<Station, LocalDateTime> stationTimes) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.originStation = originStation;
        this.arrivalStation = arrivalStation;
        this.stationTimes = stationTimes;
        this.seats = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            List<Boolean> seatRow = new ArrayList<>();
            for(int j = 0; j < column; j++) {
                seatRow.add(false);
            }
            seats.add(seatRow);
        }
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Station getOriginStation() {
        return originStation;
    }

    public void setOriginStation(Station originStation) {
        this.originStation = originStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public List<List<Boolean>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Boolean>> seats) {
        this.seats = seats;
    }

    public Map<Station, LocalDateTime> getStationTimes() {
        return stationTimes;
    }

    public void setStationTimes(Map<Station, LocalDateTime> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public void displayTrainInfo() {
        System.out.println("Train id "+trainId);        
        System.out.println("Train name "+trainName);        
        System.out.println("Origin Station "+originStation);        
        System.out.println("Arrival Station "+arrivalStation);        
        System.out.println("The Seats");
        seats.stream()
             .map(s -> s.stream()
                  .map(row -> row ? "[x]":"[ ]")
                  .collect(Collectors.joining(" ")))
             .forEach(System.out::println);
        System.out.println("The stations covered are "+stationTimes);
    }
}
