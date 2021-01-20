package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear() {
		List<Whisky> whiskys = whiskyRepository.findByYear(2018);
		assertEquals(6, whiskys.size());
	}

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> dists = distilleryRepository.findByRegion("Speyside");
		assertEquals(3, dists.size());
	}

	@Test
	public void canGetWhiskyByDistilleryAndAge() {
		Distillery dist = distilleryRepository.getOne(1L);
		List<Whisky> whiskys = whiskyRepository.findByDistilleryAndAge(dist, 15);
		assertEquals(1, whiskys.size());
	}

	@Test
	public void canGetWhiskyByRegion() {
		List<Whisky> whiskys = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals(3, whiskys.size());
	}

	@Test
	public void canGetDistilleryByWhiskyAge() {
		List<Distillery> dists = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, dists.size());
	}

}
