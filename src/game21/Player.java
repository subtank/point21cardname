package game21;

import java.util.ArrayList;
import java.util.List;

/**
 * ������Player��ʹ�õ���ģʽ��֤�˶�����һ��ִ�й�������Ψһ
 * 
 * @author subtank
 *
 */
public class Player {
	//ʵ����һ��˽�е�Player����
	private static Player instance = new Player();
	//�����캯��˽�л�,��֤����ʵ����
	private Player() {};
	//�ṩΨһ�Ŀ��ö���
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
