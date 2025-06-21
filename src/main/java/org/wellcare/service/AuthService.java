package org.wellcare.service;

import org.springframework.http.ResponseEntity;
import org.wellcare.dto.AuthRequest;

public interface AuthService {

	ResponseEntity<?> login(AuthRequest authRequest);

}
