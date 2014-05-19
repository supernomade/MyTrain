package com.sqli.train.utils;

public enum WagonTypeEnum {
	H("HHHH"), P("|OOOO|"), R("|hThT|"), C("|____|");

	private String typeValue;

	private WagonTypeEnum(final String typeValue) {
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return typeValue;
	}
}
