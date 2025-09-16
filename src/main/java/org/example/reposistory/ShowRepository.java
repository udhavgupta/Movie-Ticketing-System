package org.example.reposistory;

import org.example.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("SELECT s FROM Show s WHERE s.movie.movieId = :movieId AND s.theater.theaterId = :theaterId")
    List<Show> findByMovieIdAndTheaterId(@Param("movieId") Long movieId,
                                         @Param("theaterId") Long theaterId);

    @Query("SELECT s FROM Show s WHERE s.movie.movieId = :movieId")
    List<Show> findByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT s FROM Show s WHERE s.theater.theaterId = :theaterId")
    List<Show> findByTheaterId(@Param("theaterId") Long theaterId);

    @Query("SELECT s FROM Show s WHERE s.showTime BETWEEN :startTime AND :endTime")
    List<Show> findShowsBetweenTimes(@Param("startTime") LocalDateTime startTime,
                                     @Param("endTime") LocalDateTime endTime);
}
