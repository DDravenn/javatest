package user;

public class Loginuser {
	private String Userid;
	private String Userpassword;
	
	
	public Loginuser(String Userid,String Userpassword) {
		this.Userid=Userid;
		this.Userpassword=Userpassword;
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

	
	//判断能否登陆成功
	public boolean iflogin(String re_id,String re_pwd) {
		return Userid.equals(Userid) && Userpassword.equals(re_pwd);
	}
	
	
	
	
}
