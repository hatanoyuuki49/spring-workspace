package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

	@GetMapping("/")
	public String index() {
		return "itemForm";//表示するhtmlのファイル名
	}

	@PostMapping("/item")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "未入力") String name,
			@RequestParam(name = "price", defaultValue = "100") int price, //
			Model model) {

		model.addAttribute("name", name);
		model.addAttribute("price", price);
		return "itemConfirm";
	}

	@GetMapping("/item/hidden")
	public String itemHidden() {
		return "itemFormHidden";
	}

	@GetMapping("/item/{id}")
	public String show(
			@PathVariable("id") int id,
			Model model) {

		switch (id) {
		case 101:
			model.addAttribute("name", "ボールペン");
			model.addAttribute("price", 100);
			break;
		case 102:
			model.addAttribute("name", "消しゴム");
			model.addAttribute("price", 50);
			break;
		default:
			model.addAttribute("name", "未設定");
			model.addAttribute("name", 0);
			break;
		}
		return "itemConfirm";
	}

	/* switch文の別解
	
		@GetMapping("/item/{id}")
		public String show(
				@PathVariable("id") int id,
				Model model) {
	
			if (id == 101) {
				model.addAttribute("name", "ボールペン");
				model.addAttribute("price", 100);
	
			} else if (id == 102) {
				model.addAttribute("name", "消しゴム");
				model.addAttribute("price", 50);
			} else {
				model.addAttribute("name", "未設定");
				model.addAttribute("price", 0);
			}
			return "itemConfirm";
		}
	*/
	@GetMapping("/item/detail")
	public String detail() {
		return "itemDetailForm";
	}

	@PostMapping("/item/detail")
	public String confirmDetail(
			@RequestParam(name = "name", defaultValue = "未設定") String name,
			@RequestParam(name = "price", defaultValue = "未設定") int price,
			@RequestParam(name = "categoryId", defaultValue = "") int categoryId,
			@RequestParam(name = "genre", defaultValue = "") String[] genreList,
			@RequestParam(name = "releaseDate", defaultValue = "") LocalDate releaseDate,
			Model model) {

		model.addAttribute("name", name);
		model.addAttribute("price", price);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("genreList", genreList);
		model.addAttribute("releaseDate", releaseDate);

		return "itemDetailConfirm";
	}
}
