package com.bpjoshi.advertismentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author bpjoshi(Bhagwati Prasad)
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String indexPage(){
		return "index";
	}
}
