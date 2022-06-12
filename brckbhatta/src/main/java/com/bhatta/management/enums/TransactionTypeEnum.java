package com.bhatta.management.enums;

public enum TransactionTypeEnum {

	DEBIT(1, "DEBIT"), CREDIT(2, "CREDIT");

	int id;
	String type;

	private TransactionTypeEnum(int id, String type) {
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
		for (TransactionTypeEnum b : values()) {
			if (b.getType().equalsIgnoreCase(type)) {
				return b.getId();
			}
		}
		return null;
	}

	public static String getTypeById(int id) {
		for (TransactionTypeEnum b : values()) {
			if (b.getId() == id) {
				return b.getType();
			}
		}
		return null;
}

}
