package com.project.capstone.BusinessTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.project.capstone.business.TokenDTO;

 class TokenDTOTest {

    @Test
     void testGettersAndSetters() {
        TokenDTO tokenDTO = new TokenDTO();

        tokenDTO.setToken("TestToken");

        String token = tokenDTO.getToken();

        assertEquals("TestToken", token);
    }
}
