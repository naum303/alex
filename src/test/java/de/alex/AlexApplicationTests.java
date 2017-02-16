//package de.alex;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import de.alex.storage.ScoreKeeperGameData;
//import de.alex.storage.ScoreKeeperRepository;
//import de.alex.storage.ScoreKeeperUserDataItem;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class AlexApplicationTests {
//
//	@Autowired
//    private TestEntityManager entityManager;
//	
//	@Autowired
//	private ScoreKeeperRepository repository;
//	
//	@Test
//	public void testExample() {
//		ScoreKeeperGameData gameData = new ScoreKeeperGameData();
//		gameData.setPlayers(Arrays.asList("Peter", "Petra", "Hans"));
//		Map<String, Long> scores = new HashMap<>();
//		scores.put("Peter", 123l);
//		scores.put("Petra", 456l);
//		scores.put("Hans", 789l);
//		gameData.setScores(scores);
//		
//		ScoreKeeperUserDataItem dataItem = new ScoreKeeperUserDataItem();
//		dataItem.setGameData(gameData);
//		dataItem.setCustomerId("customerId");
//		
//		this.repository.save(dataItem);
//		ScoreKeeperUserDataItem findOne = this.repository.findOne("customerId");
//		System.out.println(dataItem);
//		System.out.println(findOne);
//	}
//
//}
