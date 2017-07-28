package game21;

import java.util.Random;

//abstract
public class Card {
	private int cardId;
	private String cardSuit;
	private String cardNum;

	// 随机生成cardId放到获取方法中，节省新建对象数目
	public int getCardId() {
		this.cardId = new Random().nextInt(52);
		return cardId;
	}

	// 按照一定的方法将ID转换成卡牌信息
	public String getCard(int cardId) {
		String card = getCardSuit(cardId) + getCardNum(cardId);
		return card;
	}

	public String getCardSuit(int cardId) {
		// cardSuit = Integer.toString((cardId / 13 + 1))
		switch ((cardId / 13 + 1)) {
		case 1:
			cardSuit = "黑桃";
			break;
		case 2:
			cardSuit = "红桃";
			break;
		case 3:
			cardSuit = "梅花";
			break;
		case 4:
			cardSuit = "方块";
			break;
		default:
			break;
		}
		return cardSuit;
	}

	public String getCardNum(int cardId) {
		// cardNum = Integer.toString((cardId % 13 + 1))
		switch (cardId % 13 + 1) {
		case 1:
			cardNum = "A";
			break;
		case 11:
			cardNum = "J";
			break;
		case 12:
			cardNum = "Q";
			break;
		case 13:
			cardNum = "K";
			break;
		default:
			cardNum = Integer.toString((cardId % 13 + 1));
			break;
		}
		return cardNum;
	}

}
