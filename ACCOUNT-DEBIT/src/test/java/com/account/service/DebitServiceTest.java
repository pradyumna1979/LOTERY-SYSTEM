package com.account.service;

import com.account.dto.DebitRequestObject;
import com.account.repository.AccountRepository;
import com.account.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class DebitServiceTest {
    @InjectMocks
    private DebitService debitService;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private UserRepository userRepository;
    DebitRequestObject debitRequestObject = mock(DebitRequestObject.class);

    @DisplayName("debit test")
    @Test
    public void debitTest(){
        when(debitRequestObject.getUserId()).thenReturn(1l);
        System.out.println("userId" +debitRequestObject.getUserId());
        when(userRepository.findByUserId(1)).thenReturn(null);
         String result = debitService.debit(debitRequestObject);
        assertEquals("User 1 not found",result);
    }

}
