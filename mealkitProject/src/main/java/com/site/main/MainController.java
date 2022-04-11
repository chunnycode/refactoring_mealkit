package com.site.main;

import com.site.order.service.OrderService;
import com.site.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("p_list", productService.productTopList());
		model.addAttribute("map", orderService.reviewTopList());
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/register";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "/logout";
	}

}
