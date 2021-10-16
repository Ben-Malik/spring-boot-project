package com.bao.baoltd.enums;

/**
 * The state of a particular product.
 * 
 * @author ben-maliktchamalam
 *
 */
public enum ProductState {
	
	ACTIVE(0),
	PASSIVE(1);

	@SuppressWarnings("unused")
	private int i;
	ProductState(int i) {
		this.i = i;	}
}
