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
		// WIP:���뺬�пո���Զ����ԡ�
		String inputstring = in.next();
		return inputstring;
	}

	/**
	 * overloading inputString()�������޶����뷶Χ ���ԣ� ����Сֵ�������ֵʱ�򻥻���ֵ��֤����׳ �޶����ܵ���ֵ��Χ����֤����׳
	 * 
	 * @param minLength
	 *            �ɽ��ܵ�ȡֵ��Χ��1-255
	 * @param maxLength
	 *            �ɽ��ܵ�ȡֵ��Χ��1-255
	 * @return
	 * @throws IllegalArgumentException
	 *             �Ƿ���Χ�Ĳ���ֵ
	 */
	public String inputString(int minLength, int maxLength) throws IllegalArgumentException {
		// �����������ĺϷ���
		boolean chklegal = minLength <= 0 || maxLength <= 0 || minLength > 255 || maxLength > 255;
		if (chklegal) {
			throw new IllegalArgumentException("�Ƿ�������Χ��ȡֵ��ΧΪ1-255��");
		}
		// ADD:��鳤���޶��������Сֵ�������ֵ������ֵ
		if (minLength > maxLength) {
			minLength += maxLength;
			maxLength = minLength - maxLength;
			minLength = minLength - maxLength;
		}
		String tmp;
		do {
			tmp = inputString();
			if (tmp.length() < minLength) {
				System.out.println("���볤�ȹ��̣����������" + minLength + "���ȵ��ַ���");
			} else if (tmp.length() > maxLength) {
				System.out.println("���볤�ȹ�����������С��" + maxLength + "���ȵ��ַ���");
			}
		} while (tmp.length() < minLength || tmp.length() > maxLength);
		return tmp;
	}

	/**
	 * overloading inputint() �������뷶Χ������
	 * 
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalArgumentException
	 *             �Ƿ���Χ�Ĳ���ֵ
	 */
	public int inputint(int min, int max) throws IllegalArgumentException {
		// ����Ϸ��Լ���
		boolean illegal = min <= 0 || max <= 0 || min > 255 || max > 255;
		if (illegal) {
			throw new IllegalArgumentException("�Ƿ�������Χ��ȡֵ��ΧΪ1-255��");
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
				System.out.println("������������");
			}
			if (inputint < min) {
				System.out.println("�������ݳ��ޣ����������" + min + "����ֵ");
			} else if (inputint > max) {
				System.out.println("�������ݳ��ޣ�������С��" + max + "����ֵ");
			}
		} while (inputint < min || inputint > max);
		return inputint;
	}

	/*
	 * ��½���������Լ���֤��½
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
			System.out.println("�û��������ڻ����������");
			return false;
		}
		User user = readUserInfo(name);
		if (!user.getUserPassword().equals(password)) {
			System.out.println("�û��������ڻ����������");
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
