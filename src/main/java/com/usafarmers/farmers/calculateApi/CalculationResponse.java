package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationResponse {
	@JsonProperty("cropKey")
	public String cropKey;
	@JsonProperty("isImperialMath")
	public boolean isImperialMath;
	@JsonProperty("yieldGoal")
	public int yieldGoal;
	@JsonProperty("yieldUnit")
	public String yieldUnit;
	@JsonProperty("nutrientUnit")
	public String nutrientUnit;
	@JsonProperty("nutrient")
	public Nutrient nutrient;
	@JsonProperty("cropName")
	public CropName cropName;

	public String getCropKey() {
		return cropKey;
	}

	public void setCropKey(String cropKey) {
		this.cropKey = cropKey;
	}

	public boolean isImperialMath() {
		return isImperialMath;
	}

	public void setImperialMath(boolean isImperialMath) {
		this.isImperialMath = isImperialMath;
	}

	public int getYieldGoal() {
		return yieldGoal;
	}

	public void setYieldGoal(int yieldGoal) {
		this.yieldGoal = yieldGoal;
	}

	public String getYieldUnit() {
		return yieldUnit;
	}

	public void setYieldUnit(String yieldUnit) {
		this.yieldUnit = yieldUnit;
	}

	public String getNutrientUnit() {
		return nutrientUnit;
	}

	public void setNutrientUnit(String nutrientUnit) {
		this.nutrientUnit = nutrientUnit;
	}

	public Nutrient getNutrient() {
		return nutrient;
	}

	public void setNutrient(Nutrient nutrient) {
		this.nutrient = nutrient;
	}

	public CropName getCropName() {
		return cropName;
	}

	public void setCropName(CropName cropName) {
		this.cropName = cropName;
	}

}
