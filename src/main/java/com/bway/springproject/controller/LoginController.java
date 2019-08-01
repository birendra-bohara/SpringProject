package com.bway.springproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.dao.UserDao;
import com.bway.springproject.model.User;
import com.bway.springproject.utilities.VerifyRecaptcha;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserDao udao;

	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String getLoginForm() {
		logger.info("inside login Form");
		return "Login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest request)
			throws IOException {
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		User user = udao.sigup(u.getUsername(), u.getPassword());

		String input = request.getParameter("g-recaptcha-response");
		boolean result = VerifyRecaptcha.verify(input);
		if (result) {

			if (user != null) {

				session.setAttribute("activeuser", user.getFname());
				session.setMaxInactiveInterval(100);
				model.addAttribute("user", u.getUsername());
				model.addAttribute("elist", edao.getAll());
				return "home";
			} else {
				model.addAttribute("error", "username or password is invalid");
				return "Login";
			}
		}
		model.addAttribute("error", "You are not human");
		return "Login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("Logout Successfull");
		session.invalidate();
		return "Login";
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin() {
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=489865181771251&redirect_uri=http://"
				+ "localhost:8086/springproject/authorize/facebook&response_type=code&scope=email";
	}

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request) {

		model.addAttribute("elist", edao.getAll());

		return "home";

	}

}
