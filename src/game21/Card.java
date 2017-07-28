package game21;

import java.util.Random;

//abstract
public class Card {
	private int cardId;
	private String cardSuit;
	private String cardNum;

	// �������cardId�ŵ���ȡ�����У���ʡ�½�������Ŀ
	public int getCardId() {
		this.cardId = new Random().nextInt(52);
		return cardId;
	}

	// ����һ���ķ�����IDת���ɿ�����Ϣ
	public String getCard(int cardId) {
		String card = getCardSuit(cardId) + getCardNum(cardId);
		return card;
	}

	public String getCardSuit(int cardId) {
		// cardSuit = Integer.toString((cardId / 13 + 1))
		switch ((cardId / 13 + 1)) {
		case 1:
			cardSuit = "����";
			break;
		case 2:
			cardSuit = "����";
			break;
		case 3:
			cardSuit = "÷��";
			break;
		case 4:
			cardSuit = "����";
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
