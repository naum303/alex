package de.alex.storage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Model representing an item of the ScoreKeeperUserData table in DynamoDB for the ScoreKeeper
 * skill.
 */
@Entity
public class ScoreKeeperUserDataItem {
    
    @Id
    private String customerId;

    @OneToOne
    private ScoreKeeperGameData gameData;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ScoreKeeperGameData getGameData() {
        return gameData;
    }

    public void setGameData(ScoreKeeperGameData gameData) {
        this.gameData = gameData;
    }
}
