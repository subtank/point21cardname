package game21;

import java.util.ArrayList;
import java.util.List;
/**
 * ����������Ƽ��ϣ�ʹ�õ���ģʽ��֤�˶�����һ��ִ�й�������Ψһ
 * 
 * @param playerCardInHand��һ�����ÿһ����ҵ��������Ƶ�List
 * @author subtank
 *
 */
public class PlayerCardInHand {
	//ʵ����һ��˽�е�Player����
	private static PlayerCardInHand instance = new PlayerCardInHand();
	//�����캯��˽�л�,��֤����ʵ����
	private PlayerCardInHand() {};
	//�ṩΨһ�Ŀ��ö���
	public static PlayerCardInHand getInstance() {
		return instance;
	}
	
	private List<CardInHand> playerCardInHand = new ArrayList<CardInHand>();
	public List<CardInHand> getPlayerCardInHand() {
		return playerCardInHand;
	}
	public void addPlayerCardInHand(CardInHand cardInHand) {
		//��һ����ҵ����Ƽ�����Ϊһ��Ԫ����ӵ�����������Ƽ���
		playerCardInHand.add(cardInHand);
	}
}
