package com.mgmetehan.bookservice;

import com.mgmetehan.bookservice.model.Book;
import com.mgmetehan.bookservice.respository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
@RequiredArgsConstructor
public class BookServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	private final BookRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder()
				.title("Book 1")
				.bookYear(2023)
				.author("Author 1")
				.pressName("Press 1")
				.isbn("978-1111111111")
				.build();

		Book book2 = Book.builder()
				.title("Book 2")
				.bookYear(2023)
				.author("Author 2")
				.pressName("Press 2")
				.isbn("980-2222222222")
				.build();

		Book book3 = Book.builder()
				.title("Book 3")
				.bookYear(2023)
				.author("Author 3")
				.pressName("Press 3")
				.isbn("988-3333333333")
				.build();

		List<Book> bookList = repository.saveAll(Arrays.asList(book1, book2, book3));

		log.info("Book list: {}", bookList);

	}
}
