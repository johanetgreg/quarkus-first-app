package org.johanetgreg.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class BookRepository {
	
	@ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
	String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
            new Book(2, "Practicing Quarkus", "Antonio", 2020, genre),
            new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
            new Book(4, "Thinking in Java", "Bruce Lee", 1998, genre)
        );
    }
    
    
    public Optional<Book> getBook(int id) {
    	return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
    
}
