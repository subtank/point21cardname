package game21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainManu {
	static Player player = new Player();
	static Scanner in = new Scanner(System.in);

	public static void addPlayer() {
		System.out.print("���������������2-4�ˣ�:");
		int playernum = 0;
		do {
			try {
				in = new Scanner(System.in);
				playernum = in.nextInt();
			} catch (Exception e) {
				System.out.println("��������������");
			}
			if (playernum < 2 || playernum > 4) {
				System.out.println("��������ȷ������");
			}
		} while (playernum < 2 || playernum > 4);
		List<String> playerId = player.getPlayerId();
		String tempPlayerId;
		for (int i = 0; i < playernum; i++) {
			do {
				System.out.println("�������" + (i + 1) + "����ҵ�ID��");
				in = new Scanner(System.in);
				tempPlayerId = in.nextLine();
				if (playerId.contains(tempPlayerId)) {
					System.out.println("��������Ѵ��ڣ��뻻һ��ID��");
				} else if (tempPlayerId.isEmpty()) {
					System.out.println("���������Ϊ�գ��������������");
				}
			} while (playerId.contains(tempPlayerId) || tempPlayerId.isEmpty());
			player.setNewPlayerId(tempPlayerId);
			tempPlayerId = null;
		}
	}

	public static Card prepareCard() {
		Random r = new Random();
		Integer id = r.nextInt(52);

		Card c = new Card();
		String cardNum = Integer.toString(id % 13 + 1);
		String cardSuit = Integer.toString(id / 13 + 1);
		switch (cardNum) {
		case "1":
			cardNum = "A";
			break;
		case "11":
			cardNum = "J";
			break;
		case "12":
			cardNum = "Q";
			break;
		case "13":
			cardNum = "K";
			break;
		default:
			break;
		}
		switch (cardSuit) {
		case "1":
			cardSuit = "����";
			break;
		case "2":
			cardSuit = "����";
			break;
		case "3":
			cardSuit = "÷��";
			break;
		case "4":
			cardSuit = "��Ƭ";
			break;
		default:
			break;
		}
		c.setCard(id, cardNum, cardSuit);
		return c;
	}

	public static Card cardInHand() {
		Card temp = MainManu.prepareCard();
		List<Card> cardinhand = player.getCardInHand();
		List<Integer> cardId = new ArrayList<Integer>();
		for (Card card : cardinhand) {
			cardId.add(card.getId());
		}
		if (cardId.contains(temp.getId())) {
			MainManu.cardInHand();
		} else {
			player.CardInHand.add(temp);
		}
		return temp;
	}

	public static void showCardInHand(List<Card> cardinhand) {
		// List<Card> cardinhand = player.getCardInHand();
		int cardSize = cardinhand.size();
		String[] Cards = new String[cardSize];
		for (int i = 0; i < cardSize; i++) {
			Cards[i] = cardinhand.get(i).getSuit() + cardinhand.get(i).getNumber();
		}
		for (String cards : Cards) {
			System.out.println(cards);
		}
	}

	public static int numberInHand(List<Card> cardinhand) {
		int num = 0;
		int cardnum = 0;
		for (Card card : cardinhand) {
			cardnum = card.getId() % 13;
			switch (cardnum) {
			case 10:
			case 11:
			case 12:
				cardnum = 9;
				break;
			default:
				break;
			}
			num += (cardnum + 1);
		}

		return num;
	}

	public static void drawCard(String Player, List<Card> cards, List<List<Card>> eachCardInHand, int i) {
		System.out.print("���" + Player + "�������ǣ�");
		for (Card card : eachCardInHand.get(i)) {
			System.out.print(card.getSuit() + card.getNumber() + ",");
		}
		System.out.println("����������Ʒ���Ϊ��" + numberInHand(cards) + ";");
		// MainManu.showCardInHand(eachCardInHand.get(i));
		while (numberInHand(cards) < 21) {
			String drawCard;
			do {
				System.out.println("�Ƿ�Ҫ��ץһ�ţ�[Y/N]");
				in = new Scanner(System.in);
				drawCard = in.nextLine();
				if (!(drawCard.equalsIgnoreCase("Y") || drawCard.equalsIgnoreCase("N")) || drawCard.isEmpty()) {
					System.out.println("�����������������룡");
				}
			} while (!(drawCard.equalsIgnoreCase("Y") || drawCard.equalsIgnoreCase("N")) || drawCard.isEmpty());
			System.out.println(drawCard);
			if (numberInHand(cards) < 21 && drawCard.equalsIgnoreCase("Y")) {
				cards.add(cardInHand());
				eachCardInHand.add(i, cards);
				drawCard(Player, cards, eachCardInHand, i);
				break;
			} else {
				break;
			}
		}
	}

	public static String compareWinner(List<Integer> winner) {
		int bigger = 0;
		int winnerplayer = 0;
		String win;
		for (int i = 0; i < winner.size(); i++) {
			if (winner.get(i) <= 21 && winner.get(i) >= bigger) {
				if (winner.get(i) == bigger || bigger == 0) {
					win = "ƽ�֣�";
				}
				bigger = winner.get(i);
				winnerplayer = (i+1);
			}
		}
		if (winnerplayer != 0) {
			win = Integer.toString(winnerplayer);
		} else {
			win = "ƽ�֣�";
		}
		
		return win;
	}

	public static void playgame() {
		List<String> players = player.getPlayerId();
		List<List<Card>> eachCardInHand = new ArrayList<List<Card>>();
		List<Integer> winner = new ArrayList<Integer>();
		for (int i = 0; i < players.size(); i++) {
			List<Card> cards = new ArrayList<Card>();
			String Player = players.get(i);
			System.out.println("��" + (i + 1) + "λ��ҿ�ʼ��Ϸ��");
			cards.add(MainManu.cardInHand());
			eachCardInHand.add(i, cards);
			cards.add(MainManu.cardInHand());
			eachCardInHand.add(i, cards);
			drawCard(Player, cards, eachCardInHand, i);
			System.out.println("���" + Player + "�������շ���Ϊ��" + numberInHand(cards));
			winner.add(numberInHand(cards));
		}
		System.out.println(compareWinner(winner));
	}

	public static void main(String[] args) {
		System.out.println("===================");
		System.out.println();
		System.out.println("  ��ӭ��21����Ϸ");
		System.out.println();
		System.out.println("===================");
		MainManu.addPlayer();
		MainManu.playgame();
	}
}
