package com.pokercrash.game.model;

public class User {
	private String nickName;
	private String password;
	private float money;
	public User(String nickName, String password, float money) {
		this.setNickName(nickName);
		this.setPassword(password);
		this.setMoney(money);
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
}
