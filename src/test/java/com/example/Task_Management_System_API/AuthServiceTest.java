package com.example.Task_Management_System_API;

import com.example.Task_Management_System_API.dto.AuthRequest;
import com.example.Task_Management_System_API.dto.AuthResponse;
import com.example.Task_Management_System_API.dto.RegisterRequest;
import com.example.Task_Management_System_API.model.User;
import com.example.Task_Management_System_API.repository.UserRepository;
import com.example.Task_Management_System_API.security.JwtService;
import com.example.Task_Management_System_API.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JwtService jwtService;
    @Mock private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @Test
    public void testRegister() {
        RegisterRequest request = new RegisterRequest("user", "pass");
        when(passwordEncoder.encode("pass")).thenReturn("encodedPass");
        when(jwtService.generateToken("user")).thenReturn("jwtToken");

        AuthResponse response = authService.register(request);

        assertEquals("jwtToken", response.getToken());
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void testAuthenticate() {
        AuthRequest request = new AuthRequest("user", "pass");
        when(jwtService.generateToken("user")).thenReturn("jwtToken");

        AuthResponse response = authService.authenticate(request);

        assertEquals("jwtToken", response.getToken());
        verify(authenticationManager).authenticate(any());
    }
}
