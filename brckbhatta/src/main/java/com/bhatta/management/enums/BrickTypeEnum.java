package com.bhatta.management.enums;

public enum BrickTypeEnum {
	KACCHI(1,"KACCHI"),
	PAKKI(2,"PAKKI");
	
	
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
	
	public static Integer getIdByType(String type) {
		for(BrickTypeEnum b:values()) {
			if(b.getType().equalsIgnoreCase(type)) {
				return b.getId();
			}
		}
		return null;
	}
	
	public static String getTypeById(int id) {
		for(BrickTypeEnum b:values()) {
			if(b.getId()==id) {
				return b.getType();
			}
		}
		return null;
	}
	
}
