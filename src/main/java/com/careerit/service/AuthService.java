package com.careerit.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careerit.config.JwtUtil;
import com.careerit.dto.AuthResponse;
import com.careerit.dto.LoginRequest;
import com.careerit.entity.Role;
import com.careerit.entity.User;
import com.careerit.repository.UserRepository;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.emailService = emailService;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

    	
    		Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());
    		
    		if(optionalUser.isEmpty()) {
    			optionalUser = userRepository.findByEmail(request.getUsername());   
    		}
    		
    		if(optionalUser.isEmpty()) {
    			return new AuthResponse("fail", null);
    		}
    		
    		
    		User user = optionalUser.get();
    		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    			return new AuthResponse("fail", null);
    		}
    		
    		
    		String token = jwtUtil.generateToken(user.getUsername());
    		return new AuthResponse("success",token);
    		
    	
    }
    
 
    public String forgotPassword(String email) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return "Email not registered";
        }

        User user = optionalUser.get();
        String token = UUID.randomUUID().toString();

        user.setResetToken(token);
        userRepository.save(user);

        emailService.sendResetEmail(email, token);
        return "Reset link sent to email";
    }

  
    public String resetPassword(String token, String newPassword) {

        Optional<User> optionalUser =
                userRepository.findByResetToken(token);

        if (optionalUser.isEmpty()) {
            return "Invalid or expired token";
        }

        User user = optionalUser.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null); // invalidate token

        userRepository.save(user);
        return "Password reset successful";
    }

}
