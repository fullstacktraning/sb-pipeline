package com.careerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.entity.Mobile;
import com.careerit.repository.MobileRepository;

@Service
public class MobileService {
	@Autowired
	private MobileRepository mobileRepository;
	
	public List<Mobile> getAllMobiles(){
		return mobileRepository.findAll();
	}
}
