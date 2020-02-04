package com.techreads.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.techreads.model.Book;
import com.techreads.repository.BookRepository;

@Controller 
@RequestMapping("/books")
public class BookController {
	@Autowired 
	BookRepository bookRepository;
	@RequestMapping({"","/"})
	public ModelAndView books() {
		ModelAndView mav = new ModelAndView("books");
		List<Book> books = bookRepository.findAll();
		mav.addObject("books", books);
		return mav;
	} 
	
	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("bookForm", new Book());
		return "add";
	} 
	
	@RequestMapping(value={"", "/"}, method=POST)
	public RedirectView addBook(Book book) {
		bookRepository.saveAndFlush(book);
		return new RedirectView("books");
	}
	
	@RequestMapping("delete/{bookId}")
	public String delete(@PathVariable (name="bookId") int bookId, Model model) {
		long longId = bookId;
		Book book = bookRepository.getOne(longId);
		bookRepository.delete(book);
		return "redirect:/books";
	}
}