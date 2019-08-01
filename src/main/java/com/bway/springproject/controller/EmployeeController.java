package com.bway.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.model.Employee;

import antlr.StringUtils;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeForm(Model model, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		model.addAttribute("emodel", new Employee());
		return "employeeForm";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee emp, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		edao.addEmployee(emp);
		return "redirect:employee";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		model.addAttribute("emodel", edao.getById(id));
		return "editForm";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteEmp(@PathVariable("id") int id, Model model, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		edao.deleteEmployee(id);
		model.addAttribute("elist", edao.getAll());
		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Employee emp, Model model, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		edao.updateEmployee(emp);
		model.addAttribute("elist", edao.getAll());
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		if (org.springframework.util.StringUtils.isEmpty(session.getAttribute("activeuser"))) {
			return "Login";
		}
		model.addAttribute("elist", edao.getAll());
		return "home";
	}

}
