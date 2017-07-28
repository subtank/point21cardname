package game21;

public class UserSerializable /*extends User*/ implements java.io.Serializable{
	private static final long serialVersionUID = 4357209040985916893L;
	private String userName, userPassword;
	private Integer winTimes, totalGameTimes;

	public UserSerializable(String userName,String userPassword,Integer winTimes,Integer totalGameTimes) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.winTimes = winTimes;
		this.totalGameTimes = totalGameTimes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
