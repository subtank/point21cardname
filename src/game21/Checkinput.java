package game21;

public class Checkinput {
	public boolean chkPassword(String userPassword, String userRptPassword) {
		if (userPassword.equals(userRptPassword))
			return true;
		return false;
	}
	
	//WIP:各种非法输入判断。
}
