package com.careerit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.entity.Mobile;
import com.careerit.service.MobileService;

@RestController
@CrossOrigin
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	
	@GetMapping("/mobiles")
	public List<Mobile> getAllMobiles(){
		return mobileService.getAllMobiles();
	}
}
