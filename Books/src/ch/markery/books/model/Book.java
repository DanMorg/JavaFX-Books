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
 * @author Daniel Morgado
 *
 */
public class Book  {

	
	private static String title;
    private static String type;
    private static String author;
    private static String editorial;
    private static Integer pages;
    private static String version;

    /**
     * Default constructor.
     */
    public Book() {
        this(null, null);
    }
    /**
     * Info of the book
     * @param title
     * @param type
     */
    public Book(String title, String type) {
        this.title = new String(title);
        this.type = new String(type);

        // Some initial dummy data, just for convenient testing.
        this.author = new String("someone");
        this.pages = new Integer(100);
        this.editorial = new String("some city");
        this.version = new String(null, 1999, 2, 21);
    }
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public String getAuthor() {
		return author;
	}
	public String getEditorial() {
		return editorial;
	}
	public Integer getPages() {
		return pages;
	}
	public String getVersion() {
		return version;
	}
	
	public void setTitle(String string){
		this.title=string;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public void setPages(Integer pages){
		this.pages=pages;
	}
	public void setVersion(String version){
		this.version=version;
	}
	public void setStreet(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setLastName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCity(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setPostalCode(int parseInt) {
		// TODO Auto-generated method stub
		
	}
	public void setBirthday(LocalDate parse) {
		// TODO Auto-generated method stub
		
	}
	
}
