package com.careerit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.careerit.entity.Laptop;
import com.careerit.repository.LaptopRepository;

@Service
public class LaptopService {
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Autowired
	private S3Service s3Service;
	
	public List<Laptop> getAllLaptops(){
		return laptopRepository.findAll();
	}
	
	
	public Laptop createLaptop(Double cost,
            String name,
            Integer qty,
            MultipartFile image) throws IOException {

		// Upload image to S3
		String imageUrl = s3Service.uploadFile(image);
		
		// Create entity
		Laptop laptop = new Laptop();
		laptop.setCost(cost);
		laptop.setName(name);
		laptop.setQty(qty);
		laptop.setImage(imageUrl);
		
		// Save to DB
		return laptopRepository.save(laptop);
}
	
}
