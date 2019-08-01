package com.bway.springproject.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.dao.UserDao;


@Controller
public class MailController {
	
	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String emailPage() {

		return "email";
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String sendEmail(HttpServletRequest request, Model model) {

		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String msg = request.getParameter("msg");

		Mailer.send(to, subject, msg);

		model.addAttribute("slist", edao.getAll());
		
		return "home";
	}

}
