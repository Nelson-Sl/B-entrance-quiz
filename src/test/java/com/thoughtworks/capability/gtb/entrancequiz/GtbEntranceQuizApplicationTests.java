package com.thoughtworks.capability.gtb.entrancequiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GtbEntranceQuizApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void getInitialStudentsListData() throws Exception {
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(35)))
				.andExpect(jsonPath("$[0].sid",is(1)))
				.andExpect(jsonPath("$[0].name",is("沈乐棋")))
				.andExpect(jsonPath("$[9].sid",is(10)))
				.andExpect(jsonPath("$[9].name",is("但杰")))
				.andExpect(jsonPath("$[19].sid",is(20)))
				.andExpect(jsonPath("$[19].name",is("党泽")))
				.andExpect(jsonPath("$[29].sid",is(30)))
				.andExpect(jsonPath("$[29].name",is("赵允齐")))
				.andExpect(jsonPath("$[34].sid",is(35)))
				.andExpect(jsonPath("$[34].name",is("凌凤仪")));
	}

}
