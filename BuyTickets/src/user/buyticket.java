package user;

public class buyticket {
	private String userid;
	private  int [] ticket;
	private String amount;
	
	public buyticket() {
		
	}
	
	public buyticket(String userid,int [] ticket,String amount) {
		this.amount=amount;
		this.userid=userid;
		this.ticket=ticket;
		
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int[] getTicket() {
		return ticket;
	}

	public void setTicket(int[] ticket) {
		this.ticket = ticket;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
