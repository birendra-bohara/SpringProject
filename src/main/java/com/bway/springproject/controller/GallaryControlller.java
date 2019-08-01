package com.bway.springproject.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GallaryControlller {
	@RequestMapping(value="/gallery" ,method = RequestMethod.GET)
	public String gallary(Model model) {
		File fr=new File("C:\\Users\\biren\\Documents\\workspace-sts-3.9.9.RELEASE\\SpringProject\\src\\main\\webapp\\resources\\imgs");
		model.addAttribute("imglist",fr.list());
		return "galleryForm";
	}
}
