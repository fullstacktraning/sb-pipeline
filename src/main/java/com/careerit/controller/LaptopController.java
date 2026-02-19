package com.careerit.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careerit.entity.Laptop;
import com.careerit.service.LaptopService;

@RestController
@CrossOrigin
public class LaptopController {
	@Autowired
	private LaptopService laptopService;
	
	@GetMapping("/laptops")
	public List<Laptop> getAllLaptops(){
		return laptopService.getAllLaptops();
	}
	
	@PostMapping("/laptops")
    public Laptop createLaptop(
            @RequestParam Double cost,
            @RequestParam String name,
            @RequestParam Integer qty,
            @RequestParam MultipartFile image
    ) throws IOException {

        return laptopService.createLaptop(cost, name, qty, image);
    }
}
