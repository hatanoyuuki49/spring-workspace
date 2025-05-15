package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servise.RandomStringServise;

@Controller
public class RandomStringController {
	@Autowired //これを使うことで裏で勝手にインスタンス化してくれるため、newがいらない　DI:依存性の注入
	RandomStringServise servise;//クラスの属性として宣言する

	//初期表示
	@GetMapping("/random")
	public String index() {
		return "random";
	}

	//作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam("charLength") int charLength, //
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {

		//ランダム文字列の生成
		//RandomStringServise servise = new RandomStringServise();
		List list = servise.generate(charLength, withNumber);
		//「ルーチン処理」、ランダム文字列を共用データ置き場に設定
		model.addAttribute("randList", list);
		//画面遷移
		return "random";
	}
}
