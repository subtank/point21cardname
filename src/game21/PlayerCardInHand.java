package game21;

import java.util.ArrayList;
import java.util.List;
/**
 * 所有玩家手牌集合，使用单例模式保证此对象在一次执行过程中内唯一
 * 
 * @param playerCardInHand，一个存放每一个玩家的所有手牌的List
 * @author subtank
 *
 */
public class PlayerCardInHand {
	//实例化一个私有的Player对象
	private static PlayerCardInHand instance = new PlayerCardInHand();
	//将构造函数私有化,保证不会实例化
	private PlayerCardInHand() {};
	//提供唯一的可用对象
	public static PlayerCardInHand getInstance() {
		return instance;
	}
	
	private List<CardInHand> playerCardInHand = new ArrayList<CardInHand>();
	public List<CardInHand> getPlayerCardInHand() {
		return playerCardInHand;
	}
	public void addPlayerCardInHand(CardInHand cardInHand) {
		//将一个玩家的手牌集合视为一个元素添加到所有玩家手牌集合
		playerCardInHand.add(cardInHand);
	}
}
