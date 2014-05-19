package com.sqli.train.utils;

import com.sqli.train.exception.CargoNotEmptyException;

public interface Fillable {
	/**
	 * implemented by wagon type for fill wagon
	 * @throws CargoNotEmptyException if cagro is already filed
	 */
	public void fill() throws CargoNotEmptyException;

	/**
	 * stat of cargo
	 * @return true if wargo is empty false isn't
	 */
	public boolean isEmpty();
}
