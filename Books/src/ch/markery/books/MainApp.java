package ch.markery.books;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import ch.markery.books.model.Book;
import ch.markery.books.view.BookControler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Joselu
 *	@version 0.1
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Book> bookData = FXCollections.observableArrayList();
    
    /**
     * Constructor to charge data
     */
    public MainApp(){
    	bookData.add(new Book("El lazarillo de Tormes","Anónimo"));
    	bookData.add(new Book("Don Quijote","Miguel de Cervantes"));
    	bookData.add(new Book("Don Juan Tenorio","José Zorrilla"));
    	bookData.add(new Book("Rimas","Gustavo Adolfo Bécquer"));
    	bookData.add(new Book("Soleadades","Antonio Machado"));
    	bookData.add(new Book("Luces de Bohemia","Ramón María del Valle Inclán"));
    	bookData.add(new Book("La casa de Bernarda Alba","Federico García Lorca"));
    	bookData.add(new Book("Nada","Carmen Laforet"));
    	bookData.add(new Book("El camino","Miguel Delibes"));
    	bookData.add(new Book("Cien años de soledad","Gabriel García Márquez"));
    }
    /**
    * Returns the data as an observable list of Books. 
    * @return
    */
   public ObservableList<Book> getBookData() {
       return bookData;
   }

   
   
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showBooks();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showBooks() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Books.fxml"));
            AnchorPane Book = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(Book);
            
            //Give the controller access to the main app.
            BookControler control = loader.getController();
            control.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public boolean showBooksEditDialog(Book book) {
//        try {
//            // Load the fxml file and create a new stage for the popup dialog.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//
//            // Create the dialog Stage.
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Edit Person");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(primaryStage);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//
//            // Set the book into the controller.
//            BookControler controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setC
//
//            // Show the dialog and wait until the user closes it
//            dialogStage.showAndWait();
//
//            return controller.isOkClicked();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }
    
    public static void main(String[] args) {
    	
        launch(args);
    }
}
