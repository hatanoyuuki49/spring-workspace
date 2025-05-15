package com.example.demo.model;

public class Account {
	//フィールド
	private String name;
	private String email;
	private String password;

	//コンストラクタ
	public Account(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	//ゲッター
	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

}
