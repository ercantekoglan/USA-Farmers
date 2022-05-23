package com.usafarmers.farmers.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrients")
public class Nutrients {

	private long nutriendId;
	private String nutrientname;
	private String title;
	private String description;

	public Nutrients() {
	}

	public Nutrients(String nutrientname, String title, String description) {

		this.nutrientname = nutrientname;
		this.title = title;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getNutriendId() {
		return nutriendId;
	}

	public void setNutriendId(long nutriendId) {
		this.nutriendId = nutriendId;
	}

	public String getNutrientname() {
		return nutrientname;
	}

	public void setNutrientname(String nutrientname) {
		this.nutrientname = nutrientname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(columnDefinition = "TEXT")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Nutrients [nutriendId=" + nutriendId + ", nutrientname=" + nutrientname + ", title=" + title
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, nutriendId, nutrientname, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nutrients other = (Nutrients) obj;
		return Objects.equals(description, other.description) && nutriendId == other.nutriendId
				&& Objects.equals(nutrientname, other.nutrientname) && Objects.equals(title, other.title);
	}

}
