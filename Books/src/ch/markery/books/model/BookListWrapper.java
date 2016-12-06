package ch.markery.books.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "books")
public class BookListWrapper {
	 private List<Book> books;

	    @XmlElement(name = "person")
	    public List<Book> getPersons() {
	        return books;
	    }

	    public void setPersons(List<Book> persons) {
	        this.books = books;
	    }
	}
