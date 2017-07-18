package game21;

public class Card {
	private Integer id;
	private String suit;
	private String number;
	
	public void setCard(Integer id, String number, String suit) {
		this.number = number;
		this.id = id;
		this.suit = suit;
	}
	public Integer getId() {
		return id;
	}
	public String getSuit() {
		return suit;
	}
	public String getNumber() {
		return number;
	}
	
	
}
