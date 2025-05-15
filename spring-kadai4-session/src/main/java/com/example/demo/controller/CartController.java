package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

//import com.example.demo.model.Item;

@Controller
public class CartController {

	@Autowired
	HttpSession session;

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	//ログイン画面表示
	@GetMapping({ "/cart/login", "/cart/logout" })
	public String index() {
		return "cartLogin";
	}

	@PostMapping("/cart/login")
	public String login(
			@RequestParam("name") String name) {

		account.setName(name);

		return "cart";

	}

	@GetMapping("/cart/clear")
	public String clearCart() {
		//全セッションの破棄
		List<Item> items = cart.getItems();
		items.clear();
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam(name = "price", defaultValue = "0") int price) {

		//セッションに登録されている投稿リストを取得
		List<Item> items = cart.getItems();
		//リクエストパラメータをもとにして投稿記事をインスタンス化
		Item item = new Item(name, price);

		items.add(item);

		//クラスの生成

		return "cart";

	}

	@GetMapping("/cart")
	public String showCart() {
		return "cart";
	}

}
