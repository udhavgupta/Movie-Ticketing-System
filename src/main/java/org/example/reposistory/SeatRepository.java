package org.example.reposistory;

import org.example.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.show.showId = :showId")
    List<Seat> findByShowId(@Param("showId") Long showId);

    @Query("SELECT s FROM Seat s WHERE s.show.showId = :showId AND s.status = 'AVAILABLE'")
    List<Seat> findAvailableSeatsByShowId(@Param("showId") Long showId);

    @Query("SELECT s FROM Seat s WHERE s.show.showId = :showId AND s.seatNumber IN :seatNumbers")
    List<Seat> findByShowIdAndSeatNumbers(@Param("showId") Long showId,
                                          @Param("seatNumbers") List<String> seatNumbers);

    @Modifying
    @Query("UPDATE Seat s SET s.status = :status WHERE s.seatId IN :seatIds")
    int updateSeatStatus(@Param("seatIds") List<Long> seatIds,
                         @Param("status") Seat.SeatStatus status);
}
