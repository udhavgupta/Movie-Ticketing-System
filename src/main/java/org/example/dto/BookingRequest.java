package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class BookingRequest {
    @NotNull
    private Long userId;

    @NotNull
    private Long showId;

    @NotEmpty
    private List<String> seatNumbers;

    // Constructors, getters, and setters
    public BookingRequest() {}

    public BookingRequest(Long userId, Long showId, List<String> seatNumbers) {
        this.userId = userId;
        this.showId = showId;
        this.seatNumbers = seatNumbers;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getShowId() { return showId; }
    public void setShowId(Long showId) { this.showId = showId; }

    public List<String> getSeatNumbers() { return seatNumbers; }
    public void setSeatNumbers(List<String> seatNumbers) { this.seatNumbers = seatNumbers; }
}
