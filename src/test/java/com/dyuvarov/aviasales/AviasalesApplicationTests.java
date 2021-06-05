package com.dyuvarov.aviasales;

import static org.assertj.core.api.Assertions.assertThat;

import au.com.bytecode.opencsv.CSVReader;
import com.dyuvarov.aviasales.controller.FlightsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileReader;

import static org.hamcrest.Matchers.emptyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AviasalesApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FlightsController controller;

	@Test
	public void TestCorrectID() throws Exception {
		assertThat(controller).isNotNull();

		CSVReader reader = new CSVReader(new FileReader("src/main/resources/flights.csv"));
		String[] line = reader.readNext();
		while ((line = reader.readNext()) != null) {
			this.mockMvc.perform(get("/flights/" + line[0]))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString(line[7])))
					.andExpect(content().string(containsString(line[3] + " " + line[4])))
					.andExpect(content().string(containsString(line[5] + " " + line[6])));
		}
	}

	@Test
	public void TestWrongID() throws Exception {
		assertThat(controller).isNotNull();

		this.mockMvc.perform(get("/flights/" + "-11"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(emptyString()));
	}

}
