package com.techreads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.techreads.model.Book;
import com.techreads.repository.BookRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	protected BookRepository bookRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (bookRepository.count() < 3) {
			bookRepository.save(new Book("Beginning Groovy and Grails"));
			bookRepository.save(new Book("Pro Eclipse JST"));
			bookRepository.save(new Book("Enterprise Java Development on a Budget"));
		}
	}
}