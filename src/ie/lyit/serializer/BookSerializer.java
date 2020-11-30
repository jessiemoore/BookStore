package ie.lyit.serializer;

import java.util.*;
import ie.lyit.book.Book;
import java.io.*;

public class BookSerializer {
	private ArrayList<Book> books;

	final String FILENAME = "books.ser";

	public BookSerializer() {
		books = new ArrayList<>();
	}

	public void add() {
		// Create a Book Object
		// call its read method , to read book from user , add the book to array list
		Book book = new Book();
		book.read();
		books.add(book);
	}

	public void list() {
		for (Book tmpBook : books)
			System.out.println(tmpBook);
	}

	public Book view() {
		Scanner kbInt = new Scanner(System.in);
		// Read the key field of the Book to be viewed from the user
		System.out.println("Enter libaray number of book");
		int bookToView = kbInt.nextInt();
		// Loop around for every Book object in the ArrayList
		for (Book tmpBook : books) {
			// If its key field equals the key field of the Book to be viewed
			if (tmpBook.getLibraryNumber() == bookToView) {
				// Display the object on screen.
				System.out.println(tmpBook);
				// And return it.
				return tmpBook;
			}
		}

		// if we reach this point book was not found return null
		return null;
	}

	public void delete() {
		// Call the view() method to find, display, and return the Book to be deleted
		Book tempBook = view();
		// If the Book to be deleted != null
		if (tempBook != null)
			// Delete it from the ArrayList by calling the ArrayList
			books.remove(tempBook);
	}

	public void edit() {
		// Call the view() method to find, display, and return the Book to be edited
		Book tempBook = view();
		// If the Book to be edited != null
		if (tempBook != null) {
			int index = books.indexOf(tempBook);

			// Read in new details for it by calling it’s read()method
			tempBook.read();
			// Reset it in the ArrayList to this new object using the ArrayList set()
			// method.
			books.set(index, tempBook);
		}
	}

	public void serializeBooks() {
		/*
		 * Create a FileOutputStream object, passing the name of the binary File to be
		 * created, Connect it to an ObjectOutputStream object, Call its writeObject()
		 * method to write the entire ArrayList instance variable to the file, and Call
		 * its close() method to close the file
		 */
		ObjectOutputStream os = null;
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			os = new ObjectOutputStream(fileStream);
			os.writeObject(books);

		} catch (FileNotFoundException fnfe) {
			System.out.println("Cannot create file to store books.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			try {
				os.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}

	}

	public void dserializeBooks() {
		/*
		 * Create a FileOutputStream object, passing the name of the binary File to be
		 * created, Connect it to an ObjectOutputStream object, Call its writeObject()
		 * method to write the entire ArrayList instance variable to the file, and Call
		 * its close() method to close the file
		 */
		ObjectInputStream is = null;
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
			is = new ObjectInputStream(fileStream);
			books = (ArrayList<Book>) is.readObject();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Cannot create file to store books.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}

	}
}
