package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/")
	public String index() {//ここのindexメソッド名は本来はなんでもいい（今回はメソッド名を提示されているから）
		return "index";//表示するHTMLのファイルベース名
	}

	@GetMapping({ "/", "/hello" }) //GRTメソッドでURLパターン「/」でアクセスされた場合に呼び出される　:　「/」 = 「http://localhost:8080
	public String input() {
		return "input";
	}

	@PostMapping("/hello")
	public String show(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("hobby") String hobby,
			Model model) {//遷移先画面にデータを引き継ぐための変数※次の画面に引き継ぐために必要
		model.addAttribute("name", name);//model.addAttributeで共用のデータ置き場に移行※age,hobbyも同じ
		model.addAttribute("age", age);
		model.addAttribute("hobby", hobby);
		return "hello";
	}
}