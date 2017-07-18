package game21;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<String> PlayerId = new ArrayList<String>();
	public List<Card> CardInHand = new ArrayList<Card>();
	
	public List<Card> getCardInHand() {
		return CardInHand;
	}
	
	public List<String> getPlayerId() {
		return PlayerId;
	}
	
	public void setNewPlayerId(String playerId) {
		this.PlayerId.add(playerId);
		//WIP: Add to Database and check 
	}
	
}
