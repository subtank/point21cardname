package game21;

public class Testmain {
	public static void main(String[] args) {
		// Player playerList = Player.getInstance();
		// Card temp = new Card();
		// System.out.println(temp.getCardSuit() + temp.getCardNum());
		/*
		 * PlayerCardInHand cardsList = PlayerCardInHand.getInstance();
		 * 
		 * Card temp = new Card(); Card temp3 = new Card(); CardInHand temp2 = new
		 * CardInHand(); temp2.addCardInHand(temp); temp2.addCardInHand(temp3);
		 * cardsList.addPlayerCardInHand(temp2);
		 * System.out.println(cardsList.getPlayerCardInHand());
		 * System.out.println(temp2.getCardInHand());
		 * System.out.println(temp.getCardNum(temp.getCardId()));
		 * System.out.println(temp3.getCardNum(temp3.getCardId()));
		 * System.out.println(temp.getCardId()); System.out.println(temp3.getCardId());
		 */
		/*
		 * User temp = new User(); System.out.println(temp.chkPassword("13", "111"));
		 */
		/*
		 * 测试生成单个玩家手牌以及获取各种信息 Card temp = new Card(); int tmp1 = temp.getCardId(); int
		 * tmp2 = temp.getCardId(); System.out.println(tmp1 + "-" +
		 * temp.getCardSuit(tmp1) + temp.getCardNum(tmp1)); System.out.println(tmp2 +
		 * "-" + temp.getCardSuit(tmp2) + temp.getCardNum(tmp2)); CardInHand test = new
		 * CardInHand(); test.addCardInHand(tmp1); test.addCardInHand(tmp2);
		 * List<Integer> test2 = new ArrayList<Integer>(); test2 = test.getCardInHand();
		 * System.out.println(temp.getCard(test2.get(0)));
		 */

		//测试非法输入
//		InputStream temp = new InputStream();
//		temp.inputString(0, 0);
//		System.out.println("success!");

		//测试序列化
//		OutputStream temp = new OutputStream();
//		try {
//			temp.newUser("test", "password");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		InputStream test = new InputStream();
//		User user = null;
//		try {
//			user = (User) test.readUserInfo("test");
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(user.getUserName());
//		System.out.println(user.getUserPassword());
//		System.out.println(user.getUserRptPassword());
	}
}
