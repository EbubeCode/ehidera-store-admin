package com.adminportal.controller;

import java.util.ArrayList;

import com.adminportal.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.BookService;

@RestController
public class ResourceController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/book/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> bookIdList, Model model
			){
		
		for (String id : bookIdList) {
			String bookId =id.substring(8);
			bookRepository.deleteById(Long.parseLong(bookId));
		}
		
		return "delete success";
	}
}
