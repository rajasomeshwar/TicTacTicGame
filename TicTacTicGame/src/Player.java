
public class Player {
	private String playerName ; 
	private int playerId ;
	
	
	
	
	public Player(int playerId , String playerName) {
		super();
		this.playerName = playerName;
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + "]";
	} 
	

}
