package com.bao.baoltd.enums;

/**
 * An enumeration indicating the state of a particular object.
 * @author ben-maliktchamalam
 *
 */
public enum State {

	ACTIVE(0),
	PASSIVE(1);

	@SuppressWarnings("unused")
	private int i;
	State(int i) {
		this.i = i;
	}
	
}
