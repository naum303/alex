package de.alex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.alex.storage.ScoreKeeperGameData;
import de.alex.storage.ScoreKeeperRepository;
import de.alex.storage.ScoreKeeperUserDataItem;

@RestController
public class TestController {

	@Autowired
	private ScoreKeeperRepository repository;
	
	@RequestMapping(path="/save")
	public String testSave() {
		ScoreKeeperGameData gameData = new ScoreKeeperGameData();
		gameData.setPlayers(Arrays.asList("Peter", "Petra", "Hans"));
		Map<String, Long> scores = new HashMap<>();
		scores.put("Peter", 123l);
		scores.put("Petra", 456l);
		scores.put("Hans", 789l);
		gameData.setScores(scores);
		
		ScoreKeeperUserDataItem dataItem = new ScoreKeeperUserDataItem();
		dataItem.setGameData(gameData);
		dataItem.setCustomerId("customerId");
		repository.save(dataItem);
		return "works";
	}
	
	@RequestMapping(path="/read")
	public ScoreKeeperUserDataItem testRead() {
		return repository.findOne("customerId");
	}
}
