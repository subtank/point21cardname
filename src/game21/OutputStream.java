package game21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStream {
	// 读取文件
	private static final String DATABASE_PATH = "./UserDatabase/";

	// 保证用户路径存在
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
			System.out.println("用户已存在！请换一个ID");
			return true;
		}
		//序列化输出到文件中
		temp.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
		User user = new User(name, password, 0, 0);
		oos.writeObject(user);
		oos.close();
		System.out.println("新用户已创建！欢迎新用户：" + name);
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
		System.out.println("用户：" + name+"已登出。");
	}
	
}
