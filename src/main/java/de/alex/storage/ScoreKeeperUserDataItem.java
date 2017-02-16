package de.alex.storage;

/**
 * Model representing an item of the ScoreKeeperUserData table in DynamoDB for the ScoreKeeper
 * skill.
 */
public class ScoreKeeperUserDataItem {
    
    private String customerId;

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

	@Override
	public String toString() {
		return "ScoreKeeperUserDataItem [customerId=" + customerId + ", gameData=" + gameData + "]";
	}
}
