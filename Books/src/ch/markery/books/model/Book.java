package ch.markery.books.model;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

/**
 * Data information
 * 
 * @author Daniel Morgado
 *
 */
public class Book {

	private static StringProperty title;
	private static StringProperty type;
	private static StringProperty author;
	private static StringProperty editorial;
	private static IntegerProperty pages;
	private static StringProperty version;

	/**
	 * Default constructor.
	 */
	public Book() {
		this(null, null);
	}

	/**
	 * Info of the book
	 * 
	 * @param title
	 * @param type
	 */
	public Book(String title, String type) {
		this.title = new SimpleStringProperty(title);
		this.type = new SimpleStringProperty(type);

		// Some initial dummy data, just for convenient testing.
		this.author = new SimpleStringProperty("someone");
		this.pages = new SimpleIntegerProperty(100);
		this.editorial = new SimpleStringProperty("some city");
		this.version = new SimpleStringProperty("v1");
	}

	public StringProperty getTitle() {
		return title;
	}

	public StringProperty getType() {
		return type;
	}

	public StringProperty getAuthor() {
		return author;
	}

	public StringProperty getEditorial() {
		return editorial;
	}

	public IntegerProperty getPages() {
		return pages;
	}

	public StringProperty getVersion() {
		return version;
	}

	public void setTitle(String string) {
		this.title = new SimpleStringProperty(string);
	}

	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}

	public void setAuthor(String author) {
		this.author = new SimpleStringProperty(author);
	}

	public void setPages(Integer pages) {
		this.pages = new SimpleIntegerProperty(pages);
	}

	public void setVersion(String version) {
		this.version = new SimpleStringProperty(version);
	}

	// Do not use in our proyect
	/*
	 * @XmlJavaTypeAdapter(LocalDateAdapter.class) public LocalDate
	 * getBirthday() { return birthday.get(); }
	 */
}
