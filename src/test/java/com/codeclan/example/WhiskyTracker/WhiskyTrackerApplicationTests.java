package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
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
	public void canFindAllWhiskiesByYear(){
		Distillery distillery1 = new Distillery("Glendronach", "Highland");
		distilleryRepository.save(distillery1);
		Whisky whisky1 = new Whisky("The Glendronach Revival", 15, 2018, distillery1);
		whiskyRepository.save(whisky1);

		Distillery distillery2 = new Distillery("Rosebank", "Lowland");
		distilleryRepository.save(distillery2);
		Whisky whisky2 = new Whisky("The Rosebank 12 - Flora and Fona", 12, 1995, distillery2);
		whiskyRepository.save(whisky2);

		Distillery distillery3 = new Distillery("Macallan", "Speyside");
		distilleryRepository.save(distillery3);
		Whisky whisky3 = new Whisky("The Macallan Anniversary Malt", 25, 1995, distillery3);
		whiskyRepository.save(whisky3);
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(1995);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		Distillery distillery1 = new Distillery("Glendronach", "Highland");
		distilleryRepository.save(distillery1);

		Distillery distillery2 = new Distillery("Rosebank", "Lowland");
		distilleryRepository.save(distillery2);

		Distillery distillery3 = new Distillery("Macallan", "Speyside");
		distilleryRepository.save(distillery3);

		Distillery distillery4 = new Distillery("Balvenie", "Speyside");
		distilleryRepository.save(distillery4);

		Distillery distillery5 = new Distillery("Highland Park", "Island");
		distilleryRepository.save(distillery5);

		Distillery distillery6 = new Distillery("Old Pulteney", "Highland");
		distilleryRepository.save(distillery6);

		Distillery distillery7 = new Distillery("Blair Athol", "Highland");
		distilleryRepository.save(distillery7);

		Distillery distillery8 = new Distillery("Glenkinchie", "Lowland");
		distilleryRepository.save(distillery8);

		Distillery distillery9 = new Distillery("Lagavulin", "Islay");
		distilleryRepository.save(distillery9);

		Distillery distillery10 = new Distillery("Laphroaig", "Islay");
		distilleryRepository.save(distillery10);

		Distillery distillery11 = new Distillery("Talisker", "Island");
		distilleryRepository.save(distillery11);

		Distillery distillery12 = new Distillery("Isle of Arran","Island" );
		distilleryRepository.save(distillery12);

		Distillery distillery13 = new Distillery("The Glenlivet","Speyside" );
		distilleryRepository.save(distillery13);
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(3, foundDistilleries.size());

	}

	@Test
	public void canFindDistilleriesById(){
	Distillery distillery1 = new Distillery("Glendronach", "Highland");
		distilleryRepository.save(distillery1);

	Distillery distillery2 = new Distillery("Rosebank", "Lowland");
		distilleryRepository.save(distillery2);

	Distillery distillery3 = new Distillery("Macallan", "Speyside");
		distilleryRepository.save(distillery3);

	Distillery distillery4 = new Distillery("Balvenie", "Speyside");
		distilleryRepository.save(distillery4);

	Distillery distillery5 = new Distillery("Highland Park", "Island");
		distilleryRepository.save(distillery5);

	Distillery distillery6 = new Distillery("Old Pulteney", "Highland");
		distilleryRepository.save(distillery6);

	Distillery distillery7 = new Distillery("Blair Athol", "Highland");
		distilleryRepository.save(distillery7);

	Distillery distillery8 = new Distillery("Glenkinchie", "Lowland");
		distilleryRepository.save(distillery8);

	Distillery distillery9 = new Distillery("Lagavulin", "Islay");
		distilleryRepository.save(distillery9);

	Distillery distillery10 = new Distillery("Laphroaig", "Islay");
		distilleryRepository.save(distillery10);

	Distillery distillery11 = new Distillery("Talisker", "Island");
		distilleryRepository.save(distillery11);

	Distillery distillery12 = new Distillery("Isle of Arran","Island" );
		distilleryRepository.save(distillery12);

	Distillery distillery13 = new Distillery("The Glenlivet","Speyside" );
		distilleryRepository.save(distillery13);
	Distillery foundDistillery = distilleryRepository.findDistilleryById(1L);
	assertEquals("Glendronach", foundDistillery.getName());

	}

}
