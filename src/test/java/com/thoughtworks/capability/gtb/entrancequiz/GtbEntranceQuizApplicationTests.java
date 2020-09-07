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

	@Test
	void getRandomTeamData() throws Exception {
		mockMvc.perform(get("/randomTeams"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(6)))
				.andExpect(jsonPath("$[0].teamName",is("Team 1")))
				.andExpect(jsonPath("$[0].teamMembers",hasSize(6)))
				.andExpect(jsonPath("$[1].teamName",is("Team 2")))
				.andExpect(jsonPath("$[1].teamMembers",hasSize(6)))
				.andExpect(jsonPath("$[2].teamName",is("Team 3")))
				.andExpect(jsonPath("$[2].teamMembers",hasSize(6)))
				.andExpect(jsonPath("$[3].teamName",is("Team 4")))
				.andExpect(jsonPath("$[3].teamMembers",hasSize(6)))
				.andExpect(jsonPath("$[4].teamName",is("Team 5")))
				.andExpect(jsonPath("$[4].teamMembers",hasSize(6)))
				.andExpect(jsonPath("$[5].teamName",is("Team 6")))
				.andExpect(jsonPath("$[5].teamMembers",hasSize(5)));
	}

}
