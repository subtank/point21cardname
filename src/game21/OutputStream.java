package game21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStream {
	// ��ȡ�ļ�
	private static final String DATABASE_PATH = "./UserDatabase/";

	// ��֤�û�·������
	static {
		File temp = new File(DATABASE_PATH);
		temp.mkdirs();
	}

	public boolean extUser(String name) {
		File temp = new File(DATABASE_PATH + name + ".txt");
		return temp.exists();
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean newUser(String name, String password) throws FileNotFoundException, IOException {
		File temp = new File(DATABASE_PATH + name + ".txt");
		if (extUser(name)) {
			System.out.println("�û��Ѵ��ڣ��뻻һ��ID");
			return true;
		}
		//���л�������ļ���
		temp.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
		User user = new User(name, password, 0, 0);
		oos.writeObject(user);
		oos.close();
		System.out.println("���û��Ѵ�������ӭ���û���" + name);
		return false;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param winTimes
	 * @param totalGameTimes
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void logout(String name,String password,int winTimes,int totalGameTimes) throws FileNotFoundException, IOException {
		File temp = new File(DATABASE_PATH + name + ".txt");
		temp.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
		User user = new User(name, password, winTimes, totalGameTimes);
		oos.writeObject(user);
		oos.close();
		System.out.println("�û���" + name+"�ѵǳ���");
	}
	
}
