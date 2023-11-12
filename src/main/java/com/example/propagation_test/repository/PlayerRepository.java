package com.example.propagation_test.repository;

import com.example.propagation_test.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
