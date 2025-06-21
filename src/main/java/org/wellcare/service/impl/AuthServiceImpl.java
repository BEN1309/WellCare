package org.wellcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.wellcare.config.JwtTokenProvider;
import org.wellcare.dto.AuthRequest;
import org.wellcare.dto.AuthResponse;
import org.wellcare.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public ResponseEntity<?> login(AuthRequest authRequest) {
		try {
			// Authenticate user credentials
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

			// Load user details
			UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

			// Generate token
			String token = jwtTokenProvider.generateToken(userDetails);

			return ResponseEntity.ok(new AuthResponse(token));

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(401).body("Invalid Credentials");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Authentication Failed");
		}
	}

}
