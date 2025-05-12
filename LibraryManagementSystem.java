// Custom Exception for Book Not Found
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    String title;
    boolean issued;

    public Book(String title) {
        this.title = title;
        this.issued = false;
    }
}

// Library Class
class Library {
    Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void issueBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.title.equals(title)) {
                if (!book.issued) {
                    book.issued = true;
                    System.out.println(title + " issued successfully");
                    return;
                } else {
                    System.out.println(title + " is already issued");
                    return;
                }
            }
        }
        throw new BookNotFoundException(title + " not found in library");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.issued = false;
                System.out.println(title + " returned successfully");
                return;
            }
        }
        System.out.println(title + " not found in library");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java"),
            new Book("Python"),
            new Book("C++")
        };

        Library library = new Library(books);

        try {
            library.issueBook("Java");
            library.issueBook("C++");  // Fixed here
            library.issueBook("OOP's");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

      library.returnBook("Java");
    }
}
