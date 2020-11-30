package ie.lyit.tester;
import ie.lyit.serializer.*;
import ie.lyit.*;
import ie.lyit.book.Menu;

public class BookSerializerTester {

	public static void main(String[] args) {
	//	Create an object of the BookSerializer class
		BookSerializer bookSerializer = new BookSerializer();
	//	 Call it’s add() method twice
	//	bookSerializer.add();
	//	bookSerializer.add();
		
	//	Call it’s serializeBooks() method to write the entire ArrayList to the File
	//	bookSerializer.serializeBooks();
		
	//	bookSerializer.dserializeBooks();
	//	bookSerializer.list();
		
	// Create an object of the BookSerializer class
		
		// Call it’s deserializeBooks() method to read the entire ArrayList from the File into the ArrayList instance variable
		bookSerializer.dserializeBooks();
		// Create an object of the Menu class Repeatedly
		Menu menu = new Menu();
		
		do {
		// Call the Menu objects display() method,
			menu.display();
		// Call the Menu objects readOption() method,
			menu.readOption();
		// switch on the chosen option and call the appropriate method 
			switch(menu.getOption()) {
			case 1:bookSerializer.add(); break;
			case 2:bookSerializer.list(); break;
			case 3:bookSerializer.view(); break;
			case 4:bookSerializer.edit(); break;
			case 5:bookSerializer.delete(); break;
			case 6: break;
			}
			}while(menu.getOption() !=6);
			
		// BookSerializer object created above, depending on the option entered by the user.
		//while option != 6
		// Call the BookSerializer objects serializeBooks() method to write the	entire ArrayList from the ArrayList instance variable to the File.
		bookSerializer.serializeBooks();
	}

}
