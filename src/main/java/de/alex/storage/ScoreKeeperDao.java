package de.alex.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.speech.speechlet.Session;

/**
 * Contains the methods to interact with the persistence layer for ScoreKeeper in DynamoDB.
 */
@Component
public class ScoreKeeperDao {
	
//	@Autowired
//	private ScoreKeeperRepository repository;
	
    public ScoreKeeperDao() {
    }

    /**
     * Reads and returns the {@link ScoreKeeperGame} using user information from the session.
     * <p>
     * Returns null if the item could not be found in the database.
     * 
     * @param session
     * @return
     */
    public ScoreKeeperGame getScoreKeeperGame(Session session) {

//        ScoreKeeperUserDataItem item = repository.findOne(session.getUser().getUserId());

//        if (item == null) {
//            return null;
//        }
//
//        return ScoreKeeperGame.newInstance(session, item.getGameData());
    	
    	/* TODO: */ return null;
    }

    /**
     * Saves the {@link ScoreKeeperGame} into the database.
     * 
     * @param game
     */
    public void saveScoreKeeperGame(ScoreKeeperGame game) {
//        ScoreKeeperUserDataItem item = new ScoreKeeperUserDataItem();
//        item.setCustomerId(game.getSession().getUser().getUserId());
//        item.setGameData(game.getGameData());
//
//        repository.save(item);
    }
}
