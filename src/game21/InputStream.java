package game21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class InputStream {
	private Scanner in = new Scanner(System.in);

	public String inputString() {
		// WIP:输入含有空格后自动忽略。
		String inputstring = in.next();
		return inputstring;
	}

	/**
	 * overloading inputString()，增加限定输入范围 特性： 当最小值大于最大值时候互换数值保证程序健壮 限定接受的数值范围，保证程序健壮
	 * 
	 * @param minLength
	 *            可接受的取值范围：1-255
	 * @param maxLength
	 *            可接受的取值范围：1-255
	 * @return
	 * @throws IllegalArgumentException
	 *             非法范围的参数值
	 */
	public String inputString(int minLength, int maxLength) throws IllegalArgumentException {
		// 检查输入参数的合法性
		boolean chklegal = minLength <= 0 || maxLength <= 0 || minLength > 255 || maxLength > 255;
		if (chklegal) {
			throw new IllegalArgumentException("非法参数范围！取值范围为1-255。");
		}
		// ADD:检查长度限定，如果最小值大于最大值，交换值
		if (minLength > maxLength) {
			minLength += maxLength;
			maxLength = minLength - maxLength;
			minLength = minLength - maxLength;
		}
		String tmp;
		do {
			tmp = inputString();
			if (tmp.length() < minLength) {
				System.out.println("输入长度过短，请输入大于" + minLength + "长度的字符！");
			} else if (tmp.length() > maxLength) {
				System.out.println("输入长度过长，请输入小于" + maxLength + "长度的字符！");
			}
		} while (tmp.length() < minLength || tmp.length() > maxLength);
		return tmp;
	}

	/**
	 * overloading inputint() 增加输入范围的设置
	 * 
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalArgumentException
	 *             非法范围的参数值
	 */
	public int inputint(int min, int max) throws IllegalArgumentException {
		// 输入合法性检验
		boolean illegal = min <= 0 || max <= 0 || min > 255 || max > 255;
		if (illegal) {
			throw new IllegalArgumentException("非法参数范围！取值范围为1-255。");
		}
		if (min > max) {
			min = min + max;
			max = min - max;
			min = min - max;
		}
		int inputint = 0;
		do {
			try {
				inputint = in.nextInt();
			} catch (Exception e) {
				System.out.println("请输入整数！");
			}
			if (inputint < min) {
				System.out.println("输入数据超限！请输入大于" + min + "的数值");
			} else if (inputint > max) {
				System.out.println("输入数据超限！请输入小于" + max + "的数值");
			}
		} while (inputint < min || inputint > max);
		return inputint;
	}

	/*
	 * 登陆数据载入以及验证登陆
	 */
	private static final String DATABASE_PATH = "./UserDatabase/";

	static {
		File temp = new File(DATABASE_PATH);
		temp.mkdirs();
	}

	public boolean extUser(String name) {
		File temp = new File(DATABASE_PATH + name + ".txt");
		return temp.exists();
	}

	public boolean chkPassword(String name, String password)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		if (!extUser(name)) {
			System.out.println("用户名不存在或者密码错误！");
			return false;
		}
		User user = readUserInfo(name);
		if (!user.getUserPassword().equals(password)) {
			System.out.println("用户名不存在或者密码错误！");
			return false;
		}
		return true;
	}

	public User readUserInfo(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		File temp = new File(DATABASE_PATH + name + ".txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(temp));
		User user = (User) ois.readObject();
		ois.close();
		return user;
	}
}
