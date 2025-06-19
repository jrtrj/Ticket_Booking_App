package org.example.entities;

import java.util.List;
public class User {
    public User() {}

    public User(String name,
                String hashedPassword,
                String email,
                List<Ticket> ticketsBooked,
                String userId) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = ticketsBooked;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;
    private String name;
    private String email;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;

    public void printTickets() {
        for (Ticket ticket : ticketsBooked) {
            System.out.println(ticket.getTicketInfo());
        }
    }
}
