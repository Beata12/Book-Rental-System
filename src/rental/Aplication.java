package rental;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

public class Aplication {

    public static void main(String[] args) {

        FileData fileData = new FileData(new File("library.json"));

        BookRental bookRental = new BookRental();

        String action = "";
        do {
            action = userInput("action");
            if ("add a book".equalsIgnoreCase(action)) {
                addBook(bookRental);
            } else if ("display books".equalsIgnoreCase(action)) {
                bookRental.displayAllBooks();
            } else if ("check the book".equalsIgnoreCase(action)) {
                String bookId = userInput("bookId");
                bookRental.booked(bookId);
                System.out.println("You checked out the book of id: " + bookId);
            } else if ("return the book".equalsIgnoreCase(action)) {
                String bookId = userInput("bookId");
                bookRental.returned(bookId);
                System.out.println("You returned the book of id: " + bookId);
            } else if ("display available books".equalsIgnoreCase(action)) {
                bookRental.displayAvailableBooks();
            } else if (!"leave".equalsIgnoreCase(action)) {
                System.out.println("This action is not available. Try one more time. Available action: \n- add a book \n- check the book \n- return the book \n- display books \n- display available books \n- leave");
            }
        } while (!"leave".equalsIgnoreCase(action));
    }

    private static void addBook(BookRental bookRental) {
        String bookId = userInput("the id of the book");
        String bookAuthor = userInput("the author of the book (name, surname)");
        String bookTitle = userInput("the title of the book");
        int bookYear = checkIntInput("the year of the book");
        Book book = new Book(bookId, bookAuthor, bookTitle, bookYear);
        bookRental.addBook(book);
        bookRental.displayAllBooks();
    }

    private static String userInput(String factorName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + factorName + ": ");
        String value = scanner.nextLine();
        return value;
    }

    private static int checkIntInput(String nameOfParameter) {
        Scanner scanner = new Scanner(System.in);
        Optional<Integer> number = Optional.empty();
        do {
            System.out.print("Enter " + nameOfParameter + ": ");
            try {
                number = Optional.of(Integer.valueOf(scanner.nextLine()));
            } catch (NumberFormatException numberFormatException) {
                System.out.println("You enter wrong data. Please try again.");
            }
        } while (number.isEmpty());
        return number.get();
    }
}
