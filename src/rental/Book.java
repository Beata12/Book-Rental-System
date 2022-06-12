package rental;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private String bookId;
    private String bookAuthor;
    private String bookTitle;
    private int bookYear;
    private boolean booked = false;

    public Book(String bookId, String bookAuthor, String bookTitle, int bookYear) {
        this(bookId, bookAuthor, bookTitle, bookYear, false);
    }

    @JsonCreator //tworzenie formy tekstowej
    public Book(@JsonProperty("Id") String bookId,
                @JsonProperty("author") String bookAuthor,
                @JsonProperty("title") String bookTitle,
                @JsonProperty("year") int bookYear,
                @JsonProperty("booked") boolean booked) {
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookYear = bookYear;
        this.booked = booked;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getBookYear() {
        return bookYear;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id = '" + bookId + '\'' +
                ", author = '" + bookAuthor + '\'' +
                ", title = '" + bookTitle + '\'' +
                ", year = '" + bookYear + '\'' +
                ", booked = " + booked +
                '}';
    }
}
