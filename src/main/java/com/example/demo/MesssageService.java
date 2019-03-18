package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MesssageService {

	@Autowired
	private MessageRepository repository;
	
	public List<Message> getRecentMessages(Integer n) {
		return repository.findByOrderByIdDesc(new PageRequest(0, n));
	}
	
	@Transactional
	public void save(Message message) {
		repository.save(message);
	}
}
