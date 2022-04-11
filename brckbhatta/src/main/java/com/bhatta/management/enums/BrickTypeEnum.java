package com.bhatta.management.enums;

public enum BrickTypeEnum {
	AVVAL(1,"avval"),
	LALPETI(2,"lalpeti"),
	PAKKAPELA(3,"pakkapela"),
	CHATKA(4,"chatka"),
	TALSA(5,"talsa"),
	PELA(6,"pela"),
	TILE(7,"tile"),
	HALF(8,"half");
	
	int id;
	String type;
	private BrickTypeEnum(int id, String type) {
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	
}
