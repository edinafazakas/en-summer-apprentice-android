package com.example.tms.Models;

public class ShoppingCartModel {
    String name, ticketCategory, numberOfTickets, totalPrice;

    public ShoppingCartModel(String name, String ticketCategory, String numberOfTickets, String totalPrice) {
        this.name = name;
        this.ticketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(String numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
