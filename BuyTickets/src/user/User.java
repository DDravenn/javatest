package user;

public class User {
	public String Userid;//用户id
	public String Username;//用户名称
	public String Userpassword;//用户密码
	public int Userbalance=0;//账户余额
	public String Usertelephone;//用户电话
	public String money;//用来充值余额
	private static int[] notes;//存彩票
	private static int num = 0;//存下注数
	public User() {
		
	}
	
	public User(String Userid,String Username,String Userpassword,String Usertelephone) {
		this.Userid=Userid;
		this.Username=Username;
		this.Userpassword=Userpassword;
		this.Usertelephone=Usertelephone;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getUserid() {
		return Userid;
	}

	public void setUserid(String userid) {
		Userid = userid;
	}

	public String getUserpassword() {
		return Userpassword;
	}

	public void setUserpassword(String userpassword) {
		Userpassword = userpassword;
	}

	public int getUserbalance() {
		return Userbalance;
	}

	public void setUserbalance(int userbalance) {
		Userbalance = userbalance;
	}

	public String getUsertelephone() {
		return Usertelephone;
	}

	public void setUsertelephone(String usertelephone) {
		Usertelephone = usertelephone;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String toString() {
		return "用户id"+Userid+",用户名:"+Username+",用户密码:"+Userpassword+",用户余额"
				+Userbalance+",用户电话:"+Usertelephone;
	}

	public static int[] getNotes() {
		return notes;
	}

	public static void setNotes(int[] notes) {
		User.notes = notes;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		User.num = num;
	}



	
}
