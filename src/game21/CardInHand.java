package game21;

import java.util.ArrayList;
import java.util.List;

public class CardInHand {
	private List<Integer> cardInHand = new ArrayList<Integer>();

	public List<Integer> getCardInHand() {
		return cardInHand;
	}

	public void addCardInHand(int card) {
		this.cardInHand.add(card);
	}
	
}
