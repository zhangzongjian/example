package pers.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.example.model.User;
import pers.example.service.UserService;
import pers.example.util.Pager;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Pager pager){
		pager = userService.search(pager);
		return "";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, User user){
		userService.insert(user);
		return "";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, User user){
		userService.delete(user.getId());
		return "";
	}
	
	@RequestMapping("intoUpdate")
	public String intoUpdate(HttpServletRequest request, User user){
		user = userService.searchById(user.getId());
		return "";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, User user){
		userService.update(user);
		return "";
	}
}
