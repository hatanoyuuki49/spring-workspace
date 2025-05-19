package com.example.demo.controllr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;//itemsテーブル操作用

	//削除処理
	@PostMapping("/items/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id) {

		itemRepository.deleteById(id);

		return "redirect:/items";
	}

	//更新画面の表示
	@GetMapping("/items/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id, Model model) {

		//itemsテーブルをIDで検索
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		return "editItem";
	}

	//更新処理
	@PostMapping("/items/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {

		//itemsテーブルをIDで検索
		Item item = itemRepository.findById(id).get();
		item.setCategoryId(categoryId);
		item.setName(name);
		item.setPrice(price);

		//itemsテーブルへの反映
		itemRepository.save(item);

		return "redirect:/items";
	}

	//2　　新規登録画面の表示
	@GetMapping("/items/add")
	public String create() {
		return "addItem";
	}

	//新規登録の処理
	@PostMapping("/items/add")
	public String store(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {

		//Itemオブジェクトの生成
		Item item = new Item(categoryId, name, price);

		itemRepository.save(item);
		return "redirect:/items";
	}

	//1
	@GetMapping("/items")
	public String index(Model model) {//謎Model model

		List<Item> itemList = itemRepository.findAll();

		model.addAttribute("items", itemList);

		return "items";
	}

}
