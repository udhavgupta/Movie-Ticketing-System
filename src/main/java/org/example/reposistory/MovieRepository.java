package org.example.reposistory;

import org.example.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenreIgnoreCase(String genre);

    List<Movie> findByLanguageIgnoreCase(String language);

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.shows s JOIN s.theater t WHERE t.city = :city")
    List<Movie> findMoviesByCity(@Param("city") String city);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Movie> findByTitleContainingIgnoreCase(@Param("title") String title);
}
