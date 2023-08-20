package com.richkane.styloo.service;

import com.richkane.styloo.persistence.RoleEnum;
import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.AuthenticationResponse;
import com.richkane.styloo.persistence.model.Cart;
import com.richkane.styloo.persistence.model.CustomerDetails;
import com.richkane.styloo.persistence.model.Role;
import com.richkane.styloo.persistence.model.User;
import com.richkane.styloo.persistence.repository.RoleRepository;
import com.richkane.styloo.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationService.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Register a new user by assigning him a new cart and the role of "USER"
     * @param request containing the email and the password of the user
     * @return newly generated JWT token
     */
    public AuthenticationResponse register(AuthenticationRequest request) {
        Role role = roleRepository.findByName(RoleEnum.USER).get();

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCart(new Cart(0.0f, Collections.emptySet()));

        User user = new User();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.getRoles().add(role);
        user.setCustomerDetails(customerDetails);
        logger.info("Created user: " + user.getEmail());

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        logger.debug("Generated new token: " + jwtToken);
        return new AuthenticationResponse(jwtToken);
    }

    /**
     * Authenticate an existing user and return a newly generated JWT
     * @param request containing the email and the password of the user
     * @return newly generated JWT token
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(), request.password()
        ));

        User user = userRepository.findByEmail(request.email()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        logger.debug("Generated new token: " + jwtToken);
        return new AuthenticationResponse(jwtToken);
    }
}
