package com.careerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.entity.Watch;
import com.careerit.repository.WatchRepository;

@Service
public class WatchService {
	@Autowired
	private WatchRepository watchRepository;
	
	public List<Watch> getAllwatches(){
		return watchRepository.findAll();
	}
}
