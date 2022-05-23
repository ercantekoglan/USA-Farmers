package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrient {
	@JsonProperty("n")
	public int n;
	@JsonProperty("p2o5")
	public int p2o5;
	@JsonProperty("k2o")
	public double k2o;
	@JsonProperty("s")
	public double s;
	@JsonProperty("p")
	public double p;
	@JsonProperty("k")
	public double k;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getP2o5() {
		return p2o5;
	}

	public void setP2o5(int p2o5) {
		this.p2o5 = p2o5;
	}

	public double getK2o() {
		return k2o;
	}

	public void setK2o(double k2o) {
		this.k2o = k2o;
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

}
