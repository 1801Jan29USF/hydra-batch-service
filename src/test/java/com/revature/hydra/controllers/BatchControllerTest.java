package com.revature.hydra.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.hydra.entities.Batch;
import com.revature.hydra.entities.BatchTrainee;
import com.revature.hydra.entities.Trainer;
import com.revature.hydra.services.BatchService;

/*
 * JUnit Test Suite for Batch Controller using Rest Assured, and Mock MVC Controllers
 * without starting full Tomcat Server.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BatchController.class)
public class BatchControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BatchService service;

	@BeforeClass
	public void prepare() {
		Set<Integer> set = new HashSet<>();
		Set<Integer> skills = new HashSet<>();
		Trainer trainer = new Trainer(0, null, null, 0);
		List<BatchTrainee> trainees = new ArrayList<>();
		Batch batch = new Batch();
		batch.setBatchId(0);
		batch.setCotrainer(trainer);
		batch.setCurriculum("ian");
		batch.setEndDate(new Timestamp(100));
		batch.setLocation("location");
		batch.setNotes(set);
		batch.setResourceId(1);
		batch.setSkills(skills);
		batch.setSkillType("skillType");
		batch.setStartDate(new Timestamp(50));
		batch.setTrainees(trainees);
		batch.setTrainer(trainer);
		batch.setTrainingName("trainingname");
		batch.setTrainingType("trainingtype");

	}

	@Test
	public void testSave() throws Exception {

		mvc.perform(post("batches").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].name", is(alex.getName())));

	}

}
