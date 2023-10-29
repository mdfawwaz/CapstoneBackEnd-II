// package com.project.capstone.ControllerTests;import com.project.capstone.business.LoginBody;
// import com.project.capstone.business.TokenDTO;
// import com.project.capstone.controller.APIAuthController;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.oauth2.jwt.Jwt;
// import org.springframework.security.oauth2.jwt.JwtEncoder;

// import java.time.Instant;
// import java.util.Collections;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class APIAuthControllerTest {

//     @InjectMocks
//     private APIAuthController apiAuthController;

//     @Mock
//     private JwtEncoder jwtEncoder;

//     @Mock
//     private AuthenticationManager authenticationManager;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testToken() {
//         LoginBody loginBody = new LoginBody();
//         loginBody.setUsername("testuser");
//         loginBody.setPassword("testpassword");

//         // Mock Authentication
//         List<GrantedAuthority> authorities = Collections.singletonList(() -> "ROLE_USER");
//         Authentication authentication = new UsernamePasswordAuthenticationToken("testuser", "testpassword", authorities);
//         Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);

//         // Mock Jwt
//         Jwt mockedJwt = Jwt.withTokenValue("mocked-token-value").build();
//         Mockito.when(jwtEncoder.encode(Mockito.any())).thenReturn(mockedJwt);

//         // Call the token method
//         TokenDTO tokenDTO = apiAuthController.token(loginBody);

//         // Assertions
//         assertEquals("mocked-token-value", tokenDTO.getToken());
//     }
// }
