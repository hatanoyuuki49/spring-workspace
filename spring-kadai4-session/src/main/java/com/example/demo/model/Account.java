package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component //springで管理
@SessionScope
public class Account {

	private String name;

	//デフォルト
	public Account() {
	}

	//アクセッサ
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
