package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.dao.UserDao;
import com.bway.springproject.model.User;

@Controller
public class SignupController {

	@Autowired
	private UserDao udao;    // UserDao udao=new UserDaoImpl();

	@RequestMapping(value = "/usersignup", method = RequestMethod.GET)
	public String getLoginForm() {
		return "signup";
	}

	@RequestMapping(value = "/usersignup", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User u) {
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		udao.signup(u);
		return "Login";
	}
}
