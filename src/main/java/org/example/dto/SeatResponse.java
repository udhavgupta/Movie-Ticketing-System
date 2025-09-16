package org.example.dto;


import org.example.entity.Seat;

public class SeatResponse {
    private Long seatId;
    private String seatNumber;
    private Seat.SeatStatus status;
    private Double price;

    // Constructors, getters, and setters
    public SeatResponse() {}

    public SeatResponse(Long seatId, String seatNumber, Seat.SeatStatus status, Double price) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.price = price;
    }

    public Long getSeatId() { return seatId; }
    public void setSeatId(Long seatId) { this.seatId = seatId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public Seat.SeatStatus getStatus() { return status; }
    public void setStatus(Seat.SeatStatus status) { this.status = status; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
