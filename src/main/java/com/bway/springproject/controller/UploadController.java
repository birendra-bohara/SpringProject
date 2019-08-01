package com.bway.springproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload",method = RequestMethod.GET)
	public String uploadForm() {
		return "uploadForm";
	}
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		if(!file.isEmpty()) {
			FileOutputStream fout=new FileOutputStream("C:\\Users\\biren\\Documents\\workspace-sts-3.9.9.RELEASE\\SpringProject\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
			fout.write(file.getBytes());
			fout.close();
			model.addAttribute("msg","UPload Successfull");
			return "uploadForm";
		}
		model.addAttribute("msg","UPload not Successfull");
		return "uploadForm";
	}
}
