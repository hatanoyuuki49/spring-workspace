package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login") //アノテーション
	public String index() {
		return "/login";
	}

	private static final String userid = "student";
	private static final String userpassword = "student";

	@PostMapping("/login")
	public String login(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			Model model) {

		String nextpage = "";//変数nextpageを宣言することでこの先の処理をnextpageに入れることができる
		if (userid.equals(id) && userpassword.equals(password)) {
			nextpage = "login";
		} else {
			String error = "";

			if (!userid.equals(id)) {
				error = "ユーザーidが一致しませんでした";
			} else {
				error = "パスワードが一致しませんでした";
			}
			model.addAttribute("message", error);
			nextpage = "login";
		}

		return nextpage;

	}

}
