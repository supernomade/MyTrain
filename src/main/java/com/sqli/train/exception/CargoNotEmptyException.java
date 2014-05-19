package com.sqli.train.exception;

public class CargoNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERROR! Cargo is already filled!";
	}

}
