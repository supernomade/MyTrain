package com.sqli.train.exception;


public class TrainModelNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private final String message;

	public TrainModelNotFoundException(int position) {
		message = "The wagon in position "+position+" not found!";
	}

	@Override
	public String getMessage() {
		return message;
	}

}
