package edu.mum.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticateUser {

	public void authenticate(AuthenticationManager authenticationManager, String name, String password) {//throws Exception {
//			try {
		Authentication request = new UsernamePasswordAuthenticationToken(name, password);
		Authentication result = authenticationManager.authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(result);
//			} catch (AuthenticationException e) {
//				System.out.println();
//				System.out.println("Authentication failed: " + e.getMessage());
//			}
	}

	public void logout() {
		// Clears the context for the current user/thread
		SecurityContextHolder.clearContext();
	}
}
