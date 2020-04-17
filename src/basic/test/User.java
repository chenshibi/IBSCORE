package test;

public class User {
	private String id;
	private String no;
	private String platform;
	private String rule;
	private String time;
	public User(String id, String no, String platform, String rule, String time) {
		super();
		this.id = id;
		this.no = no;
		this.platform = platform;
		this.rule = rule;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", no=" + no + ", platform=" + platform
				+ ", rule=" + rule + ", time=" + time + "]";
	}
	
	
}
