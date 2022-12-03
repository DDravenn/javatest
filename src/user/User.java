package user;

public class User {
	public  String Userid;//用户id
	public  String Username;//用户名称
	public  String Userpassword;//用户密码
	public  String Userbalance;//账户余额
	public  String Usertelephone;//用户电话
	public  String money;//用来充值余额

	public User() {
		
	}
	public User(String Userid,String Username,String Userpassword,String Usertelephone,String Userbalance) {
		this.Userid=Userid;
		this.Username=Username;
		this.Userpassword=Userpassword;
		this.Usertelephone=Usertelephone;
		this.Userbalance=Userbalance;
	}
	
	public User(String userbalance) {
		this.Userbalance=userbalance;
	}

	public  String getUsername() {
		return Username;
	}

	public  void setUsername(String username) {
		Username = username;
	}

	public  String getUserid() {
		return Userid;
	}

	public  void setUserid(String userid) {
		Userid = userid;
	}

	public  String getUserpassword() {
		return Userpassword;
	}

	public  void setUserpassword(String userpassword) {
		this.Userpassword = userpassword;
	}

	public  String getUserbalance() {
		return Userbalance;
	}

	public  void setUserbalance(String userbalance) {
		Userbalance = userbalance;
	}

	public  String getUsertelephone() {
		return Usertelephone;
	}

	public   void setUsertelephone(String usertelephone) {
		this.Usertelephone = usertelephone;
	}
	
	public   String getMoney() {
		return money;
	}

	public  void setMoney(String money) {
		this.money = money;
	}

	public String toString() {
		return "用户id"+Userid+",用户名:"+Username+",用户密码:"+Userpassword+",用户余额"
				+Userbalance+",用户电话:"+Usertelephone;
	}




	
}
