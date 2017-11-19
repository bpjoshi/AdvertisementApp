package com.bpjoshi.advertismentapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bpjoshi.advertismentapp.model.Advert;
import com.bpjoshi.advertismentapp.service.AdvertService;


/**
 * @author bpjoshi(Bhagwati Prasad)
 */
@Controller
public class AdvertController {
	
	private final AdvertService advertService;
	@Autowired
	public AdvertController(AdvertService advertService){
		this.advertService=advertService;
	}
	
	@RequestMapping("/showAds")
	public String showAdverts(Model model){
		List<Advert> adverts=advertService.getAdverts();
		model.addAttribute("adverts", adverts);
		return "adverts";
	}
	
	@RequestMapping("/createAd")
	public String createAdvert(Model model){
		model.addAttribute("advert", new Advert());
		return "create";
	}
	
	@RequestMapping("/test")
	public String showAdById(Model model, @RequestParam("id") String id){
		
		return "index";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String doCreateAdvert(Model model, @Valid Advert advert, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			List<ObjectError> errors=bindingResult.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}
			return "create";
		}
		return "adcreated";
	}
}
