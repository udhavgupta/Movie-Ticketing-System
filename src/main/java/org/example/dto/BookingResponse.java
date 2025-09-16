package org.example.dto;


import org.example.entity.Booking;

import java.time.LocalDateTime;
import java.util.List;

public class BookingResponse {
    private Long bookingId;
    private String movieTitle;
    private String theaterName;
    private LocalDateTime showTime;
    private List<String> seatNumbers;
    private Double totalAmount;
    private Booking.BookingStatus status;

    // Constructors, getters, and setters
    public BookingResponse() {}

    public BookingResponse(Long bookingId, String movieTitle, String theaterName,
                           LocalDateTime showTime, List<String> seatNumbers,
                           Double totalAmount, Booking.BookingStatus status) {
        this.bookingId = bookingId;
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.showTime = showTime;
        this.seatNumbers = seatNumbers;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and setters
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }

    public String getTheaterName() { return theaterName; }
    public void setTheaterName(String theaterName) { this.theaterName = theaterName; }

    public LocalDateTime getShowTime() { return showTime; }
    public void setShowTime(LocalDateTime showTime) { this.showTime = showTime; }

    public List<String> getSeatNumbers() { return seatNumbers; }
    public void setSeatNumbers(List<String> seatNumbers) { this.seatNumbers = seatNumbers; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Booking.BookingStatus getStatus() { return status; }
    public void setStatus(Booking.BookingStatus status) { this.status = status; }
}
