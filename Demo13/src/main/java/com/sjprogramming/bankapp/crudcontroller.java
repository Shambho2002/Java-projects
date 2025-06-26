package com.sjprogramming.bankapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class crudcontroller {
	@Autowired
	Table table;
	List<Table>tableList;
	public crudcontroller() {
		tableList=new ArrayList<Table>();
	}
	
	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	
	@GetMapping("/datainsert")
	public String getdata(@RequestParam(value="username") String username, @RequestParam(value="email") String email, @RequestParam(value="password") String password, @RequestParam(value="repeatpassword") String repeatpassword, Model model) {
		tableList.add(new Table(username,email,password,repeatpassword));
		model.addAttribute("table", tableList);
		return "subtable";
	}

}
