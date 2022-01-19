package com.notlarim.notlarimltd.enums;

/**
 * An enumeration class for the category of the {@linkplain Note} entity.
 * 
 * @author ben-malik
 */
public enum Category {
    
    IMPORTANT(0),
	BUSINESS(1),
    SOCIAL(2),
    LOVE(3),
    OTHER(4);

	@SuppressWarnings("unused")
	private int i;
	Category(int i) {
		this.i = i;
	}
    
}
