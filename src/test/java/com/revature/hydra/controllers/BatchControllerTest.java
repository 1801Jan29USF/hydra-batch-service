package com.revature.hydra.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.hydra.entities.Batch;
import com.revature.hydra.entities.BatchTrainee;
import com.revature.hydra.entities.Trainer;

/*
 * JUnit Test Suite for Batch Controller using Rest Assured, and Mock MVC Controllers
 * without starting full Tomcat Server.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BatchController.class)
public class BatchControllerTest {

	static private MockMvc mvc;

	@InjectMocks
	static private BatchController bc;

	private static Batch batch;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeClass
	static public void prepare() {
		batch = new Batch();
		mvc = MockMvcBuilders.standaloneSetup(bc).build();
		Set<Integer> set = new HashSet<>();
		Set<Integer> skills = new HashSet<>();
		Trainer trainer = new Trainer(0, null, null, 0);
		List<BatchTrainee> trainees = new ArrayList<>();
		batch.setBatchId(0);
		batch.setCotrainer(trainer);
		batch.setCurriculum("curriculum");
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
	public void whenFindByName_thenReturnEmployee() {

		
	}

	// @Test
	// public void testSave() throws Exception {
	//
	// mvc.perform(post("batches").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	// .andExpect(jsonPath("$", hasSize(1)))
	// .andExpect(jsonPath("$[0].curriculum").value(batch.getCurriculum()));
	//
	// }

}
