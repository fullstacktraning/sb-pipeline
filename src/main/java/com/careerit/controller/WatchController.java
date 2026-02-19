package com.careerit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.entity.Watch;
import com.careerit.service.WatchService;

@RestController
@CrossOrigin
public class WatchController {
	@Autowired
	private WatchService watchService;
	
	@GetMapping("/watches")
	public List<Watch> getAllWatches(){
		return watchService.getAllwatches();
	}
}
