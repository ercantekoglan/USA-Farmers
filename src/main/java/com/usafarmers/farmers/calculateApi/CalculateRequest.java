package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateRequest {
	@JsonProperty("cropKey")
	public String cropKey;
	@JsonProperty("yieldGoal")
	public int yieldGoal;
	@JsonProperty("isImperialMath")
	public boolean isImperialMath;

	public String getCropKey() {
		return cropKey;
	}

	public void setCropKey(String cropKey) {
		this.cropKey = cropKey;
	}

	public int getYieldGoal() {
		return yieldGoal;
	}

	public void setYieldGoal(int yieldGoal) {
		this.yieldGoal = yieldGoal;
	}

	public boolean isImperialMath() {
		return isImperialMath;
	}

	public void setImperialMath(boolean isImperialMath) {
		this.isImperialMath = isImperialMath;
	}

}
