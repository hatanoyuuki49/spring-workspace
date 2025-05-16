package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;//宣言

	@GetMapping("/items")
	public String items(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {

		//データベースから全てのカテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();

		List<Item> itemList = null;
		if (categoryId == null) {
			itemList = itemRepository.findAll();
		} else {
			itemList = itemRepository.findByCategoryId(categoryId);
		}

		//データベースから全ての商品リストを取得
		List<Item> list = itemRepository.findAll();//find~が必要今回は全てだからall
													//()内は全て持ってくるため引数（条件）必要なし

		//取得したカテゴリーリストと商品リストをデータ置場に設定
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", itemList);

		//画面遷移
		return "items";
	}

}
