package edu.mum.service;

public class UserCredentialsUserNameAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5481461588622288655L;

	public UserCredentialsUserNameAlreadyExistsException(Exception ex){
		super(ex);
	}
}
