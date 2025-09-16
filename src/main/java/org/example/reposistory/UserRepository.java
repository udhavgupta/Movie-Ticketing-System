package org.example.reposistory;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.passwordHash = :passwordHash")
    Optional<User> findByEmailAndPasswordHash(@Param("email") String email,
                                              @Param("passwordHash") String passwordHash);

    boolean existsByEmail(String email);
}
