package com.sqli.train.exception;

import com.sqli.train.utils.WagonTypeEnum;

public class WagonNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final WagonTypeEnum wagonTypeEnum;

	public WagonNotFoundException(WagonTypeEnum wagonTypeEnum) {
		this.wagonTypeEnum = wagonTypeEnum;
	}

	@Override
	public String getMessage() {
		return "This wagon type "+wagonTypeEnum.getTypeValue()+" doesn't exist !";
	}

}
