package com.usafarmers.farmers.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.usafarmers.farmers.domain.Nutrients;
import com.usafarmers.farmers.repository.NutrientRepository;

@Service
public class NutrientService {

	@Autowired
	private NutrientRepository nutrientRepo;

	private List<Nutrients> allNutrients = new ArrayList<>();

	public List<Nutrients> loadNutrients() {

		List<Nutrients> nutrientList = new ArrayList<>();

		CSVFormat csvFormat = CSVFormat.EXCEL.withDelimiter(',').withEscape('\\').withSkipHeaderRecord(true)
				.withHeader("nutrient name", "title", "description").withIgnoreSurroundingSpaces();

		CSVParser csvParser = null;
		Reader excelInput = null;
		{
			try {
				excelInput = new FileReader("nutrients.csv");
				csvParser = new CSVParser(excelInput, csvFormat);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			for (CSVRecord record : csvParser) {

				String nutrientname = record.get("nutrient name");
				String title = record.get("title");
				String description = record.get("description");

				Nutrients nutrients = new Nutrients(nutrientname, title, description);

				nutrientList.add(nutrients);
			}

		}
		return nutrientRepo.saveAll(nutrientList);

	}

	public Nutrients findByName(String name) {
		return nutrientRepo.findByName(name);
	}

	public void allNutrients() {
		allNutrients = loadNutrients();
	}

	public List<Nutrients> getNutrients() {
		if (CollectionUtils.isEmpty(allNutrients)) {
			allNutrients();
		}
		return allNutrients;
	}

}