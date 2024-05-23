package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;

@Controller //コントローラを表すアノテーション
public class CartController {

	@Autowired
	Cart cart;

	@GetMapping("/cart")
	public String showCart() {
		//hello.htmlを出力する
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price,
			Model model) {

		Item item = new Item(name, price);
		model.addAttribute("item", item);
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price) {

		List<Item> posts = cart.getPosts();
		posts.add(new Item(name, price));

		return "cart";
	}
}