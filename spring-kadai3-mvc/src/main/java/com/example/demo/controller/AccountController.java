package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	@GetMapping("/account")
	public String index() {
		return "accountForm";
	}

	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		List<String> error = new ArrayList<String>();//エラーメッセージの初期化

		if (name.equals("")) {
			error.add("名前が必須です");
		} else if (name.length() > 20) {
			error.add("名前は20文字以内で入力してください");
		}
		if (email.equals("")) {
			error.add("メアドは必須です");
		}
		if (error.size() > 0) {
			model.addAttribute("error", error);
			model.addAttribute("error", name);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
		}

		if (email.equals(""))

		{
			error.add("	パスワードは必須です");

			return "accountForm";
		}

		//Accountクラスのオブジェクト生成
		Account account = new Account(name, email, password);
		//thymeleafに渡す
		model.addAttribute("account", account);

		return "accountConfirm";
	}
}
