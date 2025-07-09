package com.trainBooking.app.entities;

public class Ticket {

    private String ticketId;
    private String userId;
    private String trainId;
    private int ticketPrice;
    private String dateOfTravel;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        if(ticketPrice < 0)
            throw new IllegalArgumentException("The price cannot be negative");
        this.ticketPrice = ticketPrice;
    }

    public String getTicketInfo() {
        return String.format("Ticket ID: %s belongs to User %s on %s with train id %s", 
                             ticketId, userId, dateOfTravel,trainId);
    }
}
