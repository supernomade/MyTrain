package com.sqli.train.utils;

public abstract class Wagon {
	private final WagonTypeEnum wagonType;
	public Wagon(WagonTypeEnum wagonType) {
		this.wagonType=wagonType;
	}

	/**
	 * for drow any wagon
	 * @return presentation wagon of string format
	 */
	public String print(){
		return wagonType.getTypeValue();
	}

	/**
	 * get wagon type
	 * @return wagon type
	 */
	public WagonTypeEnum getWagonType(){
		return wagonType;
	}


}
