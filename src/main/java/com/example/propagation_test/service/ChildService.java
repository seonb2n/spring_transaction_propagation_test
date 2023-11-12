package com.example.propagation_test.service;

import com.example.propagation_test.domain.Player;
import com.example.propagation_test.repository.PlayerRepository;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final PlayerRepository playerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void doSomethingWithRequired() {
        Player p2 = Player.of();
        p2.setNickName("child");
        playerRepository.save(p2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void doSomethingWithRequiredThrowCheckedException() throws RuntimeException {
        Player p2 = Player.of();
        p2.setNickName("child");
        playerRepository.save(p2);
        throw new RuntimeException("오류가 났어요.");
    }

}
