package game21;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 6877825214033390995L;
	private String userName, userPassword;
	private transient String userRptPassword;

	// ADD:增加功能，记录获胜次数以及游玩次数。
	private Integer winTimes, totalGameTimes;

	public User(String userName,String userPassword,Integer winTimes,Integer totalGameTimes) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.winTimes = winTimes;
		this.totalGameTimes = totalGameTimes;
	}
	public Integer getWinTimes() {
		return winTimes;
	}

	public void setWinTimes(Integer winTimes) {
		this.winTimes = winTimes;
	}

	public Integer getTotalGameTimes() {
		return totalGameTimes;
	}

	public void setTotalGameTimes(Integer totalGameTimes) {
		this.totalGameTimes = totalGameTimes;
	}

	transient InputStream in = new InputStream();

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// overloading
	public void setUserName() {
		final int MIN_LANGTH = 4;
		final int MAX_LANGTH = 10;
		String userName = in.inputString(MIN_LANGTH, MAX_LANGTH);
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	// overloading
	public void setUserPassword() {
		final int MIN_LANGTH = 6;
		final int MAX_LANGTH = 16;
		String userPassword = in.inputString(MIN_LANGTH, MAX_LANGTH);
		/*
		 * MD5加密方法
		 */
		this.userPassword = userPassword;
	}

	public void setUserRptPassword(String userRptPassword) {
		this.userRptPassword = userRptPassword;
	}

	// overloading
	public void setUserRptPassword() {
		final int MIN_LANGTH = 6;
		final int MAX_LANGTH = 16;
		String userRptPassword = in.inputString(MIN_LANGTH, MAX_LANGTH);
		/*
		 * MD5加密方法
		 */
		this.userRptPassword = userRptPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserRptPassword() {
		return userRptPassword;
	}
}
