package com.revature.hydra.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.hydra.entities.Batch;
import com.revature.hydra.entities.BatchTrainee;
import com.revature.hydra.entities.Trainer;
import com.revature.hydra.repository.BatchRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BatchRepoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BatchRepo batchRepo;

	// private static Batch batch;

	@BeforeClass
	static public void prepare() {

	}

	@Test
	public void whenFindByBatchId_thenReturnBatch() {
		Set<Integer> set = new HashSet<>();
		Set<Integer> skills = new HashSet<>();
		Trainer trainer = new Trainer(0, null, null, 0);
		List<BatchTrainee> trainees = new ArrayList<>();
		Batch batch = new Batch();
		batch.setBatchId(40);
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

		entityManager.persist(batch);
		entityManager.flush();
		Batch found = batchRepo.findByBatchId(batch.getBatchId());
		assertThat(found.getBatchId()).isEqualTo(batch.getBatchId());
	}

}
