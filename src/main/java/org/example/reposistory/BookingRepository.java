package org.example.reposistory;

import org.example.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.user.userId = :userId ORDER BY b.bookingTime DESC")
    List<Booking> findByUserIdOrderByBookingTimeDesc(@Param("userId") Long userId);

    @Query("SELECT b FROM Booking b WHERE b.show.showId = :showId")
    List<Booking> findByShowId(@Param("showId") Long showId);

    @Query("SELECT b FROM Booking b WHERE b.user.userId = :userId AND b.status = :status")
    List<Booking> findByUserIdAndStatus(@Param("userId") Long userId,
                                        @Param("status") Booking.BookingStatus status);
}
