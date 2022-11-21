package user;

public class User {
	public String Username;
	public String Userid;
	public String Userpassword;
	public int Userbalance;
	public int Usertelephone;
	public int recharge;
	
	public User() {
		
	}
	
	public User(String Userid,String Username,String Userpassword,int Userbalance,int Usertelephone) {
		this.Userid=Userid;
		this.Username=Username;
		this.Userpassword=Userpassword;
		this.Userbalance=Userbalance;
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

	public int getUsertelephone() {
		return Usertelephone;
	}

	public void setUsertelephone(int usertelephone) {
		Usertelephone = usertelephone;
	}
	
	public void recharge() {
		
	}
}
