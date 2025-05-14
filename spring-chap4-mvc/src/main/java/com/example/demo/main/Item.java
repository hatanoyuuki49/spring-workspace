package com.example.demo.main;

public class Item {
	//フィールド
	private String name;
	private int price;

	//デフォルトコンストラクタ
	public Item() {
	}

	//アクセスメソッド

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

}
