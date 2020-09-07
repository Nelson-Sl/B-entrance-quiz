package com.thoughtworks.capability.gtb.entrancequiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentListService;
import com.thoughtworks.capability.gtb.entrancequiz.api.StudentListAPI;
import com.thoughtworks.capability.gtb.entrancequiz.data.StudentData;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

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

	@BeforeEach
	public void setUp() {
		StudentData.setStudentList(new ArrayList<>(
			Arrays.asList(
					new Student(1, "沈乐棋"),
					new Student(2, "徐慧慧"),
					new Student(3, "陈思聪"),
					new Student(4, "王江林"),
					new Student(5, "王登宇"),
					new Student(6, "杨思雨"),
					new Student(7, "江雨舟"),
					new Student(8, "廖燊"),
					new Student(9, "胡晓"),
					new Student(10, "但杰"),
					new Student(11, "盖迈达"),
					new Student(12, "肖美琦"),
					new Student(13, "黄云洁"),
					new Student(14, "齐瑾浩"),
					new Student(15, "刘亮亮"),
					new Student(16, "肖逸凡"),
					new Student(17, "王作文"),
					new Student(18, "郭瑞凌"),
					new Student(19, "李明豪"),
					new Student(20, "党泽"),
					new Student(21, "肖伊佐"),
					new Student(22, "贠晨曦"),
					new Student(23, "李康宁"),
					new Student(24, "马庆"),
					new Student(25, "商婕"),
					new Student(26, "余榕"),
					new Student(27, "谌哲"),
					new Student(28, "董翔锐"),
					new Student(29, "陈泰宇"),
					new Student(30, "赵允齐"),
					new Student(31, "张柯"),
					new Student(32, "廖文强"),
					new Student(33, "刘轲"),
					new Student(34, "廖浚斌"),
					new Student(35, "凌凤仪")
			)));
	}

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

	@Test
	void addStudentSuccessfully() throws Exception {
		mockMvc.perform(post("/students")
				.content("张三").characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andReturn();
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(36)))
				.andExpect(jsonPath("$[35].sid",is(36)))
				.andExpect(jsonPath("$[35].name",is("张三")));
	}

	@Test
	void addStudentWithSameNameSuccessfully() throws Exception {
		mockMvc.perform(post("/students")
				.content("廖燊").characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andReturn();
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(36)))
				.andExpect(jsonPath("$[35].sid",is(36)))
				.andExpect(jsonPath("$[35].name",is("廖燊")));
	}

}
