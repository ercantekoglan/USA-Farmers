package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MathUnit {

	@JsonProperty("m")
	public String m;
	@JsonProperty("i")
	public String i;

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

}
