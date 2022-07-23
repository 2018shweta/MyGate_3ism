package com.bean;

import javax.servlet.http.HttpSession;

public class HouseBean {

	private int houseid;
	private int houseno;
	private int houseflor;
	private int userid;
	private String block;

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public int getHouseflor() {
		return houseflor;
	}

	public void setHouseflor(int houseflor) {
		this.houseflor = houseflor;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
