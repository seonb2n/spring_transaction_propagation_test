package com.example.propagation_test.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.propagation_test.repository.PlayerRepository;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

@SpringBootTest
class ParentServiceTest {

    @Autowired private ParentService parentService;
    @Autowired private PlayerRepository playerRepository;

    @BeforeEach
    void deleteAll() {
        playerRepository.deleteAll();
    }

    @DisplayName("[Propagation.required] 자식 정상 실행, 부모 정상 실행")
    @Test
    public void 자식정상실행_부모정상실행() throws Exception {
        //when
        parentService.doSomething();
    }

    @DisplayName("[Propagation.required] 자식 오류 던짐, 부모 정상 실행")
    @Test
    public void 자식오류던짐_부모정상실행() throws Exception {
        //when
        assertThrows(RuntimeException.class, () -> parentService.doSomethingAndChildThrowException());
        // rollback 실행
    }

    @DisplayName("[Propagation.required] 자식 오류 던짐, 부모 오류 처리")
    @Test
    public void 자식정상실행_부모에러캐치정상실행() throws Exception {
        //when
        assertThrows(UnexpectedRollbackException.class, () -> parentService.doSomethingAndChildThrowExceptionAndCatch());
        // rollback 실행
    }

}