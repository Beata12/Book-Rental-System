package rental;

import java.util.HashMap;

public class BookRental {

    private FileData fileData;

    public BookRental() {
        this.fileData = fileData;
    }

    public void addBook(Book book) {
        HashMap<String, Book> books = uploadBooks();
        books.put(book.getBookId(), book);
        fileData.saveBooks(books);
    }

    public void displayAllBooks() {
        System.out.println("All books: ");
        for (Book book : uploadBooks().values()) {
            System.out.println(book);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("All available books: ");
        for (Book book : uploadBooks().values()) {
            if(!book.isBooked()) {
                System.out.println(book);
            }
        }
    }

    public void booked(String bookId) {
        HashMap<String, Book> books = uploadBooks();
        books.get(bookId).setBooked(true);
        fileData.saveBooks(books);
    }

    public void returned(String bookId) {
        HashMap<String, Book> books = uploadBooks();
        books.get(bookId).setBooked(false);
        fileData.saveBooks(books);
    }

    private HashMap<String, Book> uploadBooks() {
        return new HashMap<>(fileData.uploadBooks());
    }
}
