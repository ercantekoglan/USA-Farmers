package com.usafarmers.farmers.calculateApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CropName {
	@JsonProperty("en")
	public String en;
	@JsonProperty("es")
	public String es;
	@JsonProperty("fr")
	public String fr;
	@JsonProperty("pt")
	public String pt;
	@JsonProperty("ru")
	public String ru;
	@JsonProperty("zh")
	public String zh;

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getEs() {
		return es;
	}

	public void setEs(String es) {
		this.es = es;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getRu() {
		return ru;
	}

	public void setRu(String ru) {
		this.ru = ru;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

}
