package com.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;

public class CreateJson {
	public void Create(String fileName, Object object) {
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			ow.writeValue(new File(fileName + ".json"), object);
            
            System.out.println("JSON file created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating JSON file: " + e.getMessage());
        }
	}
}
