package org.example._300347715bianca.repositories;

import org.example._300347715bianca.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findBySeatCode(String seatCode);
    Optional<Seat> findById(Long id);
}
