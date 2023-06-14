package com.example.travelin;

public class BusItem {
    private String busName;
    private String busRegNumber;
    private String departureLoc;
    private String departureLocDetails;
    private String departureTime;
    private String arrivalLoc;
    private String arrivalLocDetails;
    private String arrivalTime;
    private int price;
    private float rating;
    private int totalReviewers;
    private int availableSeat;

    public BusItem(String busName, String busRegNumber, String departureLoc, String departureLocDetails, String departureTime, String arrivalLoc, String arrivalLocDetails, String arrivalTime, int price, float rating, int totalReviewers, int availableSeat) {
        this.busName = busName;
        this.busRegNumber = busRegNumber;
        this.departureLoc = departureLoc;
        this.departureLocDetails = departureLocDetails;
        this.departureTime = departureTime;
        this.arrivalLoc = arrivalLoc;
        this.arrivalLocDetails = arrivalLocDetails;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.rating = rating;
        this.totalReviewers = totalReviewers;
        this.availableSeat = availableSeat;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusRegNumber() {
        return busRegNumber;
    }

    public void setBusRegNumber(String busRegNumber) {
        this.busRegNumber = busRegNumber;
    }

    public String getDepartureLoc() {
        return departureLoc;
    }

    public void setDepartureLoc(String departureLoc) {
        this.departureLoc = departureLoc;
    }

    public String getDepartureLocDetails() {
        return departureLocDetails;
    }

    public void setDepartureLocDetails(String departureLocDetails) {
        this.departureLocDetails = departureLocDetails;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalLoc() {
        return arrivalLoc;
    }

    public void setArrivalLoc(String arrivalLoc) {
        this.arrivalLoc = arrivalLoc;
    }

    public String getArrivalLocDetails() {
        return arrivalLocDetails;
    }

    public void setArrivalLocDetails(String arrivalLocDetails) {
        this.arrivalLocDetails = arrivalLocDetails;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTotalReviewers() {
        return totalReviewers;
    }

    public void setTotalReviewers(int totalReviewers) {
        this.totalReviewers = totalReviewers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
}
