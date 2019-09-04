package CarBank;

public class Carn {
	private int carid;//银行卡ID
	private String carname;//银行卡用户
	private String carpwd;//用户密码
	private double carmoney;//金额
	
	//给属性提供get,set方法
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarpwd() {
		return carpwd;
	}
	public void setCarpwd(String carpwd) {
		this.carpwd = carpwd;
	}
	public double getCarmoney() {
		return carmoney;
	}
	public void setCarmoney(double carmoney) {
		this.carmoney = carmoney;
	}
}
