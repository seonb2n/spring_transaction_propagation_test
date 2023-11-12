package com.example.propagation_test.service;

import com.example.propagation_test.domain.Player;
import com.example.propagation_test.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final PlayerRepository playerRepository;
    private final ChildService childService;

    @Transactional
    public void doSomething() {
        Player p1 = Player.of();
        p1.setNickName("parent");
        playerRepository.save(p1);
        childService.doSomethingWithRequired();
    }

    @Transactional
    public void doSomethingAndChildThrowException() throws Exception {
        Player p1 = Player.of();
        p1.setNickName("parent");
        playerRepository.save(p1);
        childService.doSomethingWithRequiredThrowCheckedException();
    }

    @Transactional
    public void doSomethingAndChildThrowExceptionAndCatch() {
        Player p1 = Player.of();
        p1.setNickName("parent");
        playerRepository.save(p1);
        try {
            childService.doSomethingWithRequiredThrowCheckedException();
        } catch (Exception e) {}
    }
}
