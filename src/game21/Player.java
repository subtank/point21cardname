package game21;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例化Player，使用单例模式保证此对象在一次执行过程中内唯一
 * 
 * @author subtank
 *
 */
public class Player {
	//实例化一个私有的Player对象
	private static Player instance = new Player();
	//将构造函数私有化,保证不会实例化
	private Player() {};
	//提供唯一的可用对象
	public static Player getInstance() {
		return instance;
	}
	
	private List<User> players = new ArrayList<User>();
	public List<User> getPlayersId() {
		return players;
	}
	public void addPlayersId(User players) {
		this.players.add(players);
	}
}
