package ch.markery.books.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.markery.books.MainApp;
import ch.markery.books.model.Book;

public class BookControler {
	  @FXML
	    private TableView<Book> bookTable;
	    @FXML
	    private TableColumn<Book, String> titleColumn;
	    @FXML
	    private TableColumn<Book, String> typeColumn;
	    
	    @FXML
	    private Label titleLabel;
	    @FXML
	    private Label typeLabel;
	    @FXML
	    private Label editorialLabel;
	    @FXML
	    private Label pageLabel;
	    @FXML
	    private Label authorLabel;
	    @FXML
	    private Label VersionLabel;
	    
	 // Reference to the main application.
	    private MainApp mainApp;

	    /**
	     * The constructor.
	     * The constructor is called before the initialize() method.
	     */
	    public BookControler () {
	    }

	    /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML
	    private void initialize() {
	        // Initialize the person table with the two columns.
	        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitle());
	        typeColumn.setCellValueFactory(cellData -> cellData.getValue().getType());
	    }

	    /**
	     * Is called by the main application to give a reference back to itself.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	        // Add observable list data to the table
	        bookTable.setItems(mainApp.getBookData());
	    }
	}
