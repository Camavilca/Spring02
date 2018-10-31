package com.camavilca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SDController {

	@GetMapping("home/subir")
	public String index() {
		return "uploadandDowload/uploadfile";
	}
}
