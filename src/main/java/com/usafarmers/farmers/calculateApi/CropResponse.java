package com.usafarmers.farmers.calculateApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CropResponse {
	@JsonProperty("databaseVersion")
	public int databaseVersion;
	@JsonProperty("databaseSource")
	public String databaseSource;
	@JsonProperty("crops")
	public ArrayList<Crop> crops;

	public int getDatabaseVersion() {
		return databaseVersion;
	}

	public void setDatabaseVersion(int databaseVersion) {
		this.databaseVersion = databaseVersion;
	}

	public String getDatabaseSource() {
		return databaseSource;
	}

	public void setDatabaseSource(String databaseSource) {
		this.databaseSource = databaseSource;
	}

	public ArrayList<Crop> getCrops() {
		return crops;
	}

	public void setCrops(ArrayList<Crop> crops) {
		this.crops = crops;
	}

}
