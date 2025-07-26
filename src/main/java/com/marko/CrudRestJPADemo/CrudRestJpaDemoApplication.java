package com.marko.CrudRestJPADemo;

import com.marko.CrudRestJPADemo.components.Book;
import com.marko.CrudRestJPADemo.components.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CrudRestJpaDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestJpaDemoApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Book> bookList = new ArrayList<>();
		Book book1 = new Book();
		book1.setTitle("Book 1");
		book1.setAuthor("Author 1");
		book1.setPrice(11.22);
		book1.setImageUrl("https://fastly.picsum.photos/id/391/200/300.jpg?hmac=3xP-y2PRN2E0__aPOCp1sja7XrimKgLQAMiSaNd0Cko");

		Book book2 = new Book();
		book2.setTitle("Book 2");
		book2.setAuthor("Author 2");
		book2.setPrice(22.45);
		book2.setImageUrl("https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U");

		Book book3 = new Book();
		book3.setTitle("Book 3");
		book3.setAuthor("Author 3");
		book3.setPrice(9.89);
		book3.setImageUrl("https://fastly.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI");

		Book book4 = new Book();
		book4.setTitle("Book 4");
		book4.setAuthor("Author 4");
		book4.setPrice(19.5);
		book4.setImageUrl("https://fastly.picsum.photos/id/39/200/300.jpg?hmac=CcUiRU6-82MldMqtiF9shpKCbwzwkILEWuRi90JsADs");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);

		for(Book book : bookList) {
			bookRepository.save(book);
		}
	}
}
