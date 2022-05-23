package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crop {
	@JsonProperty("cropKey")
	public String cropKey;
	@JsonProperty("cropName")
	public CropName cropName;
	@JsonProperty("mathUnit")
	public MathUnit mathUnit;

	public String getCropKey() {
		return cropKey;
	}

	public void setCropKey(String cropKey) {
		this.cropKey = cropKey;
	}

	public CropName getCropName() {
		return cropName;
	}

	public void setCropName(CropName cropName) {
		this.cropName = cropName;
	}

	public MathUnit getMathUnit() {
		return mathUnit;
	}

	public void setMathUnit(MathUnit mathUnit) {
		this.mathUnit = mathUnit;
	}

}
